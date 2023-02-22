package ai.ineuron.cards;

public class PaymentaProcess 
{
	private ICards payment=null;
	
	
	//constructor Injection
	public PaymentaProcess(ICards payment)
	{
		this.payment=payment;
	}
	
	//setter injection
	public void setPayment(ICards payment)
	{
		this.payment=payment;
	}
	
	public boolean doThePayment(String cardType, Double billAmount)
	{
//		if("CreditCard".equals(cardType))
//		{
//			CreditCard cc=new CreditCard();
//			return cc.payingBill(billAmount);
//			
//		}
//		else if("DebitCard".equals(cardType))
//		{
//			DebitCard cc=new DebitCard();
//			return cc.payingBill(billAmount);
//			
//		}
//		else if("AmexCard".equals(cardType))
//		{
//			AmexCard cc=new AmexCard();
//			return cc.payingBill(billAmount);
//		}
//		else
//		{
//		
//		  return false;
//		}
		return payment.payingBill(billAmount);
	}

}
