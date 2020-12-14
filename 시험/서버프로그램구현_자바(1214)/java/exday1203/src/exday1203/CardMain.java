package exday1203;

public class CardMain {
		public static void main(String[] args) {
				Card kcard = new KCard("이순신", 10000);
				Card hcard = new HCard("홍길동", 20000);
				kcard.pointInfo();
				hcard.pointInfo();
		}
}
