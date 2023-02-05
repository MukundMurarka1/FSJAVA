import java.util.Scanner;

class LoanApplication{
	static int rateOfInterstforPL=12;
	static int rateOfInterstforEL=11;
	static int rateOfInterstforHL=6;
	static int rateOfInterstforcL=10;
	
}
class PersonalLoan extends LoanApplication{
	public void calculate_interest(int amt, int time ) {
		int interest  =(amt*time*super.rateOfInterstforPL)/100;
		System.out.println("The total amount you have to paid after completion of "+ time+ "is " +(amt+interest));
		
	}
	
}
class EducationLoan extends LoanApplication{
	public void calculate_interest(int amt, int time ) {
		int interest  =(amt*time*super.rateOfInterstforEL)/100;
		System.out.println("The total amount you have to paid after completion of "+ time+ "is " +(amt+interest));
		
	}
	
}
class CarLoan extends LoanApplication{
	public void calculate_interest(int amt, int time ) {
		int interest  =(amt*time*super.rateOfInterstforcL)/100;
		System.out.println("The total amount you have to paid after completion of "+ time+ "is " +(amt+interest));
		
	}
	
}
class HomeLoan extends LoanApplication{
	public void calculate_interest(int amt, int time ) {
		int interest  =(amt*time*super.rateOfInterstforHL)/100;
		System.out.println("you have to pay "+interest+ " for the amount you want to take ");
		System.out.println("The total amount you have to paid after completion of "+ time+ " year is " +(amt+interest));
		
	}
	
}

class Loan {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to our bank");
		System.out.println("Please choose the option what type of loan you want to take press 1,2,3,4,5 ");
	    String type = scan.next();
	    String s1 = "PersonalLoan";
	    String s2 = "EducationLoan";
	    String s3 = "CarLoan";
	    String s4 = "HomeLoan";
		
	    
	    if(type.equalsIgnoreCase(s1)) {
	    	PersonalLoan pl = new PersonalLoan();
	    	pl.calculate_interest(50000, 5);
	    	
	    }
	    else if (type.equalsIgnoreCase(s2)) {
	    	EducationLoan el = new EducationLoan();
	    	el.calculate_interest(100000, 4);
	    }
	    else if (type.equalsIgnoreCase(s3)) {
	    	CarLoan cl = new CarLoan();
	    	cl.calculate_interest(500000, 5);
	    }
	    else if (type.equalsIgnoreCase(s4)) {
	    	HomeLoan el = new HomeLoan();
	    	el.calculate_interest(600000, 6);
	    }
	    else {
	    	System.out.println("*********please choose a vaild option**********");
	    }
	}		

	

}
