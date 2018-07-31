package com.revature.daos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.pojos.Group;
import com.revature.pojos.Notification;
import com.revature.pojos.Quiz;
import com.revature.pojos.QuizHistory;
import com.revature.pojos.User;
import com.revature.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {

	public User getUser(int id) {
		System.out.println("GET USER " + id + " DAO");
		return (User) ConnectionUtil.getSession().get(User.class, id);
	}

	public User addUser(User user) {
		Session sess = ConnectionUtil.getSession();

		Transaction tx = sess.beginTransaction();
		user.setLedGroups(new HashSet<Group>());
		user.setGroups(new HashSet<Group>());
		user.setNotes(new HashSet<Notification>());
		user.setQuizHistories(new HashSet<QuizHistory>());
		user.setQuizzes(new HashSet<Quiz>());
		sess.save(user);

		tx.commit();

		return user;
	}

	public List<User> getAllUsers() {
		System.out.println("GET ALL USERS DAO");
		return ConnectionUtil.getSession().createQuery("from User").list();
	}

	public User updateUser(User user, int id) {
		User oldUser = (User) ConnectionUtil.getSession().get(User.class, id);
		user.setAge(oldUser.getAge());
		user.setfName(oldUser.getfName());
		user.setlName(oldUser.getlName());
		user.setPassword(oldUser.getPassword());
		user.setUsername(oldUser.getUsername());
		user.setUserId(oldUser.getUserId());
		user.setQuizzes(oldUser.getQuizzes());
		user.setNotes(oldUser.getNotes());
		user.setQuizHistories(oldUser.getQuizHistories());
		user.setGroups(oldUser.getGroups());
		user.setLedGroups(oldUser.getLedGroups());
		return user;
	}

	public void DeleteUser(User user) {
		ConnectionUtil.getSession().delete(user);
	}

	public List<Notification> getUserNotes(User user) {
		Set<Notification> notes = user.getNotes();
		List<Notification> noteList = new ArrayList();
		for (Notification n : notes) {
			noteList.add(n);
		}
		return noteList;
	}

	public List<Group> getLedGroups(User user) {
		Set<Group> ledGroups = user.getLedGroups();
		List<Group> ledGroupList = new ArrayList();
		for (Group g : ledGroups) {
			ledGroupList.add(g);
		}
		return ledGroupList;
	}
	
	public List<Group> getUserGroups(User user) {
		Set<Group> groups = user.getGroups();
		List<Group> groupList = new ArrayList();
		for (Group g : groups) {
			groupList.add(g);
		}
		return groupList;
	}

	public List<Quiz> getUserQuizzes(User user) {
		Set<Quiz> quizzes = user.getQuizzes();
		List<Quiz> quizList = new ArrayList();
		for (Quiz q : quizzes) {
			quizList.add(q);
		}
		return quizList;
	}

	public List<QuizHistory> getUserQuizAttempts(User user) {
		Set<QuizHistory> quizHistories = user.getQuizHistories();
		List<QuizHistory> quizHistoryList = new ArrayList();
		for (QuizHistory qh : quizHistories) {
			quizHistoryList.add(qh);
		}
		return quizHistoryList;
	}

	public User putUser(User user) {
		Session sess = ConnectionUtil.getSession();

		Transaction tx = sess.beginTransaction();

		sess.save(user);

		tx.commit();

		return user;
	}

	public void addNotification(User user, Notification n) {
		Session sess = ConnectionUtil.getSession();

		Transaction tx = sess.beginTransaction();

		user.getNotes().add(n);
		sess.save(user);

		tx.commit();

	}


	public void addQuiz(User user, Quiz q) {
		Session sess = ConnectionUtil.getSession();

		Transaction tx = sess.beginTransaction();

		user.getQuizzes().add(q);
		sess.save(user);

		tx.commit();
	}

	public void addQuizHistory(User user, QuizHistory qh) {
		Session sess = ConnectionUtil.getSession();

		Transaction tx = sess.beginTransaction();

		user.getQuizHistories().add(qh);
		sess.save(user);

		tx.commit();
	}

	public void addGroup(User user, Group g) {
		Session sess = ConnectionUtil.getSession();

		Transaction tx = sess.beginTransaction();

		user.getLedGroups().add(g);
		sess.save(user);

		tx.commit();
	}

	public User getUser(String username) {
		System.out.println("GET USER " + username + " DAO");
		return (User) ConnectionUtil.getSession().get(User.class, username);
	}
}
