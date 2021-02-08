package vo;

public class OrderedItem {
	private int id;
	private int itemId;
	private int qty;
	
	
	
	public OrderedItem(int id, int itemId, int qty) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.qty = qty;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	
}
