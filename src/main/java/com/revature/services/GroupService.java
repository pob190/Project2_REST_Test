package com.revature.services;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.revature.daos.GroupDaoImpl;
import com.revature.daos.UserDaoImpl;
import com.revature.pojos.Group;
import com.revature.pojos.Quiz;
import com.revature.pojos.User;
import com.revature.util.ConnectionUtil;

@Service("GroupService")
public class GroupService {
	UserDaoImpl UDI = new UserDaoImpl();
	GroupDaoImpl GDI = new GroupDaoImpl();
	
	public List<Group> getAllGroups() {
		return GDI.getAllGroups();
	}

	public Group getGroup(String name) {
		for(Group g: GDI.getAllGroups()) {
			if(name.equals(g.getGroupName())) {
				return g;
			}
		}
		return null;
	}

	public Set<User> getGroupMembers(String name) {
		for(Group g: GDI.getAllGroups()) {
			if(name.equals(g.getGroupName())) {
				return g.getUsers();
			}
		}
		return null;
	}

	
	public Group addGroupMember(String name, String username) {
		for(Group g: GDI.getAllGroups()) {
			if(name.equals(g.getGroupName())) {
				System.out.println("Found group name...");
				for(User u : UDI.getAllUsers()) {
					if(username.equals(u.getUsername())) {
						System.out.println("Found username...");
						Session sess = ConnectionUtil.getSession();
						Transaction tx = sess.beginTransaction();
						g.getUsers().add(u);
						sess.merge(g);
						tx.commit();
						return g;
					}
				}
				break;
			}
		}
		return null;
	}
	
	public Group deleteGroupMember(String name, String username) {
		for(Group g: GDI.getAllGroups()) {
			if(name.equals(g.getGroupName())) {
				System.out.println("Found group name...");
				for(User u : UDI.getAllUsers()) {
					if(username.equals(u.getUsername())) {
						System.out.println("Found username...");
						Session sess = ConnectionUtil.getSession();
						Transaction tx = sess.beginTransaction();
						Group delG = (Group) sess.get(Group.class, g.getGroupId());
						User delU = (User) sess.get(User.class, u.getUserId());
						delG.getUsers().remove(delU);
						sess.merge(delG);
						tx.commit();
						return g;
					}
				}
				break;
			}
		}
		return null;
	}

	public User addGroup(Group g, User sessionUser) {
		Session sess = ConnectionUtil.getSession();
		Transaction tx = sess.beginTransaction();
		sess.merge(sessionUser);	
		GDI.addGroup(g);
		sessionUser.getLedGroups().add(g);
		sess.merge(sessionUser);
		System.out.println("Committing...");
		tx.commit();
		sess.flush();
		System.out.println("Committed...");
		sess.merge(sessionUser);
		
		return sessionUser;
	}

	public User deleteGroup(User sessionUser, String name) {
		Session sess = ConnectionUtil.getSession();
		System.out.println("Delete Group");
		Transaction tx = sess.beginTransaction();
		
		Query query = sess.createQuery("from Group G where G.groupName='"+name +"'");
		List<Group> groups = query.list();
		System.out.println(groups);
		for(Group temp : groups) {
			if(name.equals(temp.getGroupName())) {
				sessionUser.getLedGroups().remove(temp);
				Group delG = (Group) sess.get(Group.class, temp.getGroupId());
				delG.getUsers().clear();
				sess.merge(delG);
				sess.delete(delG);
				
				System.out.println("Deleted Group...");
				break;
			}
		}
		
		
		System.out.println("Committing...");
		tx.commit();
		System.out.println("Committed...");
		sess.merge(sessionUser);
		return sessionUser;
	}
}
