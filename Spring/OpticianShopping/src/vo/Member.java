package vo;

public class Member {
	private String id;
	private String password;
	private String name;
	private String contact;
	private String addr;
	
	
	
	public Member(String id, String password, String name, String contact, String addr) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.contact = contact;
		this.addr = addr;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	

}
