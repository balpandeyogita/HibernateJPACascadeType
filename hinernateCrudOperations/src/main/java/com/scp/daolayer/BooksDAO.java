package com.scp.daolayer;

import java.util.List;

import com.scp.entities.Book;
import com.scp.implementation.SpecifiedBookNotFoundException;

/**
 * 
 * @author Yogesh
 *
 */
public interface BooksDAO {

	/**
	 * If book is added into the db returns true else false
	 * @return
	 */
	public Boolean addBook(Book book);
	/**
	 * Get specific book from DB required id
	 * @param bookId
	 * @return
	 */
	public Book getBooks(int bookId) throws SpecifiedBookNotFoundException;
	/**
	 * Returns all books from the db
	 * @return
	 */
	public List<Book> getListOfBooks();
	
	/**
	 * Returns updated book
	 * @param book
	 * @return
	 */
	public Book updateBook(Book book)throws SpecifiedBookNotFoundException;;
	
}
