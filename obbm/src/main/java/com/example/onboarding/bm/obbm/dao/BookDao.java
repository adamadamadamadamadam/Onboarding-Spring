package com.example.onboarding.bm.obbm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onboarding.bm.obbm.model.Book;

public interface BookDao extends JpaRepository<Book, Integer> {
	List<Book> findByName(String name);
}
