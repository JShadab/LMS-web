package com.lms.filters;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.lms.beans.Student;
import com.lms.db.dao.StudentDAO;

@WebFilter(urlPatterns = "/pages/admin/students.jsp")
public class StudentsFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		List<Student> students = StudentDAO.getAllStudent();

		req.setAttribute("students", students);

		chain.doFilter(req, resp);

	}

}
