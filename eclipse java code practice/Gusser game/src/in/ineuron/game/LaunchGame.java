package in.ineuron.game;

public class LaunchGame {

	public static void main(String[] args) {
		
		Umpire umpire = new Umpire();
		System.out.println("lets play a game named as guesser game ");
		umpire.collectNumfromGusser();
		umpire.collectNumFromPlayers();
		umpire.compare();

	}

}
