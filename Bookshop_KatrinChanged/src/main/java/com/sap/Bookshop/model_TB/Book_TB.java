package com.sap.Bookshop.model_TB;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "BOOK_TABLE")
@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
public class Book_TB {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UUID")
	private int uuid;
	
	@Column(name = "ISBN")
	private int ISBN;
	
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "AUTHOR")
	private String author;
	
	@Column(name = "PUBYEAR")
	private int publishingYear;
	
	@Column(name = "EDITOR")
	private String editor;
	
	@Column(name = "PRICE")
	private double price;
	
	@Column(name = "NUMBER_OF_ITEMS")
	private int numberOfItems;
	

	
	

}
