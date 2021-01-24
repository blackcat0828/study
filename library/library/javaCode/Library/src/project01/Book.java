package project01;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Book {
	private SimpleIntegerProperty id;
	private SimpleStringProperty title;
	private SimpleStringProperty rent;
	private SimpleStringProperty contact;
	private SimpleStringProperty rentDate;
	private SimpleIntegerProperty overDate;
	
	
	
	public Book() {
		this.id = new SimpleIntegerProperty();
		this.title = new SimpleStringProperty();
		this.rent = new SimpleStringProperty();
		this.contact = new SimpleStringProperty();
		this.rentDate = new SimpleStringProperty();
		this.overDate = new SimpleIntegerProperty();
	}
	public Book(int id, String title, String rent, String contact, String rentDate, int overDate) {
		this.id = new SimpleIntegerProperty(id);
		this.title = new SimpleStringProperty(title);
		this.rent = new SimpleStringProperty(rent);
		this.contact = new SimpleStringProperty(contact);
		this.rentDate = new SimpleStringProperty(rentDate);
		this.overDate = new SimpleIntegerProperty(overDate);
	}
	public int getId() {
		return id.get();
	}
	public void setId(int id) {
		this.id.set(id);
	}
	
	public String getTitle() {
		return title.get();
	}
	public void setTitle(String title) {
		this.title.set(title);
	}
	
	public String getRent() {
		return rent.get();
	}
	public void setRent(String rent) {
		this.rent.set(rent);
	}
	
	public String getContact() {
		return contact.get();
	}
	public void setContact(String contact) {
		this.contact.set(contact);
	}
	
	public String getRentDate() {
		return rentDate.get();
	}
	public void setRentDate(String rentDate) {
		this.rentDate.set(rentDate);
	}
	
	public int getOverDate() {
		return overDate.get();
	}
	public void setOverDate(int overDate) {
		this.overDate.set(overDate);
	}
	
	


}
