package exday1203;

public class KCard extends Card {
	
	public KCard(String name, int cardAmt) {
		super(name, cardAmt);
		super.pointAmt = (int) (cardAmt * 0.01);
	}

	@Override
	public void pointInfo() {
			System.out.println(super.name + "���űݾ� : " + super.cardAmt + "��" + " ������ : " + super.pointAmt + "��");
	}

}
