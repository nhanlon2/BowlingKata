package uk.gov.ros.bowling;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {
    
    private Game aGame;

    @Before
    public void setUp() {
        aGame = new Game();
    }
    
    @Test
    public void shouldScoreZeroForGutterGame() {
        rollMany(20, 0);
        assertEquals(0,aGame.score());
    }
    
    @Test
    public void shouldScoreTwentyForAllOnesGame() {
        rollMany(20, 1);
        assertEquals(20,aGame.score());
    }
    //a spare is whenever all then pins are knocked over in one frame
    @Test //the bonus for a spare is the value rolled in the next frame
    public void shouldScoreValueOfFramePlusBonusForASpare() {
        aGame.roll(5);
        aGame.roll(5);
        aGame.roll(3);
        rollMany(17, 0);
        assertEquals(16,aGame.score());
    }
    

    private void rollMany(int numRolls, int scoreInEach) {
        for (int i = 0; i< numRolls; i++) {
            aGame.roll(scoreInEach);
        }
    }
}
