package jdbcexcercise;

import java.sql.*;

class InsertRow {
	Connection con;
	Statement stmt;
	ResultSet rs;

	InsertRow() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root@123");
			stmt = con.createStatement();
			boolean row1 = stmt.execute(" insert into pradeep values (001,'sakre',23)");
			boolean row2 = stmt.execute(" insert into pradeep values (001,'pradeep',223)");
			boolean row3 = stmt.execute(" insert into pradeep values (001,'vivek',243)");
			
			rs=stmt.executeQuery("select * from pradeep");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + "" + rs.getInt(3));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

class RowInserter {
	public static void main(String args[]) {
		new InsertRow();
	}
}
