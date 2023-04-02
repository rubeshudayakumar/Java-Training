package customer;

import java.io.Serializable;
import java.util.Objects;

public class CustomerDto implements Serializable,Cloneable,Comparable<CustomerDto>{
//	declaring all the dto variables 
	private int custId;
	private String custName;
	private String custAddress;
	private String custCity;
	
//	overriding the compareTo() method to compare between the objects
	@Override
	public int compareTo(CustomerDto o) {
		return	this.custId-o.custId;
	}
	
//	declaring the singleton variable
	private static CustomerDto custDto;
	
//	providing the prototype method if it requires to create multiple objects other than singleton 
	synchronized public static CustomerDto getInstance() {
		if(custDto==null) {
			custDto=new CustomerDto();
			return custDto;
		}
		else {
			return custDto.createClone();
		}
	}
	
//	clone method to create clone object
	synchronized public CustomerDto createClone() {
		try {
			return (CustomerDto)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	constructor to indicate the object creation	
	private CustomerDto() {
		System.out.println("invoice master dto object created...");
	}
	
//	providing toString() method to print the object data
	@Override
	public String toString() {
		return "CustomerDTO [custId=" + custId + ", custName=" + custName + ", custAddress=" + custAddress
				+ ", custCity=" + custCity + "]";
	}
	
//	<---------- START : GETTERS AND SETTERS ---------->
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public String getCustCity() {
		return custCity;
	}
	public void setCustCity(String custCity) {
		this.custCity = custCity;
	}
//	<---------- END : GETTERS AND SETTERS ---------->
	
//	providing hashcode and equals object to check the equality of the object
	@Override
	public int hashCode() {
		return Objects.hash(custAddress, custCity, custId, custName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDto other = (CustomerDto) obj;
		return Objects.equals(custAddress, other.custAddress) && Objects.equals(custCity, other.custCity)
				&& custId == other.custId && Objects.equals(custName, other.custName);
	}
	
}

