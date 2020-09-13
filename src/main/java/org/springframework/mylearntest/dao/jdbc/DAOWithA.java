package org.springframework.mylearntest.dao.jdbc;

import org.springframework.dao.CleanupFailureDataAccessException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: WhaleFall541
 * @Date: 2020/8/17 22:58
 */
public class DAOWithA implements IDAO{
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		int i = new DAOWithA().updateSomething("SELECT * FROM `sys_dept`");
		System.out.println("i = " + i);
	}

	@Override
	public int updateSomething(String sql) throws ClassNotFoundException, SQLException {
		int count = 0;
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = getConnection();
			stmt = con.createStatement();
			count++;
		} catch (Exception e) {
			if (e instanceof ClassNotFoundException)
				throw new ClassNotFoundException("注册driver失败"+e);
			if (e instanceof SQLException)
				throw new SQLException("获取连接异常");
		} finally {
			closeSource(stmt);
			closeSource(con);
		}
		return count;
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		return DriverManager.getConnection("jdbc:mysql://192.168.43.161:3306/test","root","root");
	}

	public static void closeSource(AutoCloseable obj){
		if (obj != null) {
			try {
				obj.close();
			} catch (Exception e) {
				throw new CleanupFailureDataAccessException("关闭"+obj+"失败",e);
			} finally {
				obj = null;
			}
		}
	}

}
