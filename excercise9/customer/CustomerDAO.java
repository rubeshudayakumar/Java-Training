package customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CustomerDAO {
	
	private static CustomerDAO dao;
	synchronized public static CustomerDAO getSingleTon() {
		if(dao==null) {
			dao=new CustomerDAO();
			return dao;
		}
		else{
			return dao;
		}
	}
	
	synchronized public static CustomerDAO getPrototype() {
		if(dao==null) {
			dao=new CustomerDAO();
			return dao;
		}
		else {
			return dao.getClone();
		}
	}
	synchronized public CustomerDAO getClone() {
		try {
			return (CustomerDAO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private CustomerDAO() {
		System.out.println("customer dao");
	}

	
	public CustomerDTO findByPrimaryKey(int id,Connection con) {
		
		try {
			PreparedStatement stmt = con.prepareStatement("select * from CUSTOMER where cust_id=?");		
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			CustomerDTO dto = CustomerDTO.getInstance();
			
			if(rs.next()) {
				dto.setCust_id(id);
				dto.setCust_name(rs.getString(2));
				dto.setCust_address(rs.getString(3));
				dto.setCust_city(rs.getString(4));
				return dto;
			}
			
			if(rs.next()) {
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<CustomerDTO> findAll(Connection con){
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs =  stmt.executeQuery("select * from CUSTOMER");
			
			List<CustomerDTO> custList = new  ArrayList<>();
			
			while(rs.next()) {
				CustomerDTO custDTO = CustomerDTO.getInstance();
				
				custDTO.setCust_id(rs.getInt(1));
				custDTO.setCust_name(rs.getString(2));
				custDTO.setCust_address(rs.getString(3));
				custDTO.setCust_city(rs.getString(4));
				
				custList.add(custDTO);
			}
			return custList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
;		
		return null;
	}
	
	public int updateCustomer(String currentCityName,String cityNameToBeChanged,Connection conn) {
		try {
			PreparedStatement stmt = conn.prepareStatement("update CUSTOMER set cust_city=? where cust_city=?");
			stmt.setString(1, cityNameToBeChanged);
			stmt.setString(2, currentCityName);
			int noOfRowsAffected = stmt.executeUpdate();
			conn.commit();
			return noOfRowsAffected;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteCustomer(int id,Connection conn) {
		try {
			PreparedStatement stmt = conn.prepareStatement("delete from CUSTOMER where cust_id = ?");
			stmt.setInt(1, id);
			int noOfRowsAffected = stmt.executeUpdate();
			conn.commit();
			return noOfRowsAffected;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int insertCustomer(CustomerDTO custDTO,Connection conn) {
		
		try {
			PreparedStatement stmt = conn.prepareStatement("insert into CUSTOMER(cust_name,cust_address,cust_city) values(?,?,?)");
			stmt.setString(1, custDTO.getCust_name());
			stmt.setString(2, custDTO.getCust_address());
			stmt.setString(3, custDTO.getCust_city());
			int rowsInserted = stmt.executeUpdate();
			conn.commit();
			return rowsInserted;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
}
