package uk.gov.ros.bowling;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameV2Test {

	private GameVersionTwo aGame;

	@Before
	public void setUp() {
		aGame = new GameVersionTwo();
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
		assertEquals(24, aGame.score());
	}
	
	@Test
	public void shouldScore300ForPerfectGame(){
		rollMany(12, 10);
		assertEquals(300, aGame.score());
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
