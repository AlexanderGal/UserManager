package main.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//import main.entity.Frameworks;
import main.entity.User;
import main.repository.UserRepository;
import main.validator.UserFormValidator;

@Controller
public class UserController {
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	//private UserService userService;
	private UserRepository userRepository;
	@Autowired
	UserFormValidator userFormValidator;
	//Main page
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index(Model model){
		logger.debug("index()");
		return "redirect:/users";
	}
	//User list page
	@RequestMapping(value="/users", method = RequestMethod.GET)
	public String showAllUsers(Model model){
		logger.debug("showAllUsers()");
		model.addAttribute("users", userRepository.findAll());
		return "list";
	}
	//Use with anotation @Validated at User
	//other way to use in saveOrUpdateUser() - userFormValidator.validate(user,result)
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.setValidator(userFormValidator);
	}
	//save or update user
	//1.@ModelAttribute bind form value
	//2.@Validated form validator
	//3.RedirecAttributes for flash value
	@RequestMapping(value="/users/ad", method = RequestMethod.POST)
	public String saveOrUpdateUser(@ModelAttribute("userForm") @Validated User user,
										BindingResult result, 
										Model model, 
										final RedirectAttributes redirectAttributes){
		logger.debug("saveOrUpdateUser : {}", user);
		if(result.hasErrors()){
			System.out.println(result.getGlobalErrorCount() + result.getNestedPath());
			populateDefaultModel(model);
			return "userform";
		} else {
			//add message to flash scope
			redirectAttributes.addFlashAttribute("css","success");
			if(user.isNew()){
				redirectAttributes.addFlashAttribute("msg","User added succesfully!");
			} else {
				redirectAttributes.addFlashAttribute("msg","User updated successfully!");
			}
			System.out.println("here in else");
			userRepository.saveAndFlush(user);
			//post/redirect/get
			return "redirect:/users/"+user.getId();
			//post/forward/get
			//return "user/list"
		}
	}
	//show add user form
	@RequestMapping(value="/users/add", method=RequestMethod.GET)
	public String showAddUserForm(Model model){
		logger.debug("showAddUserForm()");
		User user = new User();
		// set default value
		user.setName("Test");
		user.setEmail("test@gmail.com");
		user.setAddress("abc 88");
		user.setNewsletter(true);
		user.setSex("M");
//		user.setFramework(new ArrayList<Frameworks>());
		//user.setSkill(new ArrayList<>(Arrays.asList("Spring", "Hibernate", "SQL")));
		user.setCountry("SG");
		user.setNumber(2);
		model.addAttribute("userForm", user);
		populateDefaultModel(model);
		return "userform";
	}
	//show update form
	@RequestMapping(value ="/users/{id}/update", method = RequestMethod.GET)
	public String showUpdateUserForm(@PathVariable("id") Long id, Model model){
		logger.debug("showUpdateUserForm() : {}", id);
		User user = userRepository.findById(id);
		model.addAttribute("userForm",user);
		populateDefaultModel(model);
		return "userform";
	}
	//delete user
	@RequestMapping(value ="/users/{id}/delete", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") Long id, 
								final RedirectAttributes redirectAttributes){
		logger.debug("deleteUser() : {}",id);
		userRepository.delete(id);
		redirectAttributes.addFlashAttribute("css","success");
		redirectAttributes.addFlashAttribute("msg","User is deleted!");
		return "redirect:/users";
	}
	//show user
	@RequestMapping(value="/users/{id}", method = RequestMethod.GET)
	public String showUser(@PathVariable("id")Long id, Model model){
		logger.debug("showUser() id : {}", id);
		User user = userRepository.findById(id);
		if(user == null){
			model.addAttribute("css","danger");
			model.addAttribute("msg","User not found");
		}
		model.addAttribute("user",user);
		return "show";
	}
	private void populateDefaultModel(Model model){
//		List<Frameworks> frameworkList = new ArrayList<Frameworks>();
//		frameworkList.add(new Frameworks("Spring MVC"));
//		frameworkList.add(new Frameworks("Struts 2"));
//		frameworkList.add(new Frameworks("JSF 2"));
//		frameworkList.add(new Frameworks("GWT"));
//		frameworkList.add(new Frameworks("Play"));
//		frameworkList.add(new Frameworks("Apache Wicket"));
//		model.addAttribute("frameworkList", frameworkList);
//		
//		Map<String, String> skill = new LinkedHashMap<String, String>();
//		skill.put("Hibernate", "Hibernate");
//		skill.put("Spring", "Spring");
//		skill.put("Struts", "Struts");
//		skill.put("Groovy", "Groovy");
//		skill.put("Grails", "Grails");
//		model.addAttribute("javaSkillList",skill);
//		
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		model.addAttribute("numberList", numbers);
//		
		Map<String, String> country = new LinkedHashMap<String, String>();
		country.put("US", "United Stated");
		country.put("CN", "China");
		country.put("SG", "Singapore");
		country.put("MY", "Malaysia");
		model.addAttribute("countryList",country);
	}
}
