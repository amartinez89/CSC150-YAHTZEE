public class Player {
	String name;
	int turnsRemaining, rollCount;
	String[] scoreName;
	Score scoreObj[];    
	/* [0] aces		[6] 3 of a kind		[12] chance
	 * [1] twos		[7] 4 of a kind		[13] subtotal left
	 * [2] threes	[8] full house		[14] bonus
	 * [3] fours	[9] small straight	[15] subtotal right
	 * [4] fives	[10] large straight	[16] total score
	 * [5] sixes	[11] yahtzee
	 */

	/* initialize the totals to 0 */
    int subtotalLeft=0, subtotalRight=0, grandTotal=0, bonusPoint=0;
    boolean usedCategory[];  //Tracks if a category has been used

	public Player(String n, String[] scoreN){
		name = n; // store the player's name
		scoreName = scoreN; // get the standard score names from the main class

	    /* A game consists of 13 rolls */
		turnsRemaining = 13;
		/* Each player gets 3 rolls per turn */
		rollCount = 3;

		scoreObj = new Score[scoreName.length];
		for (int i=0; i<scoreObj.length; i++){
			scoreObj[i] = new Score(scoreName[i]);
		}

		// initialize totals to 0
		scoreObj[13].value = 0;
		scoreObj[14].value = 0;
		scoreObj[15].value = 0;
		scoreObj[16].value = 0;

	}

	public int calcSubtot(int score, int arrPos){
		scoreObj[arrPos].value += score;
		return scoreObj[arrPos].value;
	}

	public int grandTot(){
		for(int i=13; i<15; i++){
			scoreObj[16].value += scoreObj[i].value;
		}
		return scoreObj[16].value;
	}
}