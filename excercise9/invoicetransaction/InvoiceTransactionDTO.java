package invoicetransaction;

import java.io.Serializable;
import java.util.Objects;

public class InvoiceTransactionDTO implements Serializable,Cloneable,Comparable<InvoiceTransactionDTO>{
	private int inv_id;
	private int item_id;
	private int qty;
	private float price;
	
	private InvoiceTransactionDTO(){
		System.out.println("Item master object created!");
	}
	
	@Override
	public int compareTo(InvoiceTransactionDTO o) {
		return	this.inv_id-o.inv_id;
	}
	
	private static InvoiceTransactionDTO dto;
	synchronized public static InvoiceTransactionDTO getInstance() {
		if(dto==null) {
			dto=new InvoiceTransactionDTO();
			return dto;
		}
		else {
			return dto.createClone();
		}
	}
	synchronized public InvoiceTransactionDTO createClone() {
		try {
			return (InvoiceTransactionDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int getInv_id() {
		return inv_id;
	}

	public void setInv_id(int inv_id) {
		this.inv_id = inv_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
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

	@Override
	public int hashCode() {
		return Objects.hash(inv_id, item_id, price, qty);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceTransactionDTO other = (InvoiceTransactionDTO) obj;
		return inv_id == other.inv_id && item_id == other.item_id
				&& Float.floatToIntBits(price) == Float.floatToIntBits(other.price) && qty == other.qty;
	}

	@Override
	public String toString() {
		return "InvoiceTransactionDTO [inv_id=" + inv_id + ", item_id=" + item_id + ", qty=" + qty + ", price=" + price
				+ "]";
	}
	
}
