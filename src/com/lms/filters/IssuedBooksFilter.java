package com.lms.filters;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lms.beans.Book;
import com.lms.beans.Student;
import com.lms.db.dao.BookDAO;

@WebFilter(urlPatterns = "/pages/student/issuedBooks.jsp")
public class IssuedBooksFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest hreq = (HttpServletRequest) req;
		HttpServletResponse hresp = (HttpServletResponse) resp;

		HttpSession session = hreq.getSession(false);
		if (Objects.nonNull(session) && Objects.nonNull(session.getAttribute("user"))) {

			Student stud = (Student) session.getAttribute("user");
			int studId = stud.getId();

			List<Book> books = BookDAO.getIssuedBooks(studId);

			req.setAttribute("books", books);

			chain.doFilter(req, resp);
		} else {

			hresp.sendRedirect("/LMS/index.jsp?msg=Please do login first...");
		}

	}

}
