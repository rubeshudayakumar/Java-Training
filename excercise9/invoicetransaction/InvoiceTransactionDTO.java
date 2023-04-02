package invoicetransaction;

import java.io.Serializable;
import java.util.Objects;

public class InvoiceTransactionDto implements Serializable,Cloneable,Comparable<InvoiceTransactionDto>{
//	declaring all the dto variables 
	private int invId;
	private int itemId;
	private int qty;
	private float price;
	
//	constructor to indicate the object creation
	private InvoiceTransactionDto(){
		System.out.println("Item master object created!");
	}
	
//	overriding the compareTo() method to compare between the objects
	@Override
	public int compareTo(InvoiceTransactionDto o) {
		return	this.invId-o.invId;
	}
	
//	declaring the singleton variable
	private static InvoiceTransactionDto dto;
	
//	providing the prototype method if it requires to create multiple objects other than singleton 
	synchronized public static InvoiceTransactionDto getInstance() {
		if(dto==null) {
			dto=new InvoiceTransactionDto();
			return dto;
		}
		else {
			return dto.createClone();
		}
	}
	
//	clone method to create clone object
	synchronized public InvoiceTransactionDto createClone() {
		try {
			return (InvoiceTransactionDto)super.clone();
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

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
//	<---------- END : GETTERS AND SETTERS ---------->

//	providing hashcode and equals object to check the equality of the object
	@Override
	public int hashCode() {
		return Objects.hash(invId, itemId, price, qty);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceTransactionDto other = (InvoiceTransactionDto) obj;
		return invId == other.invId && itemId == other.itemId
				&& Float.floatToIntBits(price) == Float.floatToIntBits(other.price) && qty == other.qty;
	}

//	providing toString() method to print the object data
	@Override
	public String toString() {
		return "InvoiceTransactionDTO [invId=" + invId + ", itemId=" + itemId + ", qty=" + qty + ", price=" + price
				+ "]";
	}
	
}
