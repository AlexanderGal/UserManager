package main.entity;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="frameworks")
public class Frameworks {
	@Id
	@GenericGenerator(name="increment",strategy="increment")
	@GeneratedValue(generator="increment")
	@Column(name="id", length=6, nullable=false, unique=true)
	private Long id;
	
	@Column(name="frameworkName")
	private String frameworkName;
	
	@Column(name="description")
	private String desc;

	public Frameworks() {
		super();
	}
	public Frameworks(String name) {
		this.frameworkName = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFrameworkName() {
		return frameworkName;
	}
	public void setFrameworkName(String frameworkName) {
		this.frameworkName = frameworkName;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return frameworkName;
	}
}