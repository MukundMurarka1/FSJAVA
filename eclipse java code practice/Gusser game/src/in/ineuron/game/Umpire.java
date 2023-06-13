package in.ineuron.game;

public class Umpire {
	
	int gussernum;
	int player1num;
	int player2num;
	int player3num;
	
	void collectNumfromGusser() {
		Gusser gusser = new Gusser();
		gussernum = gusser.gusseANum();
		
	}
	
	void collectNumFromPlayers() {
		Player player1 = new Player();
		Player player2 = new Player();
		Player player3 = new Player();
		
		player1num = player1.gusseANum();
		player2num = player2.gusseANum();
		player3num = player3.gusseANum();
		
		
	}
	
	void compare() {
		if(player1num == gussernum) {
			if(player2num == gussernum && player3num == gussernum) {
				System.out.println("game tie up between all the palyer ");
			}else if(player2num == gussernum) {
				System.out.println("game tipe up between player 1 and player 2 ");
			}else if(player3num == gussernum) {
				System.out.println("game tie up between palyer 1 and player 3 ");
			}else {
				System.out.println("Player  won the match ");
			}
		}else if(player2num == gussernum) {
			if(player3num == gussernum ) {
				System.out.println("game tie up between player 2 and player 3");
			}else {
				System.out.println("player 2 won the match ");
			}
		}else if(player3num == gussernum) {
			System.out.println("Player 3 won the match ");
		}
		else {
			System.out.println("Opps ! All the player loss the game ");
		}
	}

	

}
