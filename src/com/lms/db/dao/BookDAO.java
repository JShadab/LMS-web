package com.lms.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.lms.beans.Book;
import com.lms.db.DbConnection;

public class BookDAO {

	public static List<Book> getAllBooks() {

		String sql = "SELECT * FROM book";

		List<Book> books = new ArrayList<>();

		try (Connection conn = DbConnection.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String subject = rs.getString("subject");
				int units = rs.getInt("units");

				books.add(new Book(id, title, author, subject, units));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return books;

	}

	public static void deleteBook(int bookId) {

		String sql = "DELETE FROM book WHERE id=?";

		try (Connection conn = DbConnection.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bookId);
			ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static Book getBook(int bookId) {

		String sql = "SELECT * FROM book WHERE id=?";

		Book book = null;

		try (Connection conn = DbConnection.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, bookId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				int id = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String subject = rs.getString("subject");
				int units = rs.getInt("units");

				book = new Book(id, title, author, subject, units);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return book;

	}

	public static boolean editBook(Book book) {

		String sql = "UPDATE book SET title=?, author=?, subject=?, units=? WHERE id=?";

		try (Connection conn = DbConnection.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getSubject());
			ps.setInt(4, book.getUnits());
			ps.setInt(5, book.getId());

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

	}

	public static boolean saveBook(Book book) {

		String sql = "INSERT INTO book (title, author, subject, units) VALUES(?,?,?,?)";

		try (Connection conn = DbConnection.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getSubject());
			ps.setInt(4, book.getUnits());

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

	}

	public static boolean issueBook(int bookId, int studId) {

		String sql = "INSERT INTO book_issue (book_id, stud_id, issue_date) VALUES(?,?,?)";

		try (Connection conn = DbConnection.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, bookId);
			ps.setInt(2, studId);

			ps.setDate(3, new java.sql.Date(new Date().getTime()));

			ps.executeUpdate();

			updateBookUnits(bookId, -1);

			return true;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

	}

	private static boolean updateBookUnits(int bookId, int num) {

		String sql = "UPDATE book SET units= units + 1 WHERE id=?";
		if (num < 0) {
			sql = "UPDATE book SET units= units - 1 WHERE id=?";
		}

		try (Connection conn = DbConnection.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, bookId);

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

	}

	public static List<Book> getIssuedBooks(int studId) {

		String sql = "SELECT * FROM book_issue  WHERE stud_id=?";

		List<Book> books = new ArrayList<>();

		try (Connection conn = DbConnection.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, studId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int bookId = rs.getInt("book_id");

				books.add(getBook(bookId));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return books;

	}

	public static boolean returnBook(int bookId, int studId) {

		String sql = "DELETE FROM book_issue WHERE book_id=? AND stud_id=?";

		try (Connection conn = DbConnection.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, bookId);
			ps.setInt(2, studId);

			ps.executeUpdate();

			updateBookUnits(bookId, 1);

			return true;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

	}

	public static List<Book> searchBook(String searchStr) {

		String sql = "SELECT * FROM book WHERE title LIKE '%" + searchStr + "%' OR author LIKE '%" + searchStr
				+ "%' OR subject LIKE '%" + searchStr + "%' ";

		List<Book> books = new ArrayList<>();

		try (Connection conn = DbConnection.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String subject = rs.getString("subject");
				int units = rs.getInt("units");

				books.add(new Book(id, title, author, subject, units));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return books;

	}

}
