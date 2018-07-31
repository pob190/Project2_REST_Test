package com.revature.pojos;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "P2_GROUP")
/*@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "groupId")*/
public class Group {

	@Id
	@SequenceGenerator(name = "P2_GROUP_ID_SEQ", sequenceName = "P2_GROUP_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "P2_GROUP_ID_SEQ")
	@Column(name = "GROUPID")
	private int groupId;

	@Column(name = "GROUPNAME")
	private String groupName;

	@Column(name = "GROUPDESC")
	private String groupDesc;

	
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinTable(
        name = "P2_GROUPTOUSER", 
        joinColumns = { @JoinColumn(name = "GROUPID") }, 
        inverseJoinColumns = { @JoinColumn(name = "USERID") }
    )
	@JsonBackReference
	private Set<User> users;
	/*
	@ElementCollection(targetClass = Quiz.class)
	@OneToMany(targetEntity = Quiz.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "GROUPTOQUIZ", joinColumns = @JoinColumn(name = "GROUPID"), inverseJoinColumns = @JoinColumn(name = "QUIZID"))
	private Set<Quiz> quizzes;
	
	public Set<Quiz> getQuizzes() {
		return quizzes;
	}

	public void setQuizzes(Set<Quiz> quizzes) {
		this.quizzes = quizzes;
	}
	*/
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}


	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Group(int groupId, String groupName, String groupDesc) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.groupDesc = groupDesc;
	}

	@Override
	public String toString() {
		return "Group [groupId=" + groupId + ", groupName=" + groupName + ", groupDesc=" + groupDesc + "]";
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupDesc() {
		return groupDesc;
	}

	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}

}
