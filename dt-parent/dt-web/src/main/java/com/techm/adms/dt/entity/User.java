package com.techm.adms.dt.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="users")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public User(){
		super();
	}
	
	public User(int id, String userId, String password, String firstName,
			String lastName, String address, String eMail, String phoneNumber,
			Date createdDate, String active) {
		super();
		this.id = id;
		this.userId = userId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.eMail = eMail;
		this.phoneNumber = phoneNumber;
		this.createdDate = createdDate;
		this.active = active;
	}

	@Id
	@Column(name="Id")
	private int id;
	
	@Column(name="UserId")
	private String userId;
	
	@Column(name="password")
	private String password;
	
	@Column(name="FirstName")
	private String firstName;
	
	@Column(name="LastName")
	private String lastName;
	
	@Column(name="Address")
	private String address;
	
	@Column(name="Email")
	private String eMail;
	
	@Column(name="PhoneNumber")
	private String phoneNumber;

	@Column(name="CreatedDate",insertable=false)
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	@Column(name="Active")
	private String active;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", password="
				+ password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", address=" + address + ", eMail=" + eMail
				+ ", phoneNumber=" + phoneNumber + ", createdDate="
				+ createdDate + ", active=" + active + "]";
	}
	
	

}
