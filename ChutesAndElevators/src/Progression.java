public class Progression {
	private static final Integer[][] CHUTES = { { 25, 5 }, { 34, 1 }, { 47, 19 }, { 65, 52 }, { 87, 57 }, { 91, 61 },
			{ 99, 69 } };
	private static final Integer[][] ELEVATORS = { { 3, 51 }, { 6, 27 }, { 20, 70 }, { 36, 55 }, { 63, 95 },
			{ 68, 98 } };

	public static int whereWeGo(Player player, int pos) {
		for (int c = 0; c < CHUTES.length; c++) {
			if (CHUTES[c][0] == pos) {
				System.out.println("Chute at " + CHUTES[c][0] + ", move to square " + CHUTES[c][1]);
				player.setScore(player.getScore() - 15);
				return CHUTES[c][1];
			}
		}

		for (int e = 0; e < ELEVATORS.length; e++) {
			if (ELEVATORS[e][0] == pos) {
				System.out.println("Elevator at " + ELEVATORS[e][0] + ", move to square " + ELEVATORS[e][1]);
				player.setScore(player.getScore() + 30);
				return ELEVATORS[e][1];
			}
		}

		return pos;
	}
}
