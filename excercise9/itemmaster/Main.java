package itemmaster;

import java.sql.Connection;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import jdbcutility.JDBCUtility;

public class Main {
	public static void main(String[] args) {
		try(
				Scanner scanner = new Scanner(System.in);
				) {
//			declaring the variables
			String itemName;
			float itemPrice;
			int unit;
			
//			getting the connection object
			Connection itemMasterConnection = JDBCUtility.getConnection();
			
//			creating dao singleton object
			ItemMasterDao dao = ItemMasterDao.getSingleTon();
			
//			find by primary key
			System.out.println("<------ FIND BY ID------>");
			System.out.println(dao.findByPrimaryKey(1, itemMasterConnection));
			
//			find all the item master
			List<ItemMasterDto> dtoList = dao.findAll(itemMasterConnection);
			System.out.println("<------ FIND ALL------>");
			for(ItemMasterDto cust:dtoList) {
				System.out.println(cust);
			}

//			update the item master by id
			System.out.println("<------UPDATE------>");
			int noOfRowsAffected = dao.updateItemMaster("mobile", 20000, itemMasterConnection);
			System.out.println("No of customer records changed : "+noOfRowsAffected);
			
//			delete the item master by id
			System.out.println("<------DELETE BY ID------>");
			System.out.println("No of records deleted : "+dao.deleteItemMaster(4, itemMasterConnection));
			
//			getting the data from the user for inserting
			System.out.println("<------INSERT INTO TABLE------>");
			System.out.println("Enter the item name : ");
			itemName = scanner.nextLine();
			System.out.println("Enter the item price : ");
			itemPrice = scanner.nextFloat();
			System.out.println("Enter the unit : ");
			unit = scanner.nextInt();
			
//			input validation
			if(itemName.matches("[a-zA-Z]+")==false || itemPrice<0 || unit<0) {
				throw new InputMismatchException("Input is invalid");
			}
			
//			creating the dto object
			ItemMasterDto itemDto = ItemMasterDto.getInstance();
			itemDto.setItemName(itemName);
			itemDto.setItemPrice(itemPrice);
			itemDto.setUnit(unit);
			
//			inserting the data into the table
			dao.insertInvoiceMaster(itemDto, itemMasterConnection);
			System.out.println("Record inserted");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
