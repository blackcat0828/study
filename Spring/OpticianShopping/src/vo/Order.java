package vo;

import java.util.Date;

public class Order {
	private int id;
	private Date orderDate;
	private String customer;
	private String addr;
	private String status;
	
	public Order(int id, Date orderDate, String customer, String addr, String status) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.customer = customer;
		this.addr = addr;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
