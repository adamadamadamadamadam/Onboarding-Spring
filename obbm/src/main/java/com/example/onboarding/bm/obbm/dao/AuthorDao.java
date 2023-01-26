package com.example.onboarding.bm.obbm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onboarding.bm.obbm.model.Author;

public interface AuthorDao extends JpaRepository<Author, Integer> {
	List<Author> findByName(String name);
}
