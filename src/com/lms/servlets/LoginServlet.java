package com.lms.servlets;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lms.beans.Student;
import com.lms.db.dao.AdminDAO;
import com.lms.db.dao.StudentDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userType = req.getParameter("userType");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		if (userType.equalsIgnoreCase("Admin")) {
			boolean isAuthenticate = AdminDAO.isAuthenticated(email, password);

			if (isAuthenticate) {

				HttpSession session = req.getSession(true);
				session.setAttribute("user", "admin");
				session.setAttribute("userType", "admin");

				resp.sendRedirect("/LMS/pages/admin/home.jsp");
			} else {
				resp.sendRedirect("/LMS/index.jsp?msg=Invalid email or password!!!");
			}

		} else if (userType.equalsIgnoreCase("Student")) {
			Student student = StudentDAO.getStudent(email, password);
			if (Objects.nonNull(student)) {

				HttpSession session = req.getSession(true);
				session.setAttribute("user", student);
				session.setAttribute("userType", "student");
				resp.sendRedirect("/LMS/pages/student/home.jsp");
			} else {
				resp.sendRedirect("/LMS/index.jsp?msg=Invalid email or password!!!");
			}
		} else {
		}

	}

}
