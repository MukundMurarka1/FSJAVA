package in.ineuron.game;

import java.util.*;

public class Gusser {
	
	int gussenum;
	int number;
	
	int gusseANum() {
		Scanner scan = new Scanner(System.in);
		System.out.print("gusser please Guess a number between 1 to 50  and starts the game :: ");
		gussenum = scan.nextInt();
		if(gussenum >50 || gussenum < 1)
		{
			System.out.println("Hii gusser please gusse the number in the given number ");
		}
		else {
			System.out.println("Now its player turn :: ");
			number= gussenum;
	
		}
		return number;
		
			
		
		
	}

}
