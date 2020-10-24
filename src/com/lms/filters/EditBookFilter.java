package com.lms.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.lms.beans.Book;
import com.lms.db.dao.BookDAO;

@WebFilter(value = "/pages/admin/editBook.jsp")
public class EditBookFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		int bookId = Integer.parseInt(req.getParameter("id"));

		Book book = BookDAO.getBook(bookId);

		req.setAttribute("book", book);

		chain.doFilter(req, resp);

	}

}
