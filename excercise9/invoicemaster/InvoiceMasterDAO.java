package invoicemaster;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class InvoiceMasterDAO {
	private static InvoiceMasterDAO dao;
	synchronized public static InvoiceMasterDAO getSingleTon() {
		if(dao==null) {
			dao=new InvoiceMasterDAO();
			return dao;
		}
		else{
			return dao;
		}
	}
	
	synchronized public static InvoiceMasterDAO getPrototype() {
		if(dao==null) {
			dao=new InvoiceMasterDAO();
			return dao;
		}
		else {
			return dao.getClone();
		}
	}
	synchronized public InvoiceMasterDAO getClone() {
		try {
			return (InvoiceMasterDAO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private InvoiceMasterDAO() {
		System.out.println("invoice master dao");
	}
	
	public InvoiceMasterDTO findByPrimaryKey(int id,Connection con) {
		
		try {
			PreparedStatement stmt = con.prepareStatement("select * from INVOICE_MASTER where inv_id = ?");		
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			InvoiceMasterDTO dto = InvoiceMasterDTO.getInstance();
			
			if(rs.next()) {
				dto.setInv_id(rs.getInt(1));
				dto.setInv_date(rs.getDate(2));
				dto.setCust_id(rs.getInt(3));
				dto.setInv_amt(rs.getFloat(4));
				dto.setDiscount(rs.getInt(5));
				return dto;
			}
			
			if(rs.next()) {
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<InvoiceMasterDTO> findAll(Connection con){
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs =  stmt.executeQuery("select * from INVOICE_MASTER");
			
			List<InvoiceMasterDTO> dtoList = new  ArrayList<>();
			
			while(rs.next()) {
				InvoiceMasterDTO dto = InvoiceMasterDTO.getInstance();
				
				dto.setInv_id(rs.getInt(1));
				dto.setInv_date((java.sql.Date)rs.getDate(2));
				dto.setCust_id(rs.getInt(3));
				dto.setInv_amt(rs.getFloat(4));
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

	public int updateInvoiceMaster(int inv_id,int discount,Connection conn) {
		try {
			PreparedStatement stmt = conn.prepareStatement("update INVOICE_MASTER set discount=? where inv_id=?");
			stmt.setInt(1, discount);
			stmt.setInt(2, inv_id);
			int noOfRowsAffected = stmt.executeUpdate();
			conn.commit();
			return noOfRowsAffected;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteInvoiceMaster(int id,Connection conn) {
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
	
	public int insertInvoiceMaster(InvoiceMasterDTO dto,Connection conn) {
		
		try {
			PreparedStatement stmt = conn.prepareStatement(" insert into INVOICE_MASTER(inv_date,cust_id,inv_amt,discount) values(?,?,?,?);");
			stmt.setDate(1,dto.getInv_date());
			stmt.setInt(2, dto.getCust_id());
			stmt.setFloat(3, dto.getInv_amt());
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
