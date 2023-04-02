package invoicetransaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InvoiceTransactionDao {
//	declaring singleton variable
	private static InvoiceTransactionDao dao;

//	creating the static method for creating the singleton variable and if it is the first time it will return new object or else it will return previous object
	synchronized public static InvoiceTransactionDao getSingleTon() {
		if (dao == null) {
			dao = new InvoiceTransactionDao();
			return dao;
		} else {
			return dao;
		}
	}

//	providing the prototype method if it requires to create multiple objects other than singleton 
	synchronized public static InvoiceTransactionDao getPrototype() {
		if (dao == null) {
			dao = new InvoiceTransactionDao();
			return dao;
		} else {
			return dao.getClone();
		}
	}

//	clone method to create to clone object
	synchronized public InvoiceTransactionDao getClone() {
		try {
			return (InvoiceTransactionDao) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	constructor to indicate the object creation
	private InvoiceTransactionDao() {
		System.out.println("invoice transaction dao");
	}

//	creating find by id method to find the data by id 
	public InvoiceTransactionDto findByPrimaryKey(int id, Connection con) {

		try {
			PreparedStatement stmt = con.prepareStatement("select * from INV_TRANSACTION where inv_id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			InvoiceTransactionDto dto = InvoiceTransactionDto.getInstance();

			if (rs.next()) {
				dto.setInvId(id);
				dto.setItemId(rs.getInt(2));
				dto.setQty(rs.getInt(3));
				dto.setPrice(rs.getFloat(4));
				return dto;
			}

			if (rs.next()) {

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

//	creating a method which finds the list of all users from the table
	public List<InvoiceTransactionDto> findAll(Connection con) {

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from INV_TRANSACTION");

			List<InvoiceTransactionDto> dtoList = new ArrayList<>();

			while (rs.next()) {
				InvoiceTransactionDto dto = InvoiceTransactionDto.getInstance();

				dto.setInvId(rs.getInt(1));
				dto.setItemId(rs.getInt(2));
				dto.setPrice(rs.getFloat(3));
				dto.setQty(rs.getInt(4));

				dtoList.add(dto);
			}
			return dtoList;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

//	creating the update method to update column of particular id
	public int updateInvoiceTransaction(float price, int id, Connection conn) {
		try {
			PreparedStatement stmt = conn.prepareStatement("update INV_TRANSACTION set price=? where inv_id=?");
			stmt.setFloat(1, price);
			stmt.setInt(2, id);
			int noOfRowsAffected = stmt.executeUpdate();
			conn.commit();
			return noOfRowsAffected;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

//	creating  a method to delete a row by id
	public int deleteInvoiceTransaction(int id, Connection conn) {
		try {
			PreparedStatement stmt = conn.prepareStatement("delete from INV_TRANSACTION where inv_id = ?");
			stmt.setInt(1, id);
			int noOfRowsAffected = stmt.executeUpdate();
			conn.commit();
			return noOfRowsAffected;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

//	creating a method to insert a new record into the table
	public int insertInvoiceTransaction(InvoiceTransactionDto dto, Connection conn) {

		try {
			PreparedStatement stmt = conn
					.prepareStatement(" insert into INV_TRANSACTION(inv_id,item_id,qty,price) values(?,?,?,?);");
			stmt.setInt(1, dto.getInvId());
			stmt.setInt(2, dto.getItemId());
			stmt.setInt(3, dto.getQty());
			stmt.setFloat(4, dto.getPrice());
			int rowsInserted = stmt.executeUpdate();
			conn.commit();
			return rowsInserted;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
