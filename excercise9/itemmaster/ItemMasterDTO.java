package itemmaster;

import java.io.Serializable;
import java.util.Objects;

public class ItemMasterDto implements Serializable,Cloneable,Comparable<ItemMasterDto>{
//	declaring all the dto variables 
	private int itemId;
	private String itemName;
	private float itemPrice;
	private int unit;
	
//	constructor to indicate the object creation
	private ItemMasterDto(){
		System.out.println("Item master object created!");
	}
	
//	overriding the compareTo() method to compare between the objects
	@Override
	public int compareTo(ItemMasterDto o) {
		return	this.itemId-o.itemId;
	}
	
//	declaring the singleton variable
	private static ItemMasterDto dto;
	
//	providing the prototype method if it requires to create multiple objects other than singleton 
	synchronized public static ItemMasterDto getInstance() {
		if(dto==null) {
			dto=new ItemMasterDto();
			return dto;
		}
		else {
			return dto.createClone();
		}
	}
	
//	clone method to create clone object
	synchronized public ItemMasterDto createClone() {
		try {
			return (ItemMasterDto)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	<---------- START : GETTERS AND SETTERS ---------->
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}
//	<---------- END : GETTERS AND SETTERS ---------->
	
//	providing hashcode and equals object to check the equality of the object
	@Override
	public int hashCode() {
		return Objects.hash(itemId, itemName, itemPrice, unit);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemMasterDto other = (ItemMasterDto) obj;
		return itemId == other.itemId && Objects.equals(itemName, other.itemName)
				&& Float.floatToIntBits(itemPrice) == Float.floatToIntBits(other.itemPrice) && unit == other.unit;
	}

//	providing toString() method to print the object data
	@Override
	public String toString() {
		return "ItemMasterDTO [itemId=" + itemId + ", itemName=" + itemName + ", itemPrice=" + itemPrice
				+ ", unit=" + unit + "]";
	}

}
