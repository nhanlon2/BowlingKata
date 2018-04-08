package uk.gov.ros.bowling;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameV3Test {

	private GameVersionThree aGame;

	@Before
	public void setUp() {
		aGame = new GameVersionThree();
	}

	@Test
	public void shouldScoreZeroForGutterGame() {
		rollMany(20, 0);
		assertEquals(0, aGame.score());
	}

	@Test
	public void shouldScoreTwentyForAllOnes() {
		rollMany(20, 1);
		assertEquals(20, aGame.score());
	}

	@Test
	public void shouldScoreOneBonusRollForSpare() {
		rollSpare();
		rollMany(1, 3);
		rollMany(1, 0);
		assertEquals(16, aGame.score());
	}
	
	@Test
	public void shouldScoreBonusTwoBallsForStrike(){
		aGame.roll(10);
		aGame.roll(4);
		aGame.roll(3);
		aGame.roll(3);
		assertEquals(27, aGame.score());
	}
	
	@Test
	public void shouldScoreSumOfBonusesForMultipleStrike(){
		aGame.roll(10);
		aGame.roll(10);
		aGame.roll(4);
		aGame.roll(3);
		assertEquals(55, aGame.score());
	}
	@Test
	public void shouldScoreSumOfBonusesForThreeStrike(){
		aGame.roll(10);//58
		aGame.roll(10); //31
		aGame.roll(10);//17
		aGame.roll(4);//7
		aGame.roll(3);
		assertEquals(113, aGame.score());
	}
	
	@Test
	public void shouldScore9720ForPerfectGame(){
		rollMany(12, 10);
		assertEquals(9720, aGame.score());//TODO
	}
	
	private void rollSpare(){
		aGame.roll(5);
		aGame.roll(5);
	}
	private void rollMany(int numRolls, int scoreInEach) {
		for (int i = 0; i < numRolls; i++) {
			aGame.roll(scoreInEach);
		}
	}

}
