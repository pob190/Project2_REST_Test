package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.pojos.Notification;
import com.revature.util.ConnectionUtil;

public class NotificationDaoImpl implements NotificaitonDao {

	public Notification getNote(int id) {
		return (Notification) ConnectionUtil.getSession().get(Notification.class, id);
	}

	public Notification putNote(Notification n) {
		Session sess = ConnectionUtil.getSession();

		Transaction tx = sess.beginTransaction();

		sess.save(n);

		tx.commit();

		return n;
	}

	public List<Notification> getAllNotifications() {
		return ConnectionUtil.getSession().createQuery("from Notification").list();
	}

	public Notification updateNotification(Notification n, int id) {
		Notification oldN = (Notification) ConnectionUtil.getSession().get(Notification.class, id);
		n.setNoteId(oldN.getNoteId());
		n.setNoteText(oldN.getNoteText());
		n.setResponse(oldN.isResponse());
		n.setRespReq(oldN.isRespReq());
		return n;
	}

	public void deleteNotification(Notification n) {
		ConnectionUtil.getSession().delete(n);
	}

}
