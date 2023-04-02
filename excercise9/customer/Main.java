package customer;

import java.sql.Connection;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import jdbcutility.JDBCUtility;

public class Main {
	public static void main(String[] args) {
		try (
				Scanner  scanner = new Scanner(System.in);
				){
//			getting the connection object
			Connection customerConnection = JDBCUtility.getConnection();
			
//			declaring the variables
			String customerName,customerAddress,customerCity;
			
//			creating dao singleton object
			CustomerDao custDAO = CustomerDao.getSingleTon();
//			find by primary key
			CustomerDto custDTO =  custDAO.findByPrimaryKey(3, customerConnection);
			System.out.println("<------ FIND BY ID------>");
			System.out.println(custDTO);
			
//			find all the customers
			List<CustomerDto> custList = custDAO.findAll(customerConnection);
			System.out.println("<------ FIND ALL------>");
			for(CustomerDto cust:custList) {
				System.out.println(cust);
			}
			
//			update customer city by city name
			System.out.println("<------UPDATE BY CITY NAME------>");
			int noOfRowsAffected = custDAO.updateCustomer("chennai", "thiruvallur", customerConnection);
			System.out.println("No of customer records changed : "+noOfRowsAffected);
			
//			delete from customer
			System.out.println("<------DELETE BY ID------>");
			System.out.println("No of records deleted : "+custDAO.deleteCustomer(1, customerConnection));
			
//			getting data from the user to insert into the customer
			System.out.println("<------INSERT INTO CUSTOMER TABLE------>");
			
			System.out.println("Enter customer name : ");
			customerName = scanner.nextLine();
			System.out.println("Enter the customer address : ");
			customerAddress = scanner.nextLine();
			System.out.println("Enter the customer city : ");
			customerCity = scanner.nextLine();
			
//			creating dto object
			CustomerDto customerDto = CustomerDto.getInstance();
			
//			input validation
			if(customerName.matches("[a-zA-Z]+")==false || customerAddress.matches("[a-zA-Z]+")==false || customerCity.matches("[a-zA-Z]+")==false) {
				throw new InputMismatchException("It can be only characters!");
			}
			customerDto.setCustName(customerName);
			customerDto.setCustAddress(customerAddress);
			customerDto.setCustCity(customerCity);
			
//			inserting the data into the table
			custDAO.insertCustomer(customerDto, customerConnection);
			System.out.println("Record inserted");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
