package com.lms.filters;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.lms.beans.Book;
import com.lms.db.dao.BookDAO;

@WebFilter(urlPatterns = {"/pages/admin/books.jsp","/pages/student/books.jsp"})
public class BooksFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		List<Book> books = BookDAO.getAllBooks();

		req.setAttribute("books", books);

		chain.doFilter(req, resp);

	}

}
