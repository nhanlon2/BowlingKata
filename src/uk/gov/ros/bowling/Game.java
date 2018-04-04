package uk.gov.ros.bowling;

public class Game {

    private int total = 0;
    private int startOfFrameTotal = 0;
    private int rolls = 0;
    private boolean isSpare;

    public void roll(int pinsKnockedOver) {
        if (rolls % 2 == 0) {
            checkForSpare();
            updateStartOfFrameTotal();
        }
        rolls++;
        total += pinsKnockedOver * (isSpare?2:1);
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
