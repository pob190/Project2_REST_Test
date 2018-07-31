package com.revature.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "P2_NOTIFICATIONS")
public class Notification {
		
	@Id
	@SequenceGenerator(name = "P2_NOTE_ID_SEQ", sequenceName = "P2_NOTE_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "P2_NOTE_ID_SEQ")
	@Column(name = "NOTEID")
	private int noteId;
	
	@Column(name = "NOTETEXT")
	private String noteText;
	
	@Column(name = "NOTETITLE")
	private String noteTitle;
	
	@Column(name = "RESPREQ")
	private boolean respReq;
	
	@Column(name = "RESPONSE")
	private int response;

	public Notification(int noteId, String noteText, String noteTitle, boolean respReq, int response) {
		super();
		this.noteId = noteId;
		this.noteText = noteText;
		this.noteTitle = noteTitle;
		this.respReq = respReq;
		this.response = response;
	}


	public String getNoteTitle() {
		return noteTitle;
	}


	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}


	public int getResponse() {
		return response;
	}


	public int getNoteId() {
		return noteId;
	}


	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}


	public String getNoteText() {
		return noteText;
	}


	public void setNoteText(String noteText) {
		this.noteText = noteText;
	}


	public boolean isRespReq() {
		return respReq;
	}


	public void setRespReq(boolean respReq) {
		this.respReq = respReq;
	}


	public int isResponse() {
		return response;
	}


	public void setResponse(int response) {
		this.response = response;
	}


	@Override
	public String toString() {
		return "Notification [noteId=" + noteId + ", noteText=" + noteText + ", noteTitle=" + noteTitle + ", respReq="
				+ respReq + ", response=" + response + "]";
	}



	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}
}
