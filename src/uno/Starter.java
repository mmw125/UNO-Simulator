package uno;

import java.util.Scanner;

public class Starter {

	public static void main(String[] args) {
		new Starter();

	}

	public Starter() {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("How many games?");
		int rounds = keyboard.nextInt();

		int startingPlayers = 2;
		int totalRounds = 0;
		double averageRound[][] = new double[20][20];
		int highNumPlay = 10;
		int highNumCards = 10;

		for (int players = startingPlayers; players < highNumPlay; players++) {
			for (int cards = 2; cards < highNumCards; cards++) {
				totalRounds = 0;
				for (int count = 0; count < rounds; count++) {
					Game game = new Game(players, cards);
					totalRounds = totalRounds + game.start();
				}
				averageRound[players][cards] = totalRounds / rounds;
			}
		}
		System.out.print("Cards\t");
		for (int round = 2; round < highNumPlay; round++) {
			System.out.print(round + "\t");
		}
		System.out.print("\nPlayers\n");
		for (int players = startingPlayers; players < highNumPlay; players++) {
			System.out.print(players + "\t");
			for (int cards = 2; cards < highNumCards; cards++) {
				System.out.print((int) averageRound[players][cards] + "\t");
			}
			System.out.println();
		}
		DataDisplay display = new DataDisplay(averageRound, highNumCards, highNumPlay);
		display.setVisible(true);
		keyboard.close();
	}
}