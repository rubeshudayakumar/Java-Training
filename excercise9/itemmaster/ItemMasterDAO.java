package itemmaster;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemMasterDAO {
	private static ItemMasterDAO dao;
	synchronized public static ItemMasterDAO getSingleTon() {
		if(dao==null) {
			dao=new ItemMasterDAO();
			return dao;
		}
		else{
			return dao;
		}
	}
	
	synchronized public static ItemMasterDAO getPrototype() {
		if(dao==null) {
			dao=new ItemMasterDAO();
			return dao;
		}
		else {
			return dao.getClone();
		}
	}
	synchronized public ItemMasterDAO getClone() {
		try {
			return (ItemMasterDAO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private ItemMasterDAO() {
		System.out.println("item master dao");
	}
	
	public ItemMasterDTO findByPrimaryKey(int id,Connection con) {
		
		try {
			PreparedStatement stmt = con.prepareStatement("select * from ITEM_MASTER where item_id = ?");		
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			ItemMasterDTO dto = ItemMasterDTO.getInstance();
			
			if(rs.next()) {
				dto.setItem_id(rs.getInt(1));
				dto.setItem_name(rs.getString(2));
				dto.setItem_price(rs.getFloat(3));
				dto.setUnit(rs.getInt(4));
				return dto;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<ItemMasterDTO> findAll(Connection con){
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs =  stmt.executeQuery("select * from ITEM_MASTER");
			
			List<ItemMasterDTO> dtoList = new  ArrayList<>();
			
			while(rs.next()) {
				ItemMasterDTO dto = ItemMasterDTO.getInstance();
				
				dto.setItem_id(rs.getInt(1));
				dto.setItem_name(rs.getString(2));
				dto.setItem_price(rs.getFloat(3));
				dto.setUnit(rs.getInt(4));
				
				dtoList.add(dto);
			}
			return dtoList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
;		
		return null;
	}

	public int updateItemMaster(String item_name,float price,Connection conn) {
		try {
			PreparedStatement stmt = conn.prepareStatement("update ITEM_MASTER set item_price=? where item_name=?");
			stmt.setFloat(1, price);
			stmt.setString(2, item_name);
			int noOfRowsAffected = stmt.executeUpdate();
			conn.commit();
			return noOfRowsAffected;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteItemMaster(int id,Connection conn) {
		try {
			PreparedStatement stmt = conn.prepareStatement("delete from ITEM_MASTER where item_id = ?");
			stmt.setInt(1, id);
			int noOfRowsAffected = stmt.executeUpdate();
			conn.commit();
			return noOfRowsAffected;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int insertInvoiceMaster(ItemMasterDTO dto,Connection conn) {
		
		try {
			PreparedStatement stmt = conn.prepareStatement("insert into ITEM_MASTER(item_name,item_price,unit) values(?,?,?)");
			stmt.setString(1,dto.getItem_name());
			stmt.setFloat(2, dto.getItem_price());
			stmt.setInt(3, dto.getUnit());
			int rowsInserted = stmt.executeUpdate();
			conn.commit();
			return rowsInserted;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
}
