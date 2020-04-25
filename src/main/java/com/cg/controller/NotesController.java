package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.Notes;
import com.cg.service.NotesService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NotesController {

	@Autowired
	private NotesService notesService;

	@PostMapping(value = "/note")
	private Notes createNote(@RequestBody Notes notes) {
		notesService.createNote(notes);
		return notes;
	}

	@GetMapping(value = "/note")
	private List<Notes> getAllNotes() {
		return notesService.getAllNotes();
	}

	@GetMapping(value = "/note/{noteId}")
	private Notes getNote(@PathVariable("noteId") int noteId) {
		return notesService.getNotesById(noteId);
	}

	@PutMapping(value = "/note/{noteId}")
	public Notes updateNote(@PathVariable("noteId") int noteId, @RequestBody Notes notes) {
		notesService.update(notes, noteId);
		return notes;

	}

	@DeleteMapping(value = "/note/{noteId}")
	private String deleteNote(@PathVariable("noteId") int noteId) {
		notesService.delete(noteId);
		return "";
	}
}
