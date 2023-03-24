package invoicemaster;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class InvoiceMasterDTO implements Serializable,Cloneable,Comparable<InvoiceMasterDTO>{
	private int inv_id;
	private Date inv_date;
	private int cust_id;
	private float inv_amt;
	private int discount;
	
	private InvoiceMasterDTO(){
		System.out.println("Item master object created!");
	}
	
	@Override
	public int compareTo(InvoiceMasterDTO o) {
		return	this.inv_id-o.inv_id;
	}
	
	private static InvoiceMasterDTO dto;
	synchronized public static InvoiceMasterDTO getInstance() {
		if(dto==null) {
			dto=new InvoiceMasterDTO();
			return dto;
		}
		else {
			return dto.createClone();
		}
	}
	synchronized public InvoiceMasterDTO createClone() {
		try {
			return (InvoiceMasterDTO)super.clone();
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

	public Date getInv_date() {
		return inv_date;
	}

	public void setInv_date(Date date) {
		this.inv_date = date;
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public float getInv_amt() {
		return inv_amt;
	}

	public void setInv_amt(float inv_amt) {
		this.inv_amt = inv_amt;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cust_id, discount, inv_amt, inv_date, inv_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceMasterDTO other = (InvoiceMasterDTO) obj;
		return cust_id == other.cust_id && discount == other.discount
				&& Float.floatToIntBits(inv_amt) == Float.floatToIntBits(other.inv_amt)
				&& Objects.equals(inv_date, other.inv_date) && inv_id == other.inv_id;
	}

	@Override
	public String toString() {
		return "InvoiceMasterDTO [inv_id=" + inv_id + ", inv_date=" + inv_date + ", cust_id=" + cust_id + ", inv_amt="
				+ inv_amt + ", discount=" + discount + "]";
	}
}
