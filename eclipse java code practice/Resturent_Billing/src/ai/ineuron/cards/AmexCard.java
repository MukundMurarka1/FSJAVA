package ai.ineuron.cards;

public class AmexCard implements ICards
{
	public boolean payingBill(Double bill)
	{
		System.out.println("Paying the bill using amex card " + bill);
		//logic here to dedicate money to show balance
		return true;
	}


}
