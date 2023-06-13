package in.ineuron.game;

import java.util.*;

public class Gusser {
	
	int gussenum ;
	
	int gusseANum() {
		Scanner scan = new Scanner(System.in);
		System.out.print("gusser please Guess a number and starts the game :: ");
		gussenum = scan.nextInt();
		return gussenum;
	}

}
