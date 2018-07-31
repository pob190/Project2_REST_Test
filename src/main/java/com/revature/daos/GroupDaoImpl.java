package com.revature.daos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.pojos.Group;
import com.revature.pojos.Quiz;
import com.revature.pojos.User;
import com.revature.util.ConnectionUtil;

public class GroupDaoImpl implements GroupDao {

	public Group getGroup(int id) {
		return (Group) ConnectionUtil.getSession().get(Group.class, id);

	}

	public Group putGroup(Group g) {
		Session sess = ConnectionUtil.getSession();

		Transaction tx = sess.beginTransaction();

		sess.save(g);

		tx.commit();

		return g;
	}

	public List<Group> getAllGroups() {
		return ConnectionUtil.getSession().createQuery("from Group").list();
	}

	public Group addGroup(Group g) {
		Session sess = ConnectionUtil.getSession();

		Transaction tx = sess.beginTransaction();
		g.setUsers(new HashSet<User>());
		sess.save(g);

		tx.commit();

		return g;
	}

	public Group updateGroup(Group g, int id) {
		Group oldG = (Group) ConnectionUtil.getSession().get(Group.class, id);
		g.setGroupDesc(oldG.getGroupDesc());
		g.setGroupId(oldG.getGroupId());
		g.setGroupName(oldG.getGroupName());
		g.setUsers(oldG.getUsers());
		return g;
	}

	public void deleteGroup(Group g) {
		ConnectionUtil.getSession().delete(g);
		
	}

	public List<User> getGroupUsers(Group g) {
		Set<User> users = g.getUsers();
		List<User> userList = new ArrayList();
		for (User u : users) {
			userList.add(u);
		}
		return userList;
	}

	public void addUser(Group g, User u) {
		g.getUsers().add(u);
	}

}
