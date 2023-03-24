package jdbcexcercise;

import java.sql.*;

class CreateTable {
	Connection con;
	Statement stmt;
	ResultSet rs;

	CreateTable() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root@123");
			stmt = con.createStatement();
			int i = stmt.executeUpdate("create table pradeep(empno integer,ename varchar(20),deptno integer)");
			System.err.println("No of tables created : "+i);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

class TableMaker {
	public static void main(String args[]) {
		new CreateTable();
	}
}