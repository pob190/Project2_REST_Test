package com.revature.daos;

import java.util.List;

import com.revature.pojos.Notification;

public interface NotificaitonDao {
	public Notification getNote(int id);
	public List<Notification> getAllNotifications();
	public Notification putNote(Notification n);
	public Notification updateNotification(Notification n, int id);
	public void deleteNotification(Notification n);
}
