package com.revature.services;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.revature.daos.QuizHistoryDaoImpl;
import com.revature.pojos.Notification;
import com.revature.pojos.QuizHistory;
import com.revature.pojos.User;
import com.revature.util.ConnectionUtil;

@Service("QuizHistoryService")
public class QuizHistoryService {

	QuizHistoryDaoImpl QHDI = new QuizHistoryDaoImpl();
	
	public User addQuizHistory(User u, QuizHistory qh) {
		Session sess = ConnectionUtil.getSession();
		Transaction tx = sess.beginTransaction();
		sess.merge(u);	
		QHDI.putQuizHistory(qh);
		u.getQuizHistories().add(qh);
		sess.merge(u);
		System.out.println("Committing...");
		tx.commit();
		sess.flush();
		System.out.println("Committed...");
		sess.merge(u);
		
		return u;
	}
	
	public QuizHistory getUserQuizHistory(User u, int quizHistoryId) {
		for(QuizHistory qh : u.getQuizHistories()) {
			if(quizHistoryId == qh.getHistId()) {
				return qh;
			}
		}
		return null;
	}
	
	
	public Set<QuizHistory> getUserQuizHistories(User u){
		return u.getQuizHistories();
	}
	
	public User deleteQuizHistory (User u, int quizHistoryId) {
		Session sess = ConnectionUtil.getSession();
		System.out.println("Delete Quiz History");
		Transaction tx = sess.beginTransaction();
		
		Query query = sess.createQuery("from QuizHistory QH where QH.histId="+quizHistoryId);
		List<QuizHistory> quizHistories = query.list();
		System.out.println(quizHistories);
		for(QuizHistory temp : quizHistories) {
			if(quizHistoryId == temp.getHistId()) {
				u.getQuizHistories().remove(temp);
				QuizHistory delQH = (QuizHistory) sess.get(QuizHistory.class, temp.getHistId());
				sess.merge(delQH);
				sess.delete(delQH);
				
				System.out.println("Deleted Quiz History...");
				break;
			}
		}
		
		
		System.out.println("Committing...");
		tx.commit();
		System.out.println("Committed...");
		sess.merge(u);
		return u;
	}
	

}
