import java.util.Random;

public class Die {
	int faceValue;
	int sideCount;
	static Random gen = new Random();

	public Die(int sideCount) {
		this.sideCount = sideCount;
	}

	public int roll() {
		return faceValue = (gen.nextInt(sideCount) + 1);
	}

}