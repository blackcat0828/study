package vo;

public class Glasses {
	private int id;
	private String kind;
	private int price;
	private String image;
	private String brand;
	private String content;
	private int readcount;
	public Glasses(int id, String kind, int price, String image, String brand, String content, int readcount) {
		super();
		this.id = id;
		this.kind = kind;
		this.price = price;
		this.image = image;
		this.brand = brand;
		this.content = content;
		this.readcount = readcount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	
}
