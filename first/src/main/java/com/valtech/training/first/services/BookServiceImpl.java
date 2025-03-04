package com.valtech.training.first.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.first.dtos.BookInfoDTO;
import com.valtech.training.first.entities.Book;
import com.valtech.training.first.repos.BookRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookRepository;

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public Book getBook(int id) {
        return bookRepository.getReferenceById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public long countBooks() {
        return bookRepository.count();
    }

	@Override
	public List<Book> getbookStoreByYearBetween(int i, int j) {
		
		return bookRepository.findAllByYearBetween(i,j);
	}

	@Override
	public List<Book> getbookByPriceGreaterThan(int i) {
		
		return bookRepository.findAllByPriceGreaterThan(i);
	}

	@Override
	public List<Integer> findAllPriceByAuthorsId(int i) {
	    return bookRepository.findAllPriceByAuthorsId(i);
	}

	@Override
	public List<BookInfoDTO> getBookInfoByAuthor(long id) {
		
		return bookRepository.getBookInfoByAuthor(id);
	}


	
}
