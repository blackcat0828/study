package exday1203;

public class HCard extends Card {
	
	public HCard(String name, int cardAmt) {
		super(name, cardAmt);
		super.pointAmt = (int) (cardAmt * 0.02);
	}

	@Override
	public void pointInfo() {
			System.out.println(super.name + "���űݾ� : " + super.cardAmt + "��" + " ������ : " + super.pointAmt + "��");
	}
}
