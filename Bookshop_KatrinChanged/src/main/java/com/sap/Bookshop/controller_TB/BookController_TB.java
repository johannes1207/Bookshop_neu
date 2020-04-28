package com.sap.Bookshop.controller_TB;

import java.awt.print.Book;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sap.Bookshop.DTO.BookDTO;
import com.sap.Bookshop.model_TB.Book_TB;
import com.sap.Bookshop.repository.BookRepository_TB;
import com.sap.Bookshop.service.BookService_TB;

@RestController
@RequestMapping("/api/v1")
public class BookController_TB {
	

    private ModelMapper modelMapper;
	private final BookService_TB bookService_TB;
	private final BookRepository_TB bookRepository_TB;
	
	
	public BookController_TB(BookService_TB bookService_TB, BookRepository_TB bookRepository_TB, ModelMapper modelMapper) {
		this.bookService_TB = bookService_TB;
		this.bookRepository_TB = bookRepository_TB;
		this.modelMapper = modelMapper;
		
		
	}
	
	private BookDTO convertToDto(Book_TB book) {
		BookDTO bookDto = modelMapper.map(book, BookDTO.class);
		return bookDto;
	}
	
	private Book_TB convertToEntity(BookDTO bookDto) throws ParseException{
		Book_TB book = modelMapper.map(bookDto, Book_TB.class);
		return book;
	}
	
	@GetMapping(path = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Book_TB>> books(){
		return new ResponseEntity<List<Book_TB>>(bookRepository_TB.sortTitles(), HttpStatus.OK);
	}
	
	@PutMapping (path= "/book", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity save(@RequestBody Book_TB book) {
		return new ResponseEntity(bookService_TB.updateBook(book), HttpStatus.OK);
	}
	@PostMapping (path= "/book", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity updateBook(@RequestBody Book_TB book) {
		return new ResponseEntity(bookService_TB.updateBook(book), HttpStatus.OK);
	}
	
	@DeleteMapping (path = "/bookd/{isbn}")
	public ResponseEntity<?> deleteBook(@PathVariable int isbn) {
		bookRepository_TB.deleteById(isbn);
		return null;
	}
	
	@GetMapping(path = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BookDTO>> costumer(){
		return new ResponseEntity<List<BookDTO>>(bookService_TB.getAll().stream().map(this::convertToDto).collect(Collectors.toList()),
				
				HttpStatus.OK);
	}
	
	@GetMapping (path = "/author/{author}")
	public ResponseEntity findAuthor(@PathVariable String author) {
		//bookRepository_TB.findAuthor(author);
		return new ResponseEntity<List<Book_TB>>(bookRepository_TB.findAuthor(author), HttpStatus.OK);
	}
	@GetMapping (path = "/book/{isbn}")
	public ResponseEntity findBookByIsbn(@PathVariable int isbn) {
		//bookRepository_TB.findAuthor(author);
		return new ResponseEntity<List<Book_TB>>(bookRepository_TB.findBookByIsbn(isbn), HttpStatus.OK);
	}
	
	


}
