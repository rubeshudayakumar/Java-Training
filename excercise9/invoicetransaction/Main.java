package invoicetransaction;

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
			int invId;
			int itemId;
			float price;
			int qty;
			
//			getting the connection object
			Connection invoiceTransactionConnection = JDBCUtility.getConnection();
			
//			creating dao singleton object
			InvoiceTransactionDao dao = InvoiceTransactionDao.getSingleTon();
			
//			find the data by primary key
			InvoiceTransactionDto dto =  dao.findByPrimaryKey(1, invoiceTransactionConnection);
			System.out.println("<------ FIND BY ID------>");
			System.out.println(dto);
			
//			getting all the invoice transaction 
			List<InvoiceTransactionDto> dtoList = dao.findAll(invoiceTransactionConnection);
			System.out.println("<------ FIND ALL------>");
			for(InvoiceTransactionDto cust:dtoList) {
				System.out.println(cust);
			}

//			updating the invoice transaction by id
			System.out.println("<------UPDATE------>");
			int noOfRowsAffected = dao.updateInvoiceTransaction(1000,1,invoiceTransactionConnection);
			System.out.println("No of customer records changed : "+noOfRowsAffected);
			
//			deleting the data by id
			System.out.println("<------DELETE BY ID------>");
			System.out.println("No of records deleted : "+dao.deleteInvoiceTransaction(3, invoiceTransactionConnection));
			
//			getting the data from the user for inserting 
			System.out.println("<------INSERT INTO TABLE------>");
			System.out.println("Enter invoice id : ");
			invId = scanner.nextInt();
			System.out.println("Enter the item id : ");
			itemId = scanner.nextInt();
			System.out.println("Enter the quantity : ");
			qty = scanner.nextInt();
			System.out.println("Enter the price : ");
			price = scanner.nextFloat();
			
//			input validation
			if(invId<0 || itemId<0 || price<0 || qty<0) {
				throw new InputMismatchException("Input should not contain negative values");
			}
			
//			creating the dto object
			InvoiceTransactionDto dtoObject = InvoiceTransactionDto.getInstance();
			dtoObject.setInvId(invId);
			dtoObject.setItemId(itemId);
			dtoObject.setPrice(price);
			dtoObject.setQty(qty);
			
//			inserting the data into the table
			dao.insertInvoiceTransaction(dtoObject, invoiceTransactionConnection);
			System.out.println("Record inserted");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
