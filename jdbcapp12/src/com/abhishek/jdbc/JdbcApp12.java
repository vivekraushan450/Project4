package com.abhishek.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp12 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", "root", "Abhishek123");
			st = con.createStatement();
			
			int rowCount = st.executeUpdate("select * from emp1");
			System.out.println("RowCount	: "+rowCount);
			rs = st.getResultSet();
			System.out.println("+-----+-------+-------+------+");
			System.out.println("|ENO  |\tENAME |\tESAL  |\tEADDR|");
			System.out.println("+-----+-------+-------+------+");
			while(rs.next()) {
				System.out.print("|" +rs.getString(1)+ "  |\t");
				System.out.print(rs.getString(2)+ "   |\t");
				System.out.print(rs.getString(3)+ "|");
				System.out.print(rs.getString(4)+ "   |\n");
				System.out.println("+-----+-------+-------+------+");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				st.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}