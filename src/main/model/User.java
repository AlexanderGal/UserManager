package main.model;

import java.util.List;

public class User {
	//form:hidden - hidden value
	private Long id;
	//form:input - textbox
	private String name;
	//form:textarea - textbox
	private String email;
	//form:input - textarea
	private String address;
	//form:input-password
	private String password;
	//form:input-password
	private String confrimPassword;
	//form:checkbox - single checkbox
	private boolean newsletter;
	//form:checkboxes - multiple checkboxes
	private List<String> framework;
	//form:radiobutton - radio button
	private String sex;
	//form:radiobuttons-radio button
	private Integer number;
	//form:select - form:option - dropdown - single select
	private String country;
	//form:select-multiple=true - dropdown -multiple select
	private List<String> skill;

	public User() {
		super();
	}

	public boolean isNew() {
		return (this.id == null);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confrimPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confrimPassword = confirmPassword;
	}

	public boolean isNewsletter() {
		return newsletter;
	}

	public void setNewsletter(boolean newsletter) {
		this.newsletter = newsletter;
	}

	public List<String> getFramework() {
		return framework;
	}

	public void setFramework(List<String> framework) {
		this.framework = framework;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<String> getSkill() {
		return skill;
	}

	public void setSkill(List<String> skill) {
		this.skill = skill;
	}
}
