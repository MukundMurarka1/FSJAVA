package ai.ineuron.main;

import ai.ineuron.cards.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//constructor injection
		PaymentaProcess pp=new PaymentaProcess(new DebitCard());
		
		//setterinjection
		pp.setPayment(new AmexCard());
		boolean status=pp.doThePayment("CreditCard", 100.0);
		if(status)
			System.out.println("Payment sucess come again!");
		else
			System.out.println("Payment failed do you have money? or dishes washing");

	}

}
