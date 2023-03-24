package customer;

import java.io.Serializable;
import java.util.Objects;

public class CustomerDTO implements Serializable,Cloneable,Comparable<CustomerDTO>{
	private int cust_id;
	private String cust_name;
	private String cust_address;
	private String cust_city;
	
	@Override
	public int compareTo(CustomerDTO o) {
		return	this.cust_id-o.cust_id;
	}
	private static CustomerDTO cust_dto;
	synchronized public static CustomerDTO getInstance() {
		if(cust_dto==null) {
			cust_dto=new CustomerDTO();
			return cust_dto;
		}
		else {
			return cust_dto.createClone();
		}
	}
	synchronized public CustomerDTO createClone() {
		try {
			return (CustomerDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private CustomerDTO() {
		System.out.println("invoice master dto object created...");
	}
	@Override
	public String toString() {
		return "CustomerDTO [cust_id=" + cust_id + ", cust_name=" + cust_name + ", cust_address=" + cust_address
				+ ", cust_city=" + cust_city + "]";
	}
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getCust_address() {
		return cust_address;
	}
	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}
	public String getCust_city() {
		return cust_city;
	}
	public void setCust_city(String cust_city) {
		this.cust_city = cust_city;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cust_address, cust_city, cust_id, cust_name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDTO other = (CustomerDTO) obj;
		return Objects.equals(cust_address, other.cust_address) && Objects.equals(cust_city, other.cust_city)
				&& cust_id == other.cust_id && Objects.equals(cust_name, other.cust_name);
	}
	
}

