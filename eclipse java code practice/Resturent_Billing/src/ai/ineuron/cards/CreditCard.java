package ai.ineuron.cards;

public class CreditCard implements ICards
{
	public boolean payingBill(Double bill)
	{
		System.out.println("Paying the bill using credit card " + bill);
		//logic here to dedicate money to show balance
		return true;
	}

}
