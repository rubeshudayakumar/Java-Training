package itemmaster;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;
import jdbcutility.JDBCUtility;

public class Main {
	public static void main(String[] args) {
		String item_name;
		float item_price;
		int unit;
		
		Scanner scanner = new Scanner(System.in);
		
		Connection itemMasterConnection = JDBCUtility.getConnection();
		
		ItemMasterDAO dao = ItemMasterDAO.getSingleTon();
		
		System.out.println("<------ FIND BY ID------>");
		System.out.println(dao.findByPrimaryKey(1, itemMasterConnection));
		
		List<ItemMasterDTO> dtoList = dao.findAll(itemMasterConnection);
		System.out.println("<------ FIND ALL------>");
		for(ItemMasterDTO cust:dtoList) {
			System.out.println(cust);
		}

		System.out.println("<------UPDATE------>");
		int noOfRowsAffected = dao.updateItemMaster("mobile", 20000, itemMasterConnection);
		System.out.println("No of customer records changed : "+noOfRowsAffected);
		
		System.out.println("<------DELETE BY ID------>");
		System.out.println("No of records deleted : "+dao.deleteItemMaster(4, itemMasterConnection));
		
		System.out.println("<------INSERT INTO TABLE------>");
		
		System.out.println("Enter the item name : ");
		item_name = scanner.nextLine();
		
		System.out.println("Enter the item price : ");
		item_price = scanner.nextFloat();
		
		System.out.println("Enter the unit : ");
		unit = scanner.nextInt();
		
		ItemMasterDTO itemDto = ItemMasterDTO.getInstance();
		
		itemDto.setItem_name(item_name);
		itemDto.setItem_price(item_price);
		itemDto.setUnit(unit);
		
		dao.insertInvoiceMaster(itemDto, itemMasterConnection);
		
		System.out.println("Record inserted");
		scanner.close();
	}
}
