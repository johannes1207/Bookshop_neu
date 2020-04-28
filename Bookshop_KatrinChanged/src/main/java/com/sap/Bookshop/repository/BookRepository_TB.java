package com.sap.Bookshop.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sap.Bookshop.model_TB.Book_TB;

@Repository
public interface BookRepository_TB extends JpaRepository<Book_TB, Integer> {

	public static final String FIND_PROJECTS = "SELECT UUID, ISBN, TITLE, AUTHOR, PUBYEAR, EDITOR FROM BOOK_TABLE";
	public static final String SORT_TITLES = "SELECT * FROM BOOK_TABLE ORDER BY TITLE ASC";
	public static final String FIND_AUTHOR = "SELECT * FROM BOOK_TABLE b WHERE b.author = :AUTHOR";
	public static final String FIND_BOOK = "SELECT * FROM BOOK_TABLE b WHERE b.ISBN = :ISBN";

	
	@Query(value = FIND_PROJECTS, nativeQuery = true)
	public List<Book_TB> findProjects();
	
	
	@Query(value = SORT_TITLES, nativeQuery = true)
	public List<Book_TB> sortTitles();
	
	
	@Query(value = FIND_AUTHOR, nativeQuery = true)
	public List<Book_TB> findAuthor(@Param("AUTHOR") String author);
	
	
	@Query(value = FIND_BOOK, nativeQuery = true)
	public List<Book_TB> findBookByIsbn(@Param("ISBN") int isbn);
}
