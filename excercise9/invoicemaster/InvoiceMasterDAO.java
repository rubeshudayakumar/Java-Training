package invoicemaster;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InvoiceMasterDao {
//	declaring singleton variable
	private static InvoiceMasterDao dao;

//	creating the static method for creating the singleton variable and if it is the first time it will return new object or else it will return previous object
	synchronized public static InvoiceMasterDao getSingleTon() {
		if (dao == null) {
			dao = new InvoiceMasterDao();
			return dao;
		} else {
			return dao;
		}
	}

//	providing the prototype method if it requires to create multiple objects other than singleton 
	synchronized public static InvoiceMasterDao getPrototype() {
		if (dao == null) {
			dao = new InvoiceMasterDao();
			return dao;
		} else {
			return dao.getClone();
		}
	}

//	clone method to create clone object
	synchronized public InvoiceMasterDao getClone() {
		try {
			return (InvoiceMasterDao) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	constructor to indicate the object creation
	private InvoiceMasterDao() {
		System.out.println("invoice master dao");
	}

//	creating find by id method to find the data by id 
	public InvoiceMasterDto findByPrimaryKey(int id, Connection con) {

		try {
			PreparedStatement stmt = con.prepareStatement("select * from INVOICE_MASTER where inv_id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			InvoiceMasterDto dto = InvoiceMasterDto.getInstance();

			if (rs.next()) {
				dto.setInvId(rs.getInt(1));
				dto.setInvDate(rs.getDate(2));
				dto.setCustId(rs.getInt(3));
				dto.setInvAmt(rs.getFloat(4));
				dto.setDiscount(rs.getInt(5));
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
	public List<InvoiceMasterDto> findAll(Connection con) {

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from INVOICE_MASTER");

			List<InvoiceMasterDto> dtoList = new ArrayList<>();

			while (rs.next()) {
				InvoiceMasterDto dto = InvoiceMasterDto.getInstance();

				dto.setInvId(rs.getInt(1));
				dto.setInvDate((java.sql.Date) rs.getDate(2));
				dto.setCustId(rs.getInt(3));
				dto.setInvAmt(rs.getFloat(4));
				dto.setDiscount(rs.getInt(5));

				dtoList.add(dto);
			}
			return dtoList;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		;
		return null;
	}

//	creating the update method to update column of particular id
	public int updateInvoiceMaster(int id, int discount, Connection conn) {
		try {
			PreparedStatement stmt = conn.prepareStatement("update INVOICE_MASTER set discount=? where inv_id=?");
			stmt.setInt(1, discount);
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
	public int deleteInvoiceMaster(int id, Connection conn) {
		try {
			PreparedStatement stmt = conn.prepareStatement("delete from INVOICE_MASTER where inv_id = ?");
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
	public int insertInvoiceMaster(InvoiceMasterDto dto, Connection conn) {

		try {
			PreparedStatement stmt = conn.prepareStatement(
					" insert into INVOICE_MASTER(inv_date,cust_id,inv_amt,discount) values(?,?,?,?);");
			stmt.setDate(1, dto.getInvDate());
			stmt.setInt(2, dto.getCustId());
			stmt.setFloat(3, dto.getInvAmt());
			stmt.setInt(4, dto.getDiscount());
			int rowsInserted = stmt.executeUpdate();
			conn.commit();
			return rowsInserted;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

}
