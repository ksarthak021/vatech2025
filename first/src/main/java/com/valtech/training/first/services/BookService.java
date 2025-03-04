package com.valtech.training.first.services;

import java.util.List;

import com.valtech.training.first.dtos.BookInfoDTO;
import com.valtech.training.first.entities.Book;

public interface BookService {
    Book saveBook(Book book);
    Book updateBook(Book book);
    void deleteBook(Book book);
    Book getBook(int id);
    List<Book> getAllBooks();
    long countBooks();
	List<Book> getbookStoreByYearBetween(int i, int j);
	
	List<Book> getbookByPriceGreaterThan(int i);
	List<Integer> findAllPriceByAuthorsId(int i);
	
	List<BookInfoDTO> getBookInfoByAuthor(long id);
	
}
