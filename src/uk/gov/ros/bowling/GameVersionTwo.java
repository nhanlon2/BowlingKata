package uk.gov.ros.bowling;

public class GameVersionTwo {

	private int[] rolls = new int[21];
	private int roll;
	int total = 0;

	public void roll(int pins) {
		rolls[roll++] = pins;
	}

	public int score() {
		int frameIndex = 0;
		for (int frame = 1; frame <= 10; frame++) {
			if (isStrike(frameIndex)) {
				total += 10 + strikeBonus(frameIndex);
				frameIndex++;
			} else {
				int frameScore = calcFrameScore(frameIndex);
				if (frameScore == 10) {
					total += spareBonus(frameIndex);
				}
				total += frameScore;
				frameIndex += 2;
			}

		}
		return total;
	}

	private int calcFrameScore(int frameIndex) {
		return rolls[frameIndex] + rolls[frameIndex + 1];
	}

	private int spareBonus(int frameIndex) {
		return rolls[frameIndex + 2];
	}

	private int strikeBonus(int frameIndex) {
		return rolls[frameIndex + 1] + rolls[frameIndex + 2];
	}

	private boolean isStrike(int frameIndex) {
		return rolls[frameIndex] == 10;
	}

}
