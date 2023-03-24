package customer;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import jdbcutility.JDBCUtility;

public class Main {
	public static void main(String[] args) {
		Connection customerConnection = JDBCUtility.getConnection();
		
		String customerName,customerAddress,customerCity;
		Scanner  scanner = new Scanner(System.in);
		
//		find by primary key
		CustomerDAO custDAO = CustomerDAO.getSingleTon();
		CustomerDTO custDTO =  custDAO.findByPrimaryKey(3, customerConnection);
		System.out.println("<------ FIND BY ID------>");
		System.out.println(custDTO);
		
//		find all the customers
		
		List<CustomerDTO> custList = custDAO.findAll(customerConnection);
		System.out.println("<------ FIND ALL------>");
		for(CustomerDTO cust:custList) {
			System.out.println(cust);
		}
		
//		update customer city by city name
		System.out.println("<------UPDATE BY CITY NAME------>");
		int noOfRowsAffected = custDAO.updateCustomer("chennai", "thiruvallur", customerConnection);
		System.out.println("No of customer records changed : "+noOfRowsAffected);
		
//		delete from customer
		System.out.println("<------DELETE BY ID------>");
		System.out.println("No of records deleted : "+custDAO.deleteCustomer(8, customerConnection));
		
		System.out.println("<------INSERT INTO CUSTOMER TABLE------>");
		
		System.out.println("Enter customer name : ");
		customerName = scanner.nextLine();
		
		System.out.println("Enter the customer address : ");
		customerAddress = scanner.nextLine();
		
		System.out.println("Enter the customer city : ");
		customerCity = scanner.nextLine();
		
		CustomerDTO customerDTO = CustomerDTO.getInstance();
		customerDTO.setCust_name(customerName);
		customerDTO.setCust_address(customerAddress);
		customerDTO.setCust_city(customerCity);

		custDAO.insertCustomer(customerDTO, customerConnection);
		System.out.println("Record inserted");
		scanner.close();
	}
}
