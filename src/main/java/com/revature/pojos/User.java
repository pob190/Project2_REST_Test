package com.revature.pojos;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "P2_USER")
/*
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "userId")
		  */
public class User {

	@Id
	@SequenceGenerator(name = "P2_USER_ID_SEQ", sequenceName = "P2_USER_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "P2_USER_ID_SEQ")
	@Column(name = "USERID")
	private int userId;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "FNAME")
	private String fName;

	@Column(name = "LNAME")
	private String lName;

	@Column(name = "AGE")
	private int age;

	@ElementCollection(targetClass = QuizHistory.class)
	@OneToMany(targetEntity = QuizHistory.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "P2_USERTOQUIZHISTORY", joinColumns = @JoinColumn(name = "USERID"), inverseJoinColumns = @JoinColumn(name = "HISTID"))
	private Set<QuizHistory> QuizHistories;

	@ManyToMany(mappedBy = "users")
	@JsonBackReference
	private Set<Group> groups;

	@ElementCollection(targetClass = Notification.class)
	@OneToMany(targetEntity = Notification.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "P2_USERTONOTE", joinColumns = @JoinColumn(name = "USERID"), inverseJoinColumns = @JoinColumn(name = "NOTEID"))
	private Set<Notification> notes;

	@ElementCollection(targetClass = Quiz.class)
	@OneToMany(targetEntity = Quiz.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "P2_QUIZTOUSER", joinColumns = @JoinColumn(name = "USERID"), inverseJoinColumns = @JoinColumn(name = "QUIZID"))
	private Set<Quiz> quizzes;

	@ElementCollection(targetClass = Group.class)
	@OneToMany(targetEntity = Group.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinTable(name = "P2_LEADERTOGROUP", joinColumns = @JoinColumn(name = "USERID"), inverseJoinColumns = @JoinColumn(name = "GROUPID"))
	
	private Set<Group> ledGroups;
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Set<QuizHistory> getQuizHistories() {
		return QuizHistories;
	}

	public void setQuizHistories(Set<QuizHistory> quizHistories) {
		QuizHistories = quizHistories;
	}

	public User(int userId, String username, String password, String fName, String lName, int age) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.fName = fName;
		this.lName = lName;
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", fName=" + fName
				+ ", lName=" + lName + ", age=" + age + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Set<Quiz> getQuizzes() {
		return quizzes;
	}

	public void setQuizzes(Set<Quiz> quizzes) {
		this.quizzes = quizzes;
	}

	public Set<Notification> getNotes() {
		return notes;
	}

	public void setNotes(Set<Notification> notes) {
		this.notes = notes;
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}
	
	public Set<Group> getLedGroups() {
		return ledGroups;
	}

	public void setLedGroups(Set<Group> ledGroups) {
		this.ledGroups = ledGroups;
	}
}
