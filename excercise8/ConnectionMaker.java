package jdbcexcercise;

import java.sql.*;

class MakeConnection {
	Connection con;
	Statement stmt;
	ResultSet rs;

	MakeConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root@123");
			stmt = con.createStatement();
			rs = stmt.executeQuery("Select * from emp");
			while (rs.next())
				System.out.println(rs.getString(1) + " " + rs.getInt(2));
		} catch (Exception e) {
		}
	}
}

class ConnectionMaker {
	public static void main(String args[]) {
		new MakeConnection();
	}
}
