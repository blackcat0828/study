package fintech;

public class Calculator {
	private String num1;
	private String num2;
	
	public Calculator() {}	
	
	public String getNum1() {
		return num1;
	}

	public void setNum1(String num1) {
		this.num1 = num1;
	}

	public String getNum2() {
		return num2;
	}

	public void setNum2(String num2) {
		this.num2 = num2;
	}
	
	public int add() {
		
		return Integer.parseInt(num1)+Integer.parseInt(num2);
	}
	
	public int minus() {
		return Integer.parseInt(num1)-Integer.parseInt(num2);
	}
	
	public int mul() {
		return Integer.parseInt(num1)*Integer.parseInt(num2);
	}
	
	public int div() {
		return Integer.parseInt(num1)/Integer.parseInt(num2);
	}
	
	
	
}
