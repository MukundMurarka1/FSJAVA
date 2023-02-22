package ai.ineuron.cards;

public class DebitCard implements ICards
{
	public boolean payingBill(Double bill)
	{
		System.out.println("Paying the bill using debit card " + bill);
		//logic here to dedicate money to show balance
		return true;
	}


}
