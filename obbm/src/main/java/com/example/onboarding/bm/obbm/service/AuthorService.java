package com.example.onboarding.bm.obbm.service;

import java.util.List;

import com.example.onboarding.bm.obbm.model.Author;
import com.example.onboarding.bm.obbm.model.Book;

public interface AuthorService {
	List<Author> getAllAuthors();
	List<Author> getAuthor(String name);
	Author insertAuthor(String name);
	Author updateAuthor(int idAuthor, String name);
	Author addBookToAuthor(int idAuthor, Book book);
}
