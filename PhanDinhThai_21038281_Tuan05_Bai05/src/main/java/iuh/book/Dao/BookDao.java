package iuh.book.Dao;

import java.util.List;

import iuh.book.entities.Book;

public interface BookDao {
	public void addBook(Book book);

//	public void deleteBook(int id);
//
//	public void updateBook(Book book);

	public Book getBookByID(int id);

	public List<Book> getAllBook();

	public List<Book> searchBook(String name);
}
