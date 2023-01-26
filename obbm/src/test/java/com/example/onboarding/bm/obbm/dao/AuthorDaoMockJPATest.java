package com.example.onboarding.bm.obbm.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.onboarding.bm.obbm.model.Author;

@DataJpaTest
public class AuthorDaoMockJPATest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private AuthorDao authorDao;
	
	@Test
	public void testGetAuthor() {
		Author author = new Author("testAuthor");
		
		entityManager.persist(author);
		entityManager.flush();
		
		List<Author> authorListResult = authorDao.findByName("testAuthor");
		
		Author result = authorListResult.get(0);
		
		assertThat(result).isNotNull();
		
		assertThat(result.getName())
			.isEqualTo(author.getName());
	}
}
