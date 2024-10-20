package iuh.book.Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import iuh.book.Dao.BookDao;
import iuh.book.entities.Book;

public class BookDaoImpl implements BookDao {
	private DataSource dataSource;

	public BookDaoImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public void addBook(Book book) {
		String sql = "INSERT INTO book (name, author, price, quantity, description,image) VALUES (?,?,?,?,?,?)";
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, book.getName());
			ps.setString(2, book.getAuthor());
			ps.setDouble(3, book.getPrice());
			ps.setInt(4, book.getQuantity());
			ps.setString(5, book.getDescription());
			ps.setString(6, book.getImage());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Book getBookByID(int id) {
		String sql = "SELECT * FROM book WHERE id = ?";
		Book book = null;
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					String name = rs.getString("name");
					String author = rs.getString("author");
					double price = rs.getDouble("price");
					int quantity = rs.getInt("quantity");
					String description = rs.getString("description");
					String image = rs.getString("image");
					book = new Book(id, name, author, price, quantity, description, image);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public List<Book> getAllBook() {
		String sql = "SELECT * FROM book";
		List<Book> list = new ArrayList<Book>();
		try (Connection con = dataSource.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String author = rs.getString("author");
				double price = rs.getDouble("price");
				int quantity = rs.getInt("quantity");
				String description = rs.getString("description");
				String image = rs.getString("image");
				Book book = new Book(id, name, author, price, quantity, description, image);
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Book> searchBook(String name) {
		String sql = "SELECT * FROM book WHERE name LIKE ?";
		List<Book> list = new ArrayList<Book>();
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, "%" + name + "%");
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					int id = rs.getInt("id");
					String author = rs.getString("author");
					double price = rs.getDouble("price");
					int quantity = rs.getInt("quantity");
					String description = rs.getString("description");
					String image = rs.getString("image");
					Book book = new Book(id, name, author, price, quantity, description, image);
					list.add(book);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
