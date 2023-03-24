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
			int i1 = stmt.executeUpdate(" insert into pradeep values (001,'sakre',23)");
			int i2 = stmt.executeUpdate(" insert into pradeep values (001,'pradeep',223)");
			int i3 = stmt.executeUpdate(" insert into pradeep values (001,'vivek',243)");
			System.out.println("No of rows inserted : " + (i1 + i2 + i3));
			
			rs=stmt.executeQuery("select * from pradeep");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + "" + rs.getInt(3));
			}

		} catch (

		Exception e) {
			System.out.println(e);
		}
	}
}

class RowInserter {
	public static void main(String args[]) {
		new InsertRow();
	}
}
