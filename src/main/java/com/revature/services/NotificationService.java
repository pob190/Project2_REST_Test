package com.revature.services;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.revature.daos.NotificationDaoImpl;
import com.revature.pojos.Group;
import com.revature.pojos.Notification;
import com.revature.pojos.User;
import com.revature.util.ConnectionUtil;

@Service("NotificationService")
public class NotificationService {

	NotificationDaoImpl NDI = new NotificationDaoImpl();
	
	public User addNote(User u, Notification n) {
		Session sess = ConnectionUtil.getSession();
		Transaction tx = sess.beginTransaction();
		sess.merge(u);	
		NDI.putNote(n);
		u.getNotes().add(n);
		sess.merge(u);
		System.out.println("Committing...");
		tx.commit();
		sess.flush();
		System.out.println("Committed...");
		sess.merge(u);
		
		return u;
	}
	
	public Notification getUserNote(User u, int noteId) {
		for(Notification n : u.getNotes()) {
			if(noteId == n.getNoteId()) {
				return n;
			}
		}
		return null;
	}
	
	
	public Set<Notification> getUserNotes(User u){
		return u.getNotes();
	}
	
	public User deleteNote (User u, int noteId) {
		Session sess = ConnectionUtil.getSession();
		System.out.println("Delete Notificaiton");
		Transaction tx = sess.beginTransaction();
		
		Query query = sess.createQuery("from Notification N where N.noteId="+noteId);
		List<Notification> notes = query.list();
		System.out.println(notes);
		for(Notification temp : notes) {
			if(noteId == temp.getNoteId()) {
				u.getNotes().remove(temp);
				Notification delN = (Notification) sess.get(Notification.class, temp.getNoteId());
				sess.merge(delN);
				sess.delete(delN);
				
				System.out.println("Deleted Group...");
				break;
			}
		}
		
		
		System.out.println("Committing...");
		tx.commit();
		System.out.println("Committed...");
		sess.merge(u);
		return u;
	}
}
