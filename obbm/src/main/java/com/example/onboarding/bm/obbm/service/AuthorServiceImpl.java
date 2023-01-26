package com.example.onboarding.bm.obbm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onboarding.bm.obbm.dao.AuthorDao;
import com.example.onboarding.bm.obbm.model.Author;
import com.example.onboarding.bm.obbm.model.Book;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorDao authorDao;
	
	@Override
	public List<Author> getAuthor(String name) {
		try {
			List<Author> authors = authorDao.findByName(name);
			
			return authors;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Author insertAuthor(String name) {
		Author author = authorDao.save(new Author(name));
		
		return author;
	}

	@Override
	public Author updateAuthor(int idAuthor, String name) {
		Author author = authorDao.getReferenceById(idAuthor);
		
		author.setName(name);
		
		return authorDao.save(author);
	}

	@Override
	public Author addBookToAuthor(int idAuthor, Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Author> getAllAuthors() {
		return authorDao.findAll();
	}

}
