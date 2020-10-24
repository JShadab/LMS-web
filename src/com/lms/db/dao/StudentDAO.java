package com.lms.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lms.beans.Student;
import com.lms.db.DbConnection;

public class StudentDAO {

	public static Student getStudent(String email, String password) {

		String sql = "SELECT * FROM student WHERE email=? AND password=?";

		Student student = null;

		try (Connection conn = DbConnection.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String course = rs.getString("course");

				student = new Student(id, name, email, course, password);

			}
			rs.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return student;
	}

	public static List<Student> getAllStudent() {

		String sql = "SELECT * FROM student";

		List<Student> students = new ArrayList<>();

		try (Connection conn = DbConnection.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String course = rs.getString("course");
				String email = rs.getString("email");
				String password = rs.getString("password");

				students.add(new Student(id, name, email, course, password));

			}
			rs.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return students;
	}

	public static boolean save(Student student) {

		String sql = "INSERT INTO student (name, course, email, password) VALUES(?,?,?,?)";

		boolean isSaved = true;

		try (Connection conn = DbConnection.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, student.getName());
			ps.setString(2, student.getCourse());
			ps.setString(3, student.getEmail());
			ps.setString(4, student.getPassword());

			ps.executeUpdate();

		} catch (SQLException e) {
			isSaved = false;
			e.printStackTrace();
		}

		return isSaved;
	}

	public static boolean edit(Student student) {

		String sql = "UPDATE student SET name=?, email=?, password=?, course=? WHERE id=?";

		try (Connection conn = DbConnection.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, student.getName());
			ps.setString(2, student.getEmail());
			ps.setString(3, student.getPassword());
			ps.setString(4, student.getCourse());
			ps.setInt(5, student.getId());

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

	}

}
