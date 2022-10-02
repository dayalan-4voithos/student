package net.tao.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import net.tao.constants.Gender;
import net.tao.domain.Student;

@JsonInclude(Include.NON_NULL)
public class StudentDto {

	
	private Integer id;

	private String name;

	private String address;

	private Gender gender;

	private Date dob;

	private String email;

	private String mobile;

	private String phone;

	public StudentDto() {

	}

	public StudentDto(Student studetnt) {
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
