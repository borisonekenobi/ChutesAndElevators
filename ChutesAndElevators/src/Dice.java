import java.util.Random;

public class Dice {
	private static final long SEED = System.currentTimeMillis();
	private static final Random GENERATOR = new Random(SEED);
	private int maxValue;
	private int minValue;

	public Dice() {
		this(6);
	}

	public Dice(int max) {
		this(max, 1);
	}

	public Dice(int max, int min) {
		maxValue = max;
		minValue = min;
	}

	public int roll() {
		return (int) (GENERATOR.nextDouble() * maxValue + minValue);
	}
}
