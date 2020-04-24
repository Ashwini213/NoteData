package com.cg.service;

import java.util.List;

import com.cg.model.Notes;

public interface NotesService {

	void createNote(Notes notes);

	List<Notes> getAllNotes();

	Notes getNotesById(int noteID);

	// void delete(int id);

	Notes update(Notes notes, int noteId);

	String delete(int noteID);

}
