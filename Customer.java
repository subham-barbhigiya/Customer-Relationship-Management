package com.project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String firstn_ame;
	@Column
	private String last_name;
	@Column
	private String email;
	@Column
	private String mobile_no;
	@Column
	private int age;
	
public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstn_ame() {
		return firstn_ame;
	}

	public void setFirstn_ame(String firstn_ame) {
		this.firstn_ame = firstn_ame;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
//	--------------------------------------------------------------
	
	
	//	--------------------------------------------------------------------------
	public Customer(int id, String firstn_ame, String last_name, String email, String mobile_no, int age) {
		super();
		this.id = id;
		this.firstn_ame = firstn_ame;
		this.last_name = last_name;
		this.email = email;
		this.mobile_no = mobile_no;
		this.age = age;
	}

	public Customer() {
		super();
		
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstn_ame=" + firstn_ame + ", last_name=" + last_name + ", email=" + email
				+ ", mobile_no=" + mobile_no + ", age=" + age + "]";
	}
	
	
}
