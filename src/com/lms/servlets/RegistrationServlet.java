package com.lms.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.beans.Student;
import com.lms.db.dao.StudentDAO;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String course = req.getParameter("course");

		Student student = new Student(name, email, course, password);

		boolean isSaved = StudentDAO.save(student);

		if (isSaved) {
			resp.sendRedirect("/LMS/index.jsp");
		} else {
			resp.sendRedirect("/LMS/pages/studRegistration.jsp");
		}

	}

}
