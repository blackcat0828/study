package day1221.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductStorage {
	
	private List<Product> list = 
		   new ArrayList<>();	
	
	//Scanner 클래스
	//System.in : 콘솔창에서 입력처리
	private Scanner scanner = new Scanner(System.in);
	private int counter;

	//메서드
	public void showMenu() {
		
		while(true) {
			System.out.println("-----------------");
			System.out.println("1.등록 2.목록 3.종료");
			System.out.println("-----------------");
			
			System.out.println("선택:");
			
			//정수형값을 입력-> nextInt()
			//문자열을 입력 -> next()
			//Enter키를 클릭하기전까지 라인단위 입력값
			
			//next()와 nextLine() 차이점
			//next()는 문자 또는 문자열을 공백을 기준으로
			//한단어 또는 한문자씩 입력처리
			//nextLine()는 문자 또는 문장 한라인 전체를 입력처리
			String selectNo = scanner.nextLine();
			
			switch(selectNo) {
				case "1": //제품등록
					      registerProduct();
						  break;
				case "2": //전체제품 조회
					   	  showProducts();
				          break;
				case "3": return;
			}
			
		}
	}

	//제품 등록 처리
	public void registerProduct() {
		
		try {
			
			//Product 인스턴스를 생성
			Product product = new Product();
			
			//멤버변수 pno 는 private으로 선언
			//setPno()메서드를 이용하여 값을 대입
			product.setPno(++counter);
			
			//멤버변수 name은 private으로 선언
			//setName()메서드를 이용하여 값을 대입
			System.out.println("상품명:");
			product.setName(scanner.nextLine());
			
			//가격,재고는 nextLine()으로 입력받으면
			//문자열로 입력받기 때문에
			//Integer.parseInt() 메서드를 이용하여
			//문자열을 숫자로 변환처리
			System.out.println("가격:");
			product.setPrice(Integer.parseInt(
					scanner.nextLine()));
			
			System.out.println("재고:");
			product.setStock(Integer.parseInt(
					scanner.nextLine()));
			
			//product 형태의 데이터를 List구조로
			//추가
			list.add(product);
		
			//Exception : 예외처리 최상위 클래스
		}catch(Exception e) {
			System.out.println("[ProductStorage]상품등록 에러:" + 
		            e.getMessage());
		}
	}
	
	public void showProducts() {
		
		//향상된 for문
		//배열구조에서만 사용가능
		//list라는 배열구조에서 자료를 하나씩 가져와서
		//자료형태가 Product인 참조변수 p에 대입한다.
		//참조변수를 이용하여 Product내부에 있는
		//각 멤버변수의 값을 가져올수 있다.
		for(Product p : list) {
			System.out.println(
					   p.getPno() + "\t" +
					   p.getName() + "\t" + 
					   p.getPrice() + "\t" +
					   p.getStock());	
		}
		
		
	}
}










