package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.model.Notes;

public interface NotesRepository extends JpaRepository<Notes, Integer> {

}
