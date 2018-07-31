package com.revature.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="P2_ADMIN")
public class Admin {

	@Id
	@SequenceGenerator(name="P2_ADMIN_ID_SEQ", sequenceName="P2_ADMIN_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="P2_ADMIN_ID_SEQ")
	@Column(name="ADMINID")
	private int adminID;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="FNAME")
	private String fName;
	
	@Column(name="LNAME")
	private String lName;
	
	@Column(name="AGE")
	private int age;

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Admin [adminID=" + adminID + ", password=" + password + ", fName=" + fName + ", lName=" + lName
				+ ", age=" + age + "]";
	}

	public Admin(int adminID, String password, String fName, String lName, int age) {
		super();
		this.adminID = adminID;
		this.password = password;
		this.fName = fName;
		this.lName = lName;
		this.age = age;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
}
