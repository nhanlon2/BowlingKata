package uk.gov.ros.bowling;

/**
 * In this version, each strike gets the sum total of all consecutive strikes
 * bonuses. Therefore for three strikes in a row, the result would be 70.
 * Note - a frame with a STRIKE is ALWAYS one roll  - rolling 0 followed by 10 in one frame
 * is a SPARE, not a STRIKE.
 */
public class GameVersionThree {

	private int[] rolls = new int[21];
	private int roll;
	int frameIndex = 0;

	public void roll(int pins) {
		rolls[roll++] = pins;
	}

	public int score() {
		if (frameIndex > 19) {
			return 0;
		}
		int total = 0;
		int frameScore = 0;
		if (isStrike(frameIndex)) {
			total += getStrikeBonusScore();
		} else {
			frameScore = calcFrameScore(frameIndex);
			if (frameScore == 10) {
				frameScore += spareBonus(frameIndex);
			}
			frameIndex += 2;
		}
		total += frameScore + score();
		return total;
	}

	private int getStrikeBonusScore() {
		int total = 0;
		if (isStrike(frameIndex)) {
			frameIndex++;
			Integer thisFrameIndex = new Integer(frameIndex);
			total += 10 + getStrikeBonusScore();
			frameIndex = thisFrameIndex + 1;
			total += getStrikeBonusScore();
			frameIndex = thisFrameIndex;
			return total;
		} else {
			return rolls[frameIndex];
		}
	}

	private int calcFrameScore(int frameIndex) {
		return rolls[frameIndex] + rolls[frameIndex + 1];
	}

	private int spareBonus(int frameIndex) {
		return rolls[frameIndex + 2];
	}

	private boolean isStrike(int frameIndex) {
		return rolls[frameIndex] == 10;
	}

}
