package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.pojos.QuizHistory;
import com.revature.pojos.User;
import com.revature.util.ConnectionUtil;

public class QuizHistoryDaoImpl implements QuizHistoryDao {

	public QuizHistory getQuizHistory(int id) {
		return (QuizHistory) ConnectionUtil.getSession().get(QuizHistory.class, id);
	}

	public QuizHistory putQuizHistory(QuizHistory qh) {
		Session sess = ConnectionUtil.getSession();

		Transaction tx = sess.beginTransaction();

		sess.save(qh);

		tx.commit();

		return qh;
	}

	public List<QuizHistory> getAllQuizHistories() {
		return ConnectionUtil.getSession().createQuery("from QuizHistory").list();
	}

	public QuizHistory updateQuizHistory(QuizHistory qh, int id) {
		QuizHistory oldQH = (QuizHistory) ConnectionUtil.getSession().get(QuizHistory.class, id);
		qh.setCompleteDate(oldQH.getCompleteDate());
		qh.setHistId(oldQH.getHistId());
		qh.setPassingGrade(oldQH.getPassingGrade());
		qh.setQuizId(oldQH.getQuizId());
		qh.setScore(oldQH.getScore());
		return qh;
	}

	public void DeleteQuizHistory(QuizHistory qh) {
		ConnectionUtil.getSession().delete(qh);
	}

}
