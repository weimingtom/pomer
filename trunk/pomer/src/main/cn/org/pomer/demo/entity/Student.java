package cn.org.pomer.demo.entity;

// default package

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import cn.org.pomer.entity.BaseEntity;

/**
 * Student entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "student", catalog = "pomer", uniqueConstraints = {})
public class Student extends BaseEntity {

	// Fields
	private String name;
	private Date birthDay;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(Long id) {
		this.id = id;
	}

	public Student(Long id, String name, Date birthDay) {
		super();
		this.id = id;
		this.name = name;
		this.birthDay = birthDay;
	}

	@Column(name = "name", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birthDay", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public Date getBirthDay() {
		return this.birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

}