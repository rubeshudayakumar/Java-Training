package jdbcutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;

public class JDBCUtility {
//	loading the driver class
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	creating thread local for managing connections
	private static ThreadLocal<Connection> clockRoom = new ThreadLocal<>();

	public static Connection getConnection() {
		Connection con = clockRoom.get();
//		getting the connection if it is available else new connection is made and inserted into the thread local object
		if (con == null) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root@123");
				con.setAutoCommit(false);
				clockRoom.set(con);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return con;
	}

//	method for closing the connection to the and removing the connection object from the thread local
	public static void closeConnection(Exception e, Savepoint sp) {
		Connection con = clockRoom.get();
		if (con != null) {
			try {
				if (e != null) {
					if (sp == null) {
						System.out.println(e);
						con.rollback();
					} else {
						con.rollback(sp);
						con.commit();
					}

				} else {
					con.commit();
				}
				con.close();
				clockRoom.remove();
			} catch (Exception ee) {
				ee.printStackTrace();
			}
		}
	}
	
}
