package invoicemaster;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import jdbcutility.JDBCUtility;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int inv_id;
		Date inv_date;
		int cust_id;
		float inv_amt;
		int discount;
		
		Connection invoiceMasterConnection = JDBCUtility.getConnection();
		
		InvoiceMasterDAO dao = InvoiceMasterDAO.getSingleTon();
		
		InvoiceMasterDTO dto =  dao.findByPrimaryKey(1, invoiceMasterConnection);
		System.out.println("<------ FIND BY ID------>");
		System.out.println(dto);
		
		List<InvoiceMasterDTO> dtoList = dao.findAll(invoiceMasterConnection);
		System.out.println("<------ FIND ALL------>");
		for(InvoiceMasterDTO cust:dtoList) {
			System.out.println(cust);
		}
		
		
		System.out.println("<------UPDATE---->");
		int noOfRowsAffected = dao.updateInvoiceMaster(1,5,invoiceMasterConnection);
		System.out.println("No of customer records changed : "+noOfRowsAffected);
		
		System.out.println("<------DELETE BY ID------>");
		System.out.println("No of records deleted : "+dao.deleteInvoiceMaster(4, invoiceMasterConnection));
		
		System.out.println("<------INSERT INTO CUSTOMER TABLE------>");
		
		System.out.println("Enter invoice id : ");
		inv_id = scanner.nextInt();
		
		System.out.println("Enter the invoice date : ");
		inv_date = Date.valueOf(scanner.next());
		
		System.out.println("Enter the customer id : ");
		cust_id = scanner.nextInt();
		
		System.out.println("Enter the invoice amount : ");
		inv_amt = scanner.nextFloat();
		
		System.out.println("Enter the discount : ");
		discount = scanner.nextInt();
		
		InvoiceMasterDTO inv_dto = InvoiceMasterDTO.getInstance();
		inv_dto.setCust_id(cust_id);
		inv_dto.setDiscount(discount);
		inv_dto.setInv_amt(inv_amt);
		inv_dto.setInv_date(inv_date);
		inv_dto.setInv_id(inv_id);
		
		dao.insertInvoiceMaster(inv_dto, invoiceMasterConnection);
		
		System.out.println("Record inserted");
		scanner.close();
		
	}
}
