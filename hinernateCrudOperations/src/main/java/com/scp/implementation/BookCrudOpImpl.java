package com.scp.implementation;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.scp.daolayer.BooksDAO;
import com.scp.entities.Book;
import com.scp.utilities.AppUtilities;

/**
 * 
 * @author Yogesh
 *
 */
public class BookCrudOpImpl implements BooksDAO
{

	public Boolean addBook(Book book) {
		Boolean returnValue = false;
		try{
			Session session = AppUtilities.getAppSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			session.persist(book);
			transaction.commit();
			session.flush();
			returnValue=true;
		}catch(Exception e){
			System.out.println("Some exception while adding book");
		}
		
		return returnValue;
	}

	public Book getBooks(int bookId) throws SpecifiedBookNotFoundException {
		Session session = AppUtilities.getAppSessionFactory().openSession();
		Book book = session.get(Book.class, bookId);
		if(null==book){
				throw new SpecifiedBookNotFoundException("Book nhiye..");
		}
		return book;
	}

	public List<Book> getListOfBooks() {
		Session session = AppUtilities.getAppSessionFactory().openSession();
		Query query = session.getNamedQuery("GET_ALL_BOOKS");
		return query.list();
	}

	public Book updateBook(Book book) throws SpecifiedBookNotFoundException {
		Session session = AppUtilities.getAppSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
		session.update(book);
		session.flush();
		tr.commit();
		return getBooks(book.getBookId());
	}
	
}
