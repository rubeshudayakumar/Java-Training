package invoicemaster;

import java.sql.Connection;
import java.sql.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import jdbcutility.JDBCUtility;

public class Main {
	public static void main(String[] args) {
		
		try (
				Scanner scanner = new Scanner(System.in);
				){
//			declaring the variables
			int invId;
			Date invDate;
			int custId;
			float invAmt;
			int discount;
			
//			getting the connection object
			Connection invoiceMasterConnection = JDBCUtility.getConnection();
			
//			creating dao singleton object
			InvoiceMasterDao dao = InvoiceMasterDao.getSingleTon();
			
//			find by primary key
			InvoiceMasterDto dto =  dao.findByPrimaryKey(1, invoiceMasterConnection);
			System.out.println("<------ FIND BY ID------>");
			System.out.println(dto);
			
//			find all the invoice master
			List<InvoiceMasterDto> dtoList = dao.findAll(invoiceMasterConnection);
			System.out.println("<------ FIND ALL------>");
			for(InvoiceMasterDto cust:dtoList) {
				System.out.println(cust);
			}
			
//			updating the invoice master by id
			System.out.println("<------UPDATE---->");
			int noOfRowsAffected = dao.updateInvoiceMaster(1,5,invoiceMasterConnection);
			System.out.println("No of customer records changed : "+noOfRowsAffected);
			
//			deleting the invoice master by id
			System.out.println("<------DELETE BY ID------>");
			System.out.println("No of records deleted : "+dao.deleteInvoiceMaster(4, invoiceMasterConnection));
			
//			getting the data for inserting
			
			System.out.println("<------INSERT INTO CUSTOMER TABLE------>");
			System.out.println("Enter invoice id : ");
			invId = scanner.nextInt();
			System.out.println("Enter the invoice date : ");
			invDate = Date.valueOf(scanner.next());
			System.out.println("Enter the customer id : ");
			custId = scanner.nextInt();
			System.out.println("Enter the invoice amount : ");
			invAmt = scanner.nextFloat();
			System.out.println("Enter the discount : ");
			discount = scanner.nextInt();
			
//			input validation
			if(invId<0 || custId<0 || discount<0 || invAmt<0) {
				throw new InputMismatchException("Input should not be negative!");
			}
			
//			creating dto object
			InvoiceMasterDto dtoObject = InvoiceMasterDto.getInstance();
			dtoObject.setCustId(custId);
			dtoObject.setDiscount(discount);
			dtoObject.setInvAmt(invAmt);
			dtoObject.setInvDate(invDate);
			dtoObject.setInvId(invId);
			
//			inserting it to the table
			dao.insertInvoiceMaster(dtoObject, invoiceMasterConnection);
			
			System.out.println("Record inserted");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
