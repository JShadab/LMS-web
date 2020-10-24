package com.lms.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lms.db.DbConnection;

public class AdminDAO {

	public static boolean isAuthenticated(String email, String password) {

		Connection conn = DbConnection.getConnection();

		String sql = "SELECT * FROM admin WHERE email=? AND password=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;
	}

}
