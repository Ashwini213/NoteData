package com.cg.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MYNOTES")
public class Notes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int noteId;
	private String noteName;
	
	private String noteInfo;
	
	private String noteParty;

	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public String getNoteName() {
		return noteName;
	}

	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}

	public String getNoteInfo() {
		return noteInfo;
	}

	public void setNoteInfo(String noteInfo) {
		this.noteInfo = noteInfo;
	}

	public String getNoteParty() {
		return noteParty;
	}

	public void setNoteParty(String noteParty) {
		this.noteParty = noteParty;
	}

	@Override
	public String toString() {
		return "Notes [noteId=" + noteId + ", noteName=" + noteName + ", noteInfo=" + noteInfo + ", noteParty="
				+ noteParty + "]";
	}
}
