package com.revature.daos;

import java.util.List;

import com.revature.pojos.Group;
import com.revature.pojos.User;

public interface GroupDao {
	
	public Group getGroup(int id);
	public List<Group> getAllGroups();
	public Group putGroup(Group g);
	public Group addGroup(Group g);
	public Group updateGroup(Group g, int id);
	public void deleteGroup(Group g);
	public List<User> getGroupUsers(Group g);
	public void addUser(Group g, User u);
}
