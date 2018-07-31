package com.revature.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "P2_QUESTION")
public class Question {
	
	
	@Id
	@SequenceGenerator(name = "P2_QUESTION_ID_SEQ", sequenceName = "P2_QUESTION_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "P2_QUESTION_ID_SEQ")
	@Column(name = "QUESTIONID")
	private int quesitonId;
	
	@Column(name = "QUESTIONTEXT")
	private String questionText;
	
	@Column(name = "ANSWER1")
	private String answer1;
	
	@Column(name = "ANSWER2")
	private String answer2;
	
	@Column(name = "ANSWER3")
	private String answer3;
	
	@Column(name = "ANSWER4")
	private String answer4;
	
	@Column(name = "KEY")
	private String key;


	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Question(int quesitonId, String questionText, String answer1, String answer2, String answer3, String answer4,
			String key) {
		super();
		this.quesitonId = quesitonId;
		this.questionText = questionText;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
		this.key = key;
	}


	@Override
	public String toString() {
		return "Question [quesitonId=" + quesitonId + ", questionText=" + questionText + ", answer1=" + answer1
				+ ", answer2=" + answer2 + ", answer3=" + answer3 + ", answer4=" + answer4 + ", key=" + key + "]";
	}


	public int getQuesitonId() {
		return quesitonId;
	}


	public void setQuesitonId(int quesitonId) {
		this.quesitonId = quesitonId;
	}


	public String getQuestionText() {
		return questionText;
	}


	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}


	public String getAnswer1() {
		return answer1;
	}


	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}


	public String getAnswer2() {
		return answer2;
	}


	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}


	public String getAnswer3() {
		return answer3;
	}


	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}


	public String getAnswer4() {
		return answer4;
	}


	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}


	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}
}
