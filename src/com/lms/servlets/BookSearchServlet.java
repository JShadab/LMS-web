package com.lms.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.beans.Book;
import com.lms.db.dao.BookDAO;

@WebServlet("/bookSearch")
public class BookSearchServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String searchStr = req.getParameter("searchStr");

		List<Book> books = BookDAO.searchBook(searchStr);

		req.setAttribute("books", books);

		resp.sendRedirect("/LMS/pages/student/searchBooks.jsp");

	}

}
