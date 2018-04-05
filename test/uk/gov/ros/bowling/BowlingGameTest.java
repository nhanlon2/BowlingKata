package uk.gov.ros.bowling;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {
    
    private GameVersionOne aGame;

    @Before
    public void setUp() {
        aGame = new GameVersionOne();
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
    //a spare is whenever all the pins are knocked over in one frame
    @Test //the bonus for a spare is the value rolled in the next roll
    public void shouldScoreValueOfFramePlusBonusForASpare() {
        aGame.roll(5);
        aGame.roll(5);
        aGame.roll(3);
        aGame.roll(3);
        rollMany(16, 0);
        assertEquals(19,aGame.score());
    }
    
    //a strike is whenever all the pins are knocked over in one roll. The frame enda
    @Test //the bonus for a strike is the value rolled in the next two rolls
    public void shouldScoreValueOfFramePlusBonusForAStrike() {
        aGame.roll(10);
        aGame.roll(3);
        aGame.roll(3);
        rollMany(16, 0);
        assertEquals(22,aGame.score());
    }
    
    @Test 
    public void shouldScoreValueOfFramePlusBonusForTwoConsecutiveStrikes() {
        aGame.roll(10);
        aGame.roll(10);
        aGame.roll(3);
        rollMany(15, 0);
        assertEquals(39,aGame.score());
    }
    
    @Test 
    public void shouldScoreValueOfFramePlusBonusForThreeConsecutiveStrikes() {
        aGame.roll(10);
        aGame.roll(10);
        aGame.roll(10);
        aGame.roll(3);
        rollMany(13, 0);
        assertEquals(69,aGame.score());
    }
    
    @Test //A strike in the final frame allows two bonus rolls so we can have 12 rolls in total. These rolls only count towards the bonus of that
    //strike, they are not scored by themselves and they do not generate more bonus rolls. Therefore a perfect score = 300
    public void shouldScoreValueOfFramePlusBonusFor12ConsecutiveStrikes() {
        rollMany(12, 10);
        assertEquals(300,aGame.score());
    }
    

    private void rollMany(int numRolls, int scoreInEach) {
        for (int i = 0; i< numRolls; i++) {
            aGame.roll(scoreInEach);
        }
    }
}
