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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "P2_QUIZ")
public class Quiz {

	@Id
	@SequenceGenerator(name = "P2_QUIZ_ID_SEQ", sequenceName = "P2_QUIZ_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "P2_QUIZ_ID_SEQ")
	@Column(name = "QUIZID")
	private int quizId;

	@Column(name = "QUIZNAME")
	private String QuizName;

	@Column(name = "QUIZDESC")
	private String QuizDesc;

	@Column(name = "NUMOFQUESTIONS")
	private int numOfQuestions;

	@Column(name = "TIMESTAKEN")
	private int timesTaken;

	@Column(name = "PRIVACY")
	private boolean privacy;

	@Column(name = "PASSINGGRADE")
	private int passingGrade;

	@ElementCollection(targetClass = Question.class)
	@OneToMany(targetEntity = Question.class, cascade = CascadeType.ALL)
	@JoinTable(name = "P2_QUIZTOQUESTION", joinColumns = @JoinColumn(name = "QUIZID"), inverseJoinColumns = @JoinColumn(name = "QUESTIONID"))
	private Set<Question> questions;

	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Quiz(int quizId, String quizName, String quizDesc, int numOfQuestions, int timesTaken,
			boolean privacy, int passingGrade) {
		super();
		this.quizId = quizId;
		QuizName = quizName;
		QuizDesc = quizDesc;
		this.numOfQuestions = numOfQuestions;
		this.timesTaken = timesTaken;
		this.privacy = privacy;
		this.passingGrade = passingGrade;
	}

	@Override
	public String toString() {
		return "Quiz [quizId=" + quizId + ", QuizName=" + QuizName + ", QuizDesc=" + QuizDesc + ", numOfQuestions="
				+ numOfQuestions + ", timesTaken=" + timesTaken + ", privacy=" + privacy
				+ ", passingGrade=" + passingGrade + "]";
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public String getQuizName() {
		return QuizName;
	}

	public void setQuizName(String quizName) {
		QuizName = quizName;
	}

	public String getQuizDesc() {
		return QuizDesc;
	}

	public void setQuizDesc(String quizDesc) {
		QuizDesc = quizDesc;
	}

	public int getNumOfQuestions() {
		return numOfQuestions;
	}

	public void setNumOfQuestions(int numOfQuestions) {
		this.numOfQuestions = numOfQuestions;
	}

	public int getTimesTaken() {
		return timesTaken;
	}

	public void setTimesTaken(int timesTaken) {
		this.timesTaken = timesTaken;
	}

	public boolean isPrivate() {
		return privacy;
	}

	public void setPrivacy(boolean privacy) {
		this.privacy = privacy;
	}

	public int getPassingGrade() {
		return passingGrade;
	}

	public void setPassingGrade(int passingGrade) {
		this.passingGrade = passingGrade;
	}
}
