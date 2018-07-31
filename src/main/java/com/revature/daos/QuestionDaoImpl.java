package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.pojos.Question;
import com.revature.util.ConnectionUtil;

public class QuestionDaoImpl implements QuesitonDao {

	public Question getQuestion(int id) {
		return (Question) ConnectionUtil.getSession().get(Question.class, id);
	}

	public Question putQuestion(Question q) {
		Session sess = ConnectionUtil.getSession();

		Transaction tx = sess.beginTransaction();

		sess.save(q);

		tx.commit();

		return q;
	}

	public List<Question> getAllQuestions() {
		return ConnectionUtil.getSession().createQuery("from Question").list();
	}

	public Question updateQuestion(Question q, int id) {
		Question oldQ = (Question) ConnectionUtil.getSession().get(Question.class, id);
		q.setAnswer1(oldQ.getAnswer1());
		q.setAnswer2(oldQ.getAnswer2());
		q.setAnswer3(oldQ.getAnswer3());
		q.setAnswer4(oldQ.getAnswer4());
		q.setKey(oldQ.getKey());
		q.setQuesitonId(oldQ.getQuesitonId());
		q.setQuestionText(oldQ.getQuestionText());
		return q;
	}

	public void deleteQuestion(Question q) {
		Session sess = ConnectionUtil.getSession();

		Transaction tx = sess.beginTransaction();
		sess.delete(q);
		tx.commit();
	}

}
