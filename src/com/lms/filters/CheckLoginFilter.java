package com.lms.filters;

import java.io.IOException;
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

@WebFilter(urlPatterns = { "/pages/admin/*", "/pages/student/*" })
public class CheckLoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest hreq = (HttpServletRequest) req;
		HttpServletResponse hresp = (HttpServletResponse) resp;

		HttpSession session = hreq.getSession(false);
		if (Objects.nonNull(session) && Objects.nonNull(session.getAttribute("user"))) {
			chain.doFilter(req, resp);
		} else {

			hresp.sendRedirect("/LMS/index.jsp?msg=Please do login first...");
		}

	}

}
