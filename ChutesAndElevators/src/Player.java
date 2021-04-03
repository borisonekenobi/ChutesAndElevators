public class Player {
	private String name;
	private int pos;
	private int score;

	public Player(String name) {
		this.name = name;
		pos = 1;
		score = 0;
	}

	public void move(int pos) {
		this.pos = pos;
	}

	public String getName() {
		return name;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public int getPos() {
		return pos;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}
}
