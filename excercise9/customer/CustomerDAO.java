package customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CustomerDao {
	
//	declaring singleton variable
	private static CustomerDao dao;
	
//	creating the static method for creating the singleton variable and if it is the first time it will return new object or else it will return previous object
	synchronized public static CustomerDao getSingleTon() {
		if(dao==null) {
			dao=new CustomerDao();
			return dao;
		}
		else{
			return dao;
		}
	}
	
//	providing the prototype method if it requires to create multiple objects other than singleton 
	synchronized public static CustomerDao getPrototype() {
		if(dao==null) {
			dao=new CustomerDao();
			return dao;
		}
		else {
			return dao.getClone();
		}
	}
	
//	clone method to create clone object
	synchronized public CustomerDao getClone() {
		try {
			return (CustomerDao)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
//	constructor to indicate the object creation
	private CustomerDao() {
		System.out.println("customer dao");
	}

//	creating find by id method to find the data by id 
	public CustomerDto findByPrimaryKey(int id,Connection con) {
		
		try {
			PreparedStatement stmt = con.prepareStatement("select * from CUSTOMER where cust_id=?");		
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			CustomerDto dto = CustomerDto.getInstance();
			
			if(rs.next()) {
				dto.setCustId(id);
				dto.setCustName(rs.getString(2));
				dto.setCustAddress(rs.getString(3));
				dto.setCustCity(rs.getString(4));
				return dto;
			}
			
			if(rs.next()) {
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
//	creating a method which finds the list of all users from the table
	public List<CustomerDto> findAll(Connection con){
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs =  stmt.executeQuery("select * from CUSTOMER");
			
			List<CustomerDto> custList = new  ArrayList<>();
			
			while(rs.next()) {
				CustomerDto custDto = CustomerDto.getInstance();
				
				custDto.setCustId(rs.getInt(1));
				custDto.setCustName(rs.getString(2));
				custDto.setCustAddress(rs.getString(3));
				custDto.setCustCity(rs.getString(4));
				
				custList.add(custDto);
			}
			return custList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
;		
		return null;
	}
	
//	creating the update method to update the column of all the rows in the table
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
	
//	creating  a method to delete a row by id
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
	
//	creating a method to insert a new record into the table
	public int insertCustomer(CustomerDto custDto,Connection conn) {
		
		try {
			PreparedStatement stmt = conn.prepareStatement("insert into CUSTOMER(cust_name,cust_address,cust_city) values(?,?,?)");
			stmt.setString(1, custDto.getCustName());
			stmt.setString(2, custDto.getCustAddress());
			stmt.setString(3, custDto.getCustCity());
			int rowsInserted = stmt.executeUpdate();
			conn.commit();
			return rowsInserted;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
}
