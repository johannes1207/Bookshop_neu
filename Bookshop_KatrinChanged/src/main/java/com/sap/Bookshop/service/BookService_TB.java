package com.sap.Bookshop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.sap.Bookshop.model_TB.Book_TB;
import com.sap.Bookshop.repository.BookRepository_TB;

@Service
public class BookService_TB {
	
	
	private BookRepository_TB bookRepository_TB;
	
	public BookService_TB(BookRepository_TB bookRepository_TB) {
		this.bookRepository_TB = bookRepository_TB;
	}
	
	public void save(Book_TB book) {
		bookRepository_TB.save(book);
	}
	
	public List<Book_TB> getAll(){
		return bookRepository_TB.findAll();
	}

	public List<Book_TB> updateBook(Book_TB book) {
		bookRepository_TB.save(book);
		return getAll();
	}
	
	
	
	
	
}
