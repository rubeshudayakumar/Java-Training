package invoicemaster;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class InvoiceMasterDto implements Serializable,Cloneable,Comparable<InvoiceMasterDto>{
//	declaring all the dto variables 
	private int invId;
	private Date invDate;
	private int custId;
	private float invAmt;
	private int discount;
	
//	constructor to indicate the object creation
	private InvoiceMasterDto(){
		System.out.println("Item master object created!");
	}
	
//	overriding the compareTo() method to compare between the objects
	@Override
	public int compareTo(InvoiceMasterDto o) {
		return	this.invId-o.invId;
	}
	
//	declaring the singleton variable
	private static InvoiceMasterDto dto;
	
//	providing the prototype method if it requires to create multiple objects other than singleton 
	synchronized public static InvoiceMasterDto getInstance() {
		if(dto==null) {
			dto=new InvoiceMasterDto();
			return dto;
		}
		else {
			return dto.createClone();
		}
	}
	
//	clone method to create clone object
	synchronized public InvoiceMasterDto createClone() {
		try {
			return (InvoiceMasterDto)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	<---------- START : GETTERS AND SETTERS ---------->
	public int getInvId() {
		return invId;
	}

	public void setInvId(int invId) {
		this.invId = invId;
	}

	public Date getInvDate() {
		return invDate;
	}

	public void setInvDate(Date date) {
		this.invDate = date;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public float getInvAmt() {
		return invAmt;
	}

	public void setInvAmt(float invAmt) {
		this.invAmt = invAmt;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
//	<---------- END : GETTERS AND SETTERS ---------->

//	providing hashcode and equals object to check the equality of the object
	@Override
	public int hashCode() {
		return Objects.hash(custId, discount, invAmt, invDate, invId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceMasterDto other = (InvoiceMasterDto) obj;
		return custId == other.custId && discount == other.discount
				&& Float.floatToIntBits(invAmt) == Float.floatToIntBits(other.invAmt)
				&& Objects.equals(invDate, other.invDate) && invId == other.invId;
	}

//	providing toString() method to print the object data
	@Override
	public String toString() {
		return "InvoiceMasterDTO [invId=" + invId + ", invDate=" + invDate + ", custId=" + custId + ", invAmt="
				+ invAmt + ", discount=" + discount + "]";
	}
}
