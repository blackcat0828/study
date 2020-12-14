package exday1203;

public abstract class Card {
		public String name;
		int cardAmt;
		int pointAmt;
		
		public Card (String name, int cardAmt) {
			this.name = name;
			this.cardAmt = cardAmt;
		}
		
		public abstract void pointInfo();
}
