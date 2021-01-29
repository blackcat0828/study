package jstl;

public class Student {
	private String studNo;
	private String name;
	private String email;
	
	public Student(String studNo, String name, String email) {

		this.studNo = studNo;
		this.name = name;
		this.email = email;
	}

	public String getStudNo() {
		return studNo;
	}



	public String getName() {
		return name;
	}



	public String getEmail() {
		return email;
	}
}
