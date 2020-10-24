package com.lms.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.beans.Student;
import com.lms.db.dao.StudentDAO;

@WebServlet("/editStudent")
public class EditStudentServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String course = req.getParameter("course");

		Student student = new Student(id, name, email, course, password);

		boolean isSaved = StudentDAO.edit(student);

		if (isSaved) {
			resp.sendRedirect("/LMS/index.jsp");
		} else {
			resp.sendRedirect("/LMS/pages/student/home.jsp");
		}

	}

}
