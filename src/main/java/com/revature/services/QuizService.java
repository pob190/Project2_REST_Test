package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.revature.daos.QuestionDaoImpl;
import com.revature.daos.QuizDaoImpl;
import com.revature.pojos.Group;
import com.revature.pojos.Question;
import com.revature.pojos.Quiz;
import com.revature.pojos.User;
import com.revature.util.ConnectionUtil;

@Service("QuizService")
public class QuizService {
	QuestionDaoImpl QUDI = new QuestionDaoImpl();
	QuizDaoImpl QDI = new QuizDaoImpl();
	
	public Quiz getQuiz(String name) {
		List<Quiz> allQuizzes = QDI.getAllQuizzes();
		for(Quiz q : allQuizzes) {
			if(name.equals(q.getQuizName())) {
				return q;
			}
		}
		return null;
	}
	
	
	public List<Quiz> getQuizzesForUser(User u){
		List<Quiz> quizList = new ArrayList<Quiz>();
		List<Quiz> allQuizzes = QDI.getAllQuizzes();

		return allQuizzes;
	}
	
	public void addQuiz(User u, Quiz q) {
		Session sess = ConnectionUtil.getSession();
		Transaction tx = sess.beginTransaction();
		for(Question qu : q.getQuestions()) {
			QUDI.putQuestion(qu);
		}
		QDI.putQuiz(q);
		u.getQuizzes().add(q);
		

		tx.commit();
		sess.merge(u);
	}
	
	public void deleteQuiz(User u, String name) {
		Session sess = ConnectionUtil.getSession();
		System.out.println("Delete Quiz");
		Transaction tx = sess.beginTransaction();
		for(Quiz q : u.getQuizzes()) {
			if(name.equals(q.getQuizName())) {
				u.getQuizzes().remove(q);
				Quiz delQ = (Quiz) sess.get(Quiz.class, q.getQuizId());
				/*
				sess.merge(q);
				System.out.println("Out of loop...");
				u.getQuizzes().remove(q);
				
				sess.merge(q);
				*/
				sess.delete(delQ);
				
				System.out.println("Deleted Quiz...");
				break;
			}
		}
		System.out.println("Committing...");
		tx.commit();
		System.out.println("Committed...");
		sess.merge(u);
	}
}
