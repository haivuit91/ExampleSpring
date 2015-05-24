package com.asiantech.haivu.spring.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.asiantech.haivu.spring.dao.UserDao;
import com.asiantech.haivu.spring.entity.User;

public class UserDaoImpl implements UserDao {

	@Autowired
	private DataSource dataSource;

	private int pageNumber;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<User> getListUser() {
		List<User> userList = new ArrayList<>();
		String sql = "SELECT * FROM User ORDER BY userID DESC";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt("userID"));
				user.setUserName(rs.getString("userName"));
				user.setPwd(rs.getString("pwd"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setEmail(rs.getString("email"));
				user.setActive(rs.getBoolean("isActive"));
				userList.add(user);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					rs.close();
					ps.close();
					conn.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return userList;
	}

	@Override
	public User getUser(int userId) {
		User user = new User();
		String sql = "SELECT * FROM User WHERE userID = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			while (rs.next()) {
				user.setUserId(rs.getInt("userID"));
				user.setUserName(rs.getString("userName"));
				user.setPwd(rs.getString("pwd"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setEmail(rs.getString("email"));
				user.setActive(rs.getBoolean("isActive"));

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					rs.close();
					ps.close();
					conn.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return user;
	}

	@Override
	public boolean addUser(User user) {
		boolean isCheck = false;
		String sql = "INSERT INTO User (userName, pwd, firstName, lastName, email, isActive) VALUES (?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPwd());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			ps.setString(5, user.getEmail());
			ps.setBoolean(6, user.isActive());
			int check = ps.executeUpdate();
			if (check != 0) {
				isCheck = true;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					ps.close();
					conn.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return isCheck;
	}

	@Override
	public boolean updateUser(User user) {
		boolean isCheck = false;
		String sql = "UPDATE User SET userName = ?, pwd = ?, firstName = ?, lastName = ?, email = ?, isActive = ?"
				+ " WHERE userID = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPwd());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			ps.setString(5, user.getEmail());
			ps.setBoolean(6, user.isActive());
			ps.setInt(7, user.getUserId());
			int check = ps.executeUpdate();
			if (check != 0) {
				isCheck = true;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					ps.close();
					conn.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return isCheck;
	}

	@Override
	public boolean delUser(int userId) {
		boolean isCheck = false;
		String sql = "DELETE FROM User WHERE userID = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			int check = ps.executeUpdate();
			if (check != 0) {
				isCheck = true;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					ps.close();
					conn.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return isCheck;
	}

	@Override
	public List<User> getUserPage(int pageSize, int pageNumber) {
		List<User> userList = new ArrayList<User>();
		String sql = "SELECT SQL_CALC_FOUND_ROWS * FROM User ORDER BY userID DESC LIMIT ? OFFSET ?";
		// String sql = "SELECT * FROM User LIMIT ?, ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pageNumber);
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt("userID"));
				user.setUserName(rs.getString("userName"));
				user.setPwd(rs.getString("pwd"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setEmail(rs.getString("email"));
				user.setActive(rs.getBoolean("isActive"));
				userList.add(user);
			}
			rs.close();
			rs = ps.executeQuery("SELECT FOUND_ROWS()");
			if (rs.next())
				this.pageNumber = rs.getInt(1);
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					ps.close();
					conn.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return userList;
	}

	public int getPageNumber() {
		return pageNumber;
	}
}
