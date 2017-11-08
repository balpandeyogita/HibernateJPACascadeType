/**
 * 
 */
package com.scp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

/**
 * @author Yogesh
 *
 */

@Entity
@Table(name="BooksInfo")

@NamedNativeQueries({
    @NamedNativeQuery(
            name    =   "GET_ALL_BOOKS",
            query   =   "SELECT * from BooksInfo",
                        resultClass=Book.class
    )
})
public class Book {

	@Id
	@Column(name="Book_Id")
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int bookId;
	
	@Column(name="Book_Name")
	private String bookName;
	
	@Column(name="author_name")
	private String authorName;
	
	@Column(name="Book_price")
	private long bookPrice;
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public long getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(long bookPrice) {
		this.bookPrice = bookPrice;
	}
	public Book(String bookName, String authorName, long bookPrice) {
		super();
		this.bookName = bookName;
		this.authorName = authorName;
		this.bookPrice = bookPrice;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName
				+ ", authorName=" + authorName + ", bookPrice=" + bookPrice
				+ "]";
	}
	
	
	
	
	
	
}
