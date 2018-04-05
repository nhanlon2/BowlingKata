package uk.gov.ros.bowling;

public class GameVersionOne {

    private int total = 0;
    private int startOfFrameTotal = 0;
    private int rolls = 0;
    private boolean isSpare;
    private boolean isStrike;
    private boolean lastFrameWasStrike;
    private boolean isConsecutiveStrike;

    public void roll(int pinsKnockedOver) {

        if (rolls >= 20) {
            isConsecutiveStrike = isStrike = false;
        }
        if (rolls % 2 == 0) {
            checkForSpare();
            updateStartOfFrameTotal();
            if (!lastFrameWasStrike) {
                isStrike = false;
                isConsecutiveStrike = false;
            }
            lastFrameWasStrike = false;
        }
        rolls++;
        total += pinsKnockedOver * (isConsecutiveStrike ? 3 : (isSpare || isStrike) ? 2 : 1);
        if (pinsKnockedOver == 10 && isStrike) {
            isConsecutiveStrike = true;
        }
        isSpare = false;
        if (pinsKnockedOver == 10) {
            isStrike = true;
            lastFrameWasStrike = true;
            rolls++;
        }
    }

    private void checkForSpare() {
        if (total - startOfFrameTotal == 10) {
            isSpare = true;
        } else {
            isSpare = false;
        }
    }

    private void updateStartOfFrameTotal() {
        startOfFrameTotal = total;
    }

    public int score() {
        return total;
    }

}
