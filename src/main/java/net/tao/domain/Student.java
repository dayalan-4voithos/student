package net.tao.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import net.tao.constants.Gender;
import net.tao.dto.StudentDto;

@Entity(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "int(10) UNSIGNED")
	private Integer id;

	@Column(name = "name", length = 45, nullable = false, unique = false)
	private String name;

	@Column(name = "address", length = 45, unique = false)
	private String address;

	@Column(columnDefinition = "char(1)")
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(name = "dob")
	private Date dob;

	@Column(name = "email", length = 45, unique = false)
	private String email;

	@Column(name = "mobile", length = 15, unique = false)
	private String mobile;

	@Column(name = "phone", length = 15, unique = false)
	private String phone;

	
	public Student() {
		
	}
	public Student(StudentDto studetnt) {
		this.id = studetnt.getId();
		this.name = studetnt.getName();
		this.address = studetnt.getAddress();
		this.gender = studetnt.getGender();
		this.dob = studetnt.getDob();
		this.email = studetnt.getEmail();
		this.mobile = studetnt.getMobile();
		this.phone = studetnt.getPhone();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + ", gender=" + gender + ", dob=" + dob
				+ ", email=" + email + ", mobile=" + mobile + ", phone=" + phone + "]";
	}

}
