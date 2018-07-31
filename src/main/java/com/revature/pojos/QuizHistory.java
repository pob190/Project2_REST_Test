package com.revature.pojos;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="P2_QUIZHISTORY")
public class QuizHistory {

	@Id
	@SequenceGenerator(name="P2_HIST_ID_SEQ", sequenceName="P2_HIST_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="P2_HIST_ID_SEQ")
	@Column(name="HISTID")
	private int histId;
	
	@Column(name="QUIZID")
	private int quizId;
	
	@Column(name="PASSINGGRADE")
	private int passingGrade;
	
	@Column(name="SCORE")
	private int score;
	
	@Column(name="COMPLETEDATE")
	private Date completeDate;


	public QuizHistory() {
		super();
		// TODO Auto-generated constructor stub
	}


	public QuizHistory(int histId, int quizId, int passingGrade, int score, Date completeDate) {
		super();
		this.histId = histId;
		this.quizId = quizId;
		this.passingGrade = passingGrade;
		this.score = score;
		this.completeDate = completeDate;
	}


	public int getHistId() {
		return histId;
	}


	public void setHistId(int histId) {
		this.histId = histId;
	}


	public int getQuizId() {
		return quizId;
	}


	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}


	public int getPassingGrade() {
		return passingGrade;
	}


	public void setPassingGrade(int passingGrade) {
		this.passingGrade = passingGrade;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public Date getCompleteDate() {
		return completeDate;
	}


	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}


	@Override
	public String toString() {
		return "QuizHistory [histId=" + histId + ", quizId=" + quizId + ", passingGrade=" + passingGrade + ", score="
				+ score + ", completeDate=" + completeDate + "]";
	}
	
	
}
