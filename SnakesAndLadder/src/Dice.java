import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int numberOfDices;
    int min = 1;
    int max = 6;

    public Dice(int numberOfDices) {
        this.numberOfDices = numberOfDices;
    }

    public int rollDice() {
        int diceUsed = 0;
        int totalSum = 0;

        while (diceUsed < numberOfDices) {
            int value = ThreadLocalRandom.current().nextInt(min, max + 1);

            totalSum += value;
            diceUsed++;
        }

        return totalSum;
    }
}
