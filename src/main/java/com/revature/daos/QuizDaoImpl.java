package com.revature.daos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.pojos.Question;
import com.revature.pojos.Quiz;
import com.revature.util.ConnectionUtil;

public class QuizDaoImpl implements QuizDao {

	public Quiz getQuiz(int id) {
		return (Quiz) ConnectionUtil.getSession().get(Quiz.class, id);
	}

	public Quiz putQuiz(Quiz q) {
		Session sess = ConnectionUtil.getSession();

		Transaction tx = sess.beginTransaction();

		sess.save(q);

		tx.commit();

		return q;
	}

	public List<Quiz> getAllQuizzes() {
		return ConnectionUtil.getSession().createQuery("from Quiz").list();
	}

	public Quiz addQuiz(Quiz q) {
		Session sess = ConnectionUtil.getSession();

		Transaction tx = sess.beginTransaction();

		q.setQuestions(new HashSet<Question>());

		sess.save(q);

		tx.commit();

		return q;
	}

	public Quiz updateQuiz(Quiz q, int id) {
		Quiz oldQ = (Quiz) ConnectionUtil.getSession().get(Quiz.class, id);
		q.setNumOfQuestions(oldQ.getNumOfQuestions());
		q.setPassingGrade(oldQ.getPassingGrade());
		q.setPrivacy(oldQ.isPrivate());
		q.setQuestions(oldQ.getQuestions());
		q.setQuizDesc(oldQ.getQuizDesc());
		q.setQuizName(oldQ.getQuizName());
		q.setQuizId(oldQ.getQuizId());
		q.setTimesTaken(oldQ.getTimesTaken());
		return q;
	}

	public void deleteQuiz(Quiz q) {
		Session sess = ConnectionUtil.getSession();

		Transaction tx = sess.beginTransaction();
		sess.delete(q);
		tx.commit();
	}

	public List<Question> getQuizQuestions(Quiz q) {
		Set<Question> questions = q.getQuestions();
		List<Question> questionList = new ArrayList();
		for (Question qu : questions) {
			questionList.add(qu);
		}
		return questionList;
	}

	public void addQuestion(Quiz q, Question qu) {
		q.getQuestions().add(qu);
		//q.setNumOfQuestions(q.getNumOfQuestions()+1);
		
	}

}
