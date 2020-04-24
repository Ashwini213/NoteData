package com.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.model.Notes;
import com.cg.repository.NotesRepository;

@Service
@Transactional
public class NotesServiceImpl implements NotesService {

	@Autowired
	private NotesRepository notesRepository;

	@Override
	public void createNote(Notes notes) {
		notesRepository.save(notes);
	}

	@Override
	public List<Notes> getAllNotes() {
		List<Notes> books = new ArrayList<Notes>();
		notesRepository.findAll().forEach(books1 -> books.add(books1));
		return books;
	}

	@Override
	public Notes getNotesById(int noteId) {
		return notesRepository.findById(noteId).get();
	}

	@Override
	public Notes update(Notes notes, int noteId) {

		Optional<Notes> maybeNote = notesRepository.findById(noteId);
		System.out.println("maybeNote :" + maybeNote);
		Notes presentNote = maybeNote.map(existingNote -> {
			System.out.println("noteee here");
			existingNote.setNoteName(notes.getNoteName() != null ? notes.getNoteName() : maybeNote.get().getNoteName());
			existingNote.setNoteInfo(notes.getNoteInfo() != null ? notes.getNoteInfo() : maybeNote.get().getNoteInfo());
			existingNote
					.setNoteParty(notes.getNoteParty() != null ? notes.getNoteParty() : maybeNote.get().getNoteParty());

			return existingNote;
		}).orElseThrow(() -> new RuntimeException("Note Not Found"));
		System.out.println(presentNote);

		return notesRepository.save(presentNote);
	}

	@Override
	public String delete(int noteId) {
		notesRepository.deleteById(noteId);
		return "";
	}

}
