package itemmaster;

import java.io.Serializable;
import java.util.Objects;

public class ItemMasterDTO implements Serializable,Cloneable,Comparable<ItemMasterDTO>{
	private int item_id;
	private String item_name;
	private float item_price;
	private int unit;
	
	private ItemMasterDTO(){
		System.out.println("Item master object created!");
	}
	
	@Override
	public int compareTo(ItemMasterDTO o) {
		return	this.item_id-o.item_id;
	}
	
	private static ItemMasterDTO dto;
	synchronized public static ItemMasterDTO getInstance() {
		if(dto==null) {
			dto=new ItemMasterDTO();
			return dto;
		}
		else {
			return dto.createClone();
		}
	}
	synchronized public ItemMasterDTO createClone() {
		try {
			return (ItemMasterDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public float getItem_price() {
		return item_price;
	}

	public void setItem_price(float item_price) {
		this.item_price = item_price;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(item_id, item_name, item_price, unit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemMasterDTO other = (ItemMasterDTO) obj;
		return item_id == other.item_id && Objects.equals(item_name, other.item_name)
				&& Float.floatToIntBits(item_price) == Float.floatToIntBits(other.item_price) && unit == other.unit;
	}

	@Override
	public String toString() {
		return "ItemMasterDTO [item_id=" + item_id + ", item_name=" + item_name + ", item_price=" + item_price
				+ ", unit=" + unit + "]";
	}

}
