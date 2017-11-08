package com.scp.hinernateCrudOperations;

import junit.framework.Assert;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.scp.entities.Book;
import com.scp.implementation.BookCrudOpImpl;
import com.scp.implementation.SpecifiedBookNotFoundException;

public class TestBookImpl {
  
	static BookCrudOpImpl bookCrud = new BookCrudOpImpl();
	
	@DataProvider
	public Object[][] listOfBooks(){
		Object [][] books = new Object[6][1];
		books[0][0] = new Book("Book1","Author1",100);
		books[1][0] = new Book("Book2","Author2",200);
		books[2][0] = new Book("Book3","Author3",400);
		books[3][0] = new Book("Book4","Author4",500);
		books[4][0] = new Book("Book5","Author5",700);
		books[5][0] = new Book("Book6","Author6",20);
		return books;
	}
	
  @Test(dataProvider="listOfBooks")
  public void testAddBooks(Book book) {
		Assert.assertTrue(bookCrud.addBook(book));
  }
  
  @Test
  public void testUpdate() {
	 Book b=  new Book("spring","rohit",102);
	 bookCrud.addBook(b);
	 b.setBookName("webservices");
	 try {
		b = bookCrud.updateBook(b);
	} catch (SpecifiedBookNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 Assert.assertEquals("webservices1", b.getBookName());
  }
  
  @Test
  public void testGetListOfBooks() {
	  	Assert.assertEquals(6, bookCrud.getListOfBooks().size());		
  }
  
  @Test(expectedExceptions=SpecifiedBookNotFoundException.class)
  public void testExcetption() throws SpecifiedBookNotFoundException {
	BookCrudOpImpl bookCrud = new BookCrudOpImpl();
	bookCrud.getBooks(12121);	
  }
  
}
