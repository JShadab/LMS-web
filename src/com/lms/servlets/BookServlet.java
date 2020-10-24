package com.lms.servlets;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lms.beans.Book;
import com.lms.beans.Student;
import com.lms.db.dao.BookDAO;

@WebServlet("/book")
public class BookServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getParameter("action");

		if ("add".equals(action)) {

			String title = req.getParameter("title");
			String author = req.getParameter("author");
			String subject = req.getParameter("subject");
			int units = Integer.parseInt(req.getParameter("units"));

			addBook(new Book(title, author, subject, units));
		} else if ("edit".equals(action)) {
			int bookId = Integer.parseInt(req.getParameter("id"));

			String title = req.getParameter("title");
			String author = req.getParameter("author");
			String subject = req.getParameter("subject");
			int units = Integer.parseInt(req.getParameter("units"));

			editBook(new Book(bookId, title, author, subject, units));
		} else if ("delete".equals(action)) {
			int bookId = Integer.parseInt(req.getParameter("id"));
			deleteBook(bookId);
		} else if ("issue".equals(action)) {
			int bookId = Integer.parseInt(req.getParameter("id"));

			HttpSession session = req.getSession(false);
			if (Objects.nonNull(session)) {
				Student stud = (Student) session.getAttribute("user");

				BookDAO.issueBook(bookId, stud.getId());

				resp.sendRedirect("/LMS/pages/student/books.jsp");

				return;
			}

		} else if ("return".equals(action)) {
			int bookId = Integer.parseInt(req.getParameter("id"));

			HttpSession session = req.getSession(false);
			if (Objects.nonNull(session)) {
				Student stud = (Student) session.getAttribute("user");

				BookDAO.returnBook(bookId, stud.getId());

				resp.sendRedirect("/LMS/pages/student/books.jsp");

				return;
			}

		}

		resp.sendRedirect("/LMS/pages/admin/books.jsp");

	}

	private void addBook(Book book) {

		BookDAO.saveBook(book);
	}

	private void editBook(Book book) {

		BookDAO.editBook(book);
	}

	private void deleteBook(int bookId) {

		BookDAO.deleteBook(bookId);

	}

}
