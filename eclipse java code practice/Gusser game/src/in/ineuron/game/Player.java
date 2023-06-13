package in.ineuron.game;

import java.util.*;

public class Player {
int gussenum ;
	
	int gusseANum() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Player please Guess a number :: ");
		gussenum = scan.nextInt();
		return gussenum;
	}

}
