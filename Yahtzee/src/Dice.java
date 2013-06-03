public class Dice {
	private final static int NUMOFDICE = 5;
	private final static int SIDESOFDIE = 6;
	private static int[] DieValues = new int[NUMOFDICE];
	static private Die[] Dice = new Die[NUMOFDICE];

	public Dice() {
		for (int x = 0; x < Dice.length; x++) {
			Dice[x] = new Die(SIDESOFDIE);
		}
	}

	public int[] rollDice() {
		
		for (int roll = 0; roll < Dice.length; roll++) {
			DieValues[roll] = Dice[roll].roll();
		}
		
		return DieValues;
	}

}