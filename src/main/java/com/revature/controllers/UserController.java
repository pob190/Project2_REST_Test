package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojos.Admin;
import com.revature.pojos.Group;
import com.revature.pojos.Notification;
import com.revature.pojos.Question;
import com.revature.pojos.Quiz;
import com.revature.pojos.QuizHistory;
import com.revature.pojos.User;
import com.revature.services.AdminService;
import com.revature.services.GroupService;
import com.revature.services.NotificationService;
import com.revature.services.QuestionService;
import com.revature.services.QuizHistoryService;
import com.revature.services.QuizService;
import com.revature.services.UserService;

@RestController
@RequestMapping("/api")

public class UserController {
	@Autowired
	private User sessionUser;
	@Autowired
	private Admin sessionAdmin;
	@Autowired
	UserService USI;
	@Autowired
	QuizService QSI;
	@Autowired
	QuizHistoryService QHSI;
	@Autowired
	QuestionService QUSI;
	@Autowired
	GroupService GSI;
	@Autowired
	NotificationService NSI;
	@Autowired
	AdminService ASI;

	/*
	 * @RequestMapping(value = "/user/", method = RequestMethod.GET, produces =
	 * "application/json") public ResponseEntity<List<User>> listAllUsers() {
	 * System.out.println("GET ALL USERS"); List<User> users = USI.getAllUsers();
	 * if(users.isEmpty()){ return new
	 * ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return
	 * HttpStatus.NOT_FOUND } ResponseEntity RE = new
	 * ResponseEntity<List<User>>(users, HttpStatus.OK); System.out.println(RE);
	 * return RE; }
	 */
	@RequestMapping(value = "/user/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> listAllUsers() {
		System.out.println("GET ALL USERS");
		List<User> users = USI.getAllUsers();
		if (users.isEmpty()) {
			return new ArrayList<User>();// You many decide to return HttpStatus.NOT_FOUND
		}
		return users;
	}

	/*
	 * @RequestMapping(value = "/sessionUser/", method = RequestMethod.GET, produces
	 * = MediaType.APPLICATION_JSON_VALUE) public User getSessionUser() { return
	 * sessionUser; }
	 */
	@RequestMapping(value = "/user/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUser(@PathVariable String name) {
		System.out.println("GET USER " + name);
		User u = USI.getUser(name);
		return u;
	}

	@RequestMapping(value = "/user/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public User validateUser(@RequestBody Map<String, String> map) {
		System.out.println(map.get("name"));
		System.out.println(map.get("password"));
		sessionUser = USI.validateUser(map.get("name"), map.get("password"));
		return sessionUser;
	}

	@RequestMapping(value = "/new/user", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addUser(@RequestBody User u) {
		USI.addUser(u);
	}

	/*
	 * @RequestMapping(value = "/sessionUser/", method = RequestMethod.GET, produces
	 * = MediaType.APPLICATION_JSON_VALUE) public User getSessionUser() { return
	 * sessionUser; }
	 */

	@RequestMapping(value = "/admin/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Admin validateAdmin(@RequestBody Map<String, String> map) {
		System.out.println(map.get("id"));
		System.out.println(map.get("password"));
		
		sessionAdmin = ASI.validateAdmin(Integer.parseInt(map.get("id")), map.get("password"));
		return sessionAdmin;
	}

	@RequestMapping(value = "/add/admin/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addAdmin(@RequestBody Admin a) {
		ASI.addAdmin(a);
	}

	
	@RequestMapping(value = "/quiz/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Quiz> getAllQuizzes() {
		return QSI.getQuizzesForUser(sessionUser);
	}

	@RequestMapping(value = "/quiz/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Quiz getQuiz(@PathVariable String name) {
		return QSI.getQuiz(name);
	}

	@RequestMapping(value = "/quiz/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public User addQuiz(@RequestBody Quiz q) {
		System.out.println(q);
		QSI.addQuiz(sessionUser, q);
		return sessionUser;
	}

	@RequestMapping(value = "/quiz/{name}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User deleteQuiz(@PathVariable String name) {
		QSI.deleteQuiz(sessionUser, name);

		return sessionUser;
	}

	@RequestMapping(value = "/group/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Group> getAllGroups() {
		return GSI.getAllGroups();
	}

	@RequestMapping(value = "/group/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Group getGroup(@PathVariable String name) {
		return GSI.getGroup(name);
	}

	@RequestMapping(value = "/group/{name}/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Set<User> getGroupMembers(@PathVariable String name) {
		return GSI.getGroupMembers(name);
	}

	@RequestMapping(value = "/group/{name}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Group addGroupMember(@PathVariable String name, @RequestBody Map<String, String> map) {
		return GSI.addGroupMember(name, map.get("username"));
	}

	@RequestMapping(value = "/group/{name}/{username}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Group deleteGroupMember(@PathVariable String name, @PathVariable String username) {
		return GSI.deleteGroupMember(name, username);
	}

	@RequestMapping(value = "/group/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public User addGroup(@RequestBody Group g) {
		User user = GSI.addGroup(g, sessionUser);
		sessionUser = USI.validateUser(user.getUsername(), user.getPassword());
		return sessionUser;
	}

	@RequestMapping(value = "/group/{name}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User deleteGroup(@PathVariable String name) {
		User user = GSI.deleteGroup(sessionUser, name);
		sessionUser = USI.validateUser(user.getUsername(), user.getPassword());
		return sessionUser;
	}

	@RequestMapping(value = "/notification/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public User addGroup(@RequestBody Notification n) {
		User user = NSI.addNote(sessionUser, n);
		sessionUser = USI.validateUser(user.getUsername(), user.getPassword());
		return sessionUser;
	}

	@RequestMapping(value = "/notification/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Notification getUserNote(@PathVariable int id) {
		return NSI.getUserNote(sessionUser, id);
	}

	@RequestMapping(value = "/notification/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Set<Notification> getUserNotes() {
		return NSI.getUserNotes(sessionUser);
	}

	@RequestMapping(value = "/notification/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User deleteGroup(@PathVariable int id) {
		User user = NSI.deleteNote(sessionUser, id);
		sessionUser = USI.validateUser(user.getUsername(), user.getPassword());
		return sessionUser;
	}

	@RequestMapping(value = "/question/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Question getQuestion(@PathVariable int id) {
		return QUSI.getQuestion(id);
	}

	@RequestMapping(value = "/question/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Question> getAllQuestions() {
		return QUSI.getAllQuestions();
	}

	@RequestMapping(value = "/quizhistory/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public User addQuizHistory(@RequestBody QuizHistory qh) {
		User user = QHSI.addQuizHistory(sessionUser, qh);
		sessionUser = USI.validateUser(user.getUsername(), user.getPassword());
		return sessionUser;
	}

	@RequestMapping(value = "/quizhistory/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public QuizHistory getUserQuizHistory(@PathVariable int id) {
		return QHSI.getUserQuizHistory(sessionUser, id);
	}

	@RequestMapping(value = "/quizhistory/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Set<QuizHistory> getUserQuizHistories() {
		return QHSI.getUserQuizHistories(sessionUser);
	}

	@RequestMapping(value = "/quizhistory/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User deleteQuizHistory(@PathVariable int id) {
		User user = QHSI.deleteQuizHistory(sessionUser, id);
		sessionUser = USI.validateUser(user.getUsername(), user.getPassword());
		return sessionUser;
	}

	// not truly RESTful...need to ask how Nick thinks we should format this request
	@RequestMapping(value = "/logout/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void userLogout() {
		sessionUser = null;
		sessionAdmin = null;
	}
}
