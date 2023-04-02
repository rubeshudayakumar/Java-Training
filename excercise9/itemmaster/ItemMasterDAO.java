package itemmaster;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemMasterDao {
//	declaring singleton variable
	private static ItemMasterDao dao;

//	creating the static method for creating the singleton variable and if it is the first time it will return new object or else it will return previous object
	synchronized public static ItemMasterDao getSingleTon() {
		if (dao == null) {
			dao = new ItemMasterDao();
			return dao;
		} else {
			return dao;
		}
	}

//	providing the prototype method if it requires to create multiple objects other than singleton 
	synchronized public static ItemMasterDao getPrototype() {
		if (dao == null) {
			dao = new ItemMasterDao();
			return dao;
		} else {
			return dao.getClone();
		}
	}

//	clone method to create clone object
	synchronized public ItemMasterDao getClone() {
		try {
			return (ItemMasterDao) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	constructor to indicate the object creation
	private ItemMasterDao() {
		System.out.println("item master dao");
	}

//	creating find by id method to find the data by id 
	public ItemMasterDto findByPrimaryKey(int id, Connection con) {

		try {
			PreparedStatement stmt = con.prepareStatement("select * from ITEM_MASTER where item_id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			ItemMasterDto dto = ItemMasterDto.getInstance();

			if (rs.next()) {
				dto.setItemId(rs.getInt(1));
				dto.setItemName(rs.getString(2));
				dto.setItemPrice(rs.getFloat(3));
				dto.setUnit(rs.getInt(4));
				return dto;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

//	creating a method which finds the list of all users from the table
	public List<ItemMasterDto> findAll(Connection con) {

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from ITEM_MASTER");

			List<ItemMasterDto> dtoList = new ArrayList<>();

			while (rs.next()) {
				ItemMasterDto dto = ItemMasterDto.getInstance();

				dto.setItemId(rs.getInt(1));
				dto.setItemName(rs.getString(2));
				dto.setItemPrice(rs.getFloat(3));
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

//	creating the update method to update column of particular id
	public int updateItemMaster(String itemName, float price, Connection conn) {
		try {
			PreparedStatement stmt = conn.prepareStatement("update ITEM_MASTER set item_price=? where item_name=?");
			stmt.setFloat(1, price);
			stmt.setString(2, itemName);
			int noOfRowsAffected = stmt.executeUpdate();
			conn.commit();
			return noOfRowsAffected;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

//	creating  a method to delete a row by id
	public int deleteItemMaster(int id, Connection conn) {
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

//	creating a method to insert a new record into the table
	public int insertInvoiceMaster(ItemMasterDto dto, Connection conn) {

		try {
			PreparedStatement stmt = conn
					.prepareStatement("insert into ITEM_MASTER(item_name,item_price,unit) values(?,?,?)");
			stmt.setString(1, dto.getItemName());
			stmt.setFloat(2, dto.getItemPrice());
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
