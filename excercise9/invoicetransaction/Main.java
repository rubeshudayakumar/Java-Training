package invoicetransaction;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;
import jdbcutility.JDBCUtility;

public class Main {
	public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
		
		int inv_id;
		int item_id;
		float price;
		int qty;
		
		Connection invoiceTransactionConnection = JDBCUtility.getConnection();
		
		InvoiceTransactionDAO dao = InvoiceTransactionDAO.getSingleTon();
		
		InvoiceTransactionDTO dto =  dao.findByPrimaryKey(1, invoiceTransactionConnection);
		System.out.println("<------ FIND BY ID------>");
		System.out.println(dto);
		
		List<InvoiceTransactionDTO> dtoList = dao.findAll(invoiceTransactionConnection);
		System.out.println("<------ FIND ALL------>");
		for(InvoiceTransactionDTO cust:dtoList) {
			System.out.println(cust);
		}

		System.out.println("<------UPDATE BY CITY NAME------>");
		int noOfRowsAffected = dao.updateInvoiceTransaction(1000,1,invoiceTransactionConnection);
		System.out.println("No of customer records changed : "+noOfRowsAffected);
		
		System.out.println("<------DELETE BY ID------>");
		System.out.println("No of records deleted : "+dao.deleteInvoiceTransaction(3, invoiceTransactionConnection));
		
		System.out.println("<------INSERT INTO TABLE------>");
		
		System.out.println("Enter invoice id : ");
		inv_id = scanner.nextInt();
		
		System.out.println("Enter the item id : ");
		item_id = scanner.nextInt();
		
		System.out.println("Enter the quantity : ");
		qty = scanner.nextInt();
		
		System.out.println("Enter the price : ");
		price = scanner.nextFloat();
		
		InvoiceTransactionDTO inv_dto = InvoiceTransactionDTO.getInstance();
		inv_dto.setInv_id(inv_id);
		inv_dto.setItem_id(item_id);
		inv_dto.setPrice(price);
		inv_dto.setQty(qty);
		
		dao.insertInvoiceTransaction(inv_dto, invoiceTransactionConnection);
		
		System.out.println("Record inserted");
		scanner.close();
		
	}
}
