package exday1203;

public class KCard extends Card {
	
	public KCard(String name, int cardAmt) {
		super(name, cardAmt);
		super.pointAmt = (int) (cardAmt * 0.01);
	}

	@Override
	public void pointInfo() {
			System.out.println(super.name + "구매금액 : " + super.cardAmt + "원" + " 적립액 : " + super.pointAmt + "원");
	}

}
