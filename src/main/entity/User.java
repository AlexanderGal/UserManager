package main.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(length=10,unique=true,nullable=false,name="id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;

	@Column(name="address")
	private String address;
	
	//form:input-password
	@Column(name="password")
	private String password;
	
	
	//form:input-password
	private String confrimPassword;
	
	//form:checkbox - single checkbox
	@Column(name="newsletter")
	private boolean newsletter;
	
//	//form:checkboxes - multiple checkboxes
//	@Column(name="framework")
//	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
//	@JoinColumn(name="frameworks_id")
//	private List<Frameworks> frameworks = new ArrayList<Frameworks>();
	
	//form:radiobutton - radio button
	@Column(name="sex")
	private String sex;
	
	//form:radiobuttons-radio button
	@Column(name="number")
	private Integer number;
	
	//form:select - form:option - dropdown - single select
	@Column(name="country")
	private String country;
	
//	//form:select-multiple=true - dropdown -multiple select
//	@Column(name="skill")
//	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
//	@JoinColumn(name="skill_id")
//	private List<Skill> skill = new ArrayList<Skill>();

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

//	public List<Frameworks> getFramework() {
//		return frameworks;
//	}
//
//	public void setFramework(List<Frameworks> framework) {
//		this.frameworks = framework;
//	}

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

//	public List<Skill> getSkill() {
//		return skill;
//	}
//
//	public void setSkill(List<Skill> skill) {
//		this.skill = skill;
//	}
}
