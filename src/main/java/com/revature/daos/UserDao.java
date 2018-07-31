package com.revature.daos;

import java.util.List;

import com.revature.pojos.Group;
import com.revature.pojos.Notification;
import com.revature.pojos.Quiz;
import com.revature.pojos.QuizHistory;
import com.revature.pojos.User;

public interface UserDao {
	
	public User getUser(int id);
	public User getUser(String username);
	public List<User> getAllUsers();
	public User addUser(User user);
	public User putUser(User user);
	public User updateUser(User user, int id);
	public void DeleteUser(User user);
	public List<Notification> getUserNotes(User user);
	public List<Group> getLedGroups(User user);
	public List<Group> getUserGroups(User user);
	public List<Quiz> getUserQuizzes(User user);
	public List<QuizHistory> getUserQuizAttempts(User user);
	public void addNotification(User user, Notification n);
	public void addGroup(User user, Group g);
	public void addQuiz(User user, Quiz q);
	public void addQuizHistory(User user, QuizHistory qh);
}
