package board.aop;

import lombok.Data;

@Data
public class Cats {

	private String name;
	private int age;
	private String color;
	
	public void getCatsInfo() {
		System.out.println("이름:" + getName());
		System.out.println("나이:" + getAge());
		System.out.println("색상:" + getColor());
	}
	
	
}



