import java.util.Scanner;

public class UserInterface {
	private static Dice die1 = new Dice();
	private static Dice die2 = new Dice(8);
	private static Player[] players;

	private static boolean correctInput(String s) {
		if (s == null || s.equals("")) {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isDigit(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	private static void introduction() {
		System.out.println("Welcome to this game of Chutes & Elevators!\n");
		System.out.println(
				"This is a multi player game, played by rolling two dice, one six sided and one eight sided, and advancing through the maze.\n"
						+ "When a player LANDS on a numbered tile that contains a chute, the player slides down the chute to the numbered tile that contains the end of the chute.\n"
						+ "When a player LANDS on a numbered tile that contains the bottom of an elevator, the player goes up the elevator to the numbered tile that contains the top of the elevator.\n"
						+ "The first player to reach the tile location 100 wins.\n");
		System.out.println("Every roll of the dice will increase your points.\n"
				+ "Going up an elevator will give you an extra 30 points.\n"
				+ "Going down a chute will take away 15 points.\n");

		Scanner input = new Scanner(System.in);

		int numPlayers = 0;
		do {
			System.out.print("Number of players: ");
			String s = input.nextLine();
			if (correctInput(s)) {
				numPlayers = Integer.parseInt(s);
			}
		} while (numPlayers <= 1);

		System.out.println();

		players = new Player[numPlayers];
		for (int i = 0; i < numPlayers; i++) {
			System.out.print("Enter player " + (i + 1) + " name: ");
			players[i] = new Player(input.nextLine());
		}

		System.out.println();
		input.close();
	}

	private static void game() {
		for (int i = 0; i < players.length; i++) {
			Player player = players[i];
			String name = player.getName();

			int roll = die1.roll() + die2.roll();
			player.setScore(player.getScore() + roll);
			System.out.println(name + " you have rolled a " + roll);
			player.setPos(player.getPos() + roll);
			player.setPos(Progression.whereWeGo(player, player.getPos()));
			System.out.println(name + " your new score is " + player.getScore());
			System.out.println(name + " your final location for this turn is at position " + player.getPos());

			if (player.getPos() >= 100) {
				System.out.println();
				return;
			}
			if (i == players.length - 1) {
				i = -1;
			}
			System.out.println();
		}
	}

	private static void conclusion() {
		Player winner = players[0];
		int max = players[0].getScore();
		for (Player player : players) {
			if (player.getScore() > max) {
				max = player.getScore();
				winner = player;
			}
		}
		System.out.println(winner.getName() + " you have won with a final score of " + max);
		
		
	}

	public static void main(String[] args) {
		introduction();
		game();
		conclusion();
	}
}
