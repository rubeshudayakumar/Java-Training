package invoicetransaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InvoiceTransactionDAO {
	private static InvoiceTransactionDAO dao;
	synchronized public static InvoiceTransactionDAO getSingleTon() {
		if(dao==null) {
			dao=new InvoiceTransactionDAO();
			return dao;
		}
		else{
			return dao;
		}
	}
	
	synchronized public static InvoiceTransactionDAO getPrototype() {
		if(dao==null) {
			dao=new InvoiceTransactionDAO();
			return dao;
		}
		else {
			return dao.getClone();
		}
	}
	synchronized public InvoiceTransactionDAO getClone() {
		try {
			return (InvoiceTransactionDAO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private InvoiceTransactionDAO() {
		System.out.println("invoice transaction dao");
	}
	
	
	public InvoiceTransactionDTO findByPrimaryKey(int id,Connection con) {
		
		try {
			PreparedStatement stmt = con.prepareStatement("select * from INV_TRANSACTION where inv_id = ?");		
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			InvoiceTransactionDTO dto = InvoiceTransactionDTO.getInstance();
			
			if(rs.next()) {
				dto.setInv_id(id);
				dto.setItem_id(rs.getInt(2));
				dto.setQty(rs.getInt(3));
				dto.setPrice(rs.getFloat(4));
				return dto;
			}
			
			if(rs.next()) {
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<InvoiceTransactionDTO> findAll(Connection con){
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs =  stmt.executeQuery("select * from INV_TRANSACTION");
			
			List<InvoiceTransactionDTO> dtoList = new  ArrayList<>();
			
			while(rs.next()) {
				InvoiceTransactionDTO dto = InvoiceTransactionDTO.getInstance();
				
				dto.setInv_id(rs.getInt(1));
				dto.setItem_id(rs.getInt(2));
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

	public int updateInvoiceTransaction(float price,int inv_id,Connection conn) {
		try {
			PreparedStatement stmt = conn.prepareStatement("update INV_TRANSACTION set price=? where inv_id=?");
			stmt.setFloat(1, price);
			stmt.setInt(2, inv_id);
			int noOfRowsAffected = stmt.executeUpdate();
			conn.commit();
			return noOfRowsAffected;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteInvoiceTransaction(int id,Connection conn) {
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
	
	public int insertInvoiceTransaction(InvoiceTransactionDTO dto,Connection conn) {
		
		try {
			PreparedStatement stmt = conn.prepareStatement(" insert into INV_TRANSACTION(inv_id,item_id,qty,price) values(?,?,?,?);");
			stmt.setInt(1, dto.getInv_id());
			stmt.setInt(2, dto.getItem_id());
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
