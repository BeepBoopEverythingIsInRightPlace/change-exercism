import java.util.*;

public class ChangeCalculator {

    private final List<Integer> coins;

    public ChangeCalculator(List<Integer> coins) {
        this.coins = coins;
    }


    public List<Integer> computeMostEfficientChange(int changeValue) {
        List<Integer> T = getInfoHowManyCoins(changeValue);

        return pickCoins(changeValue, T);
    }

    private List<Integer> getInfoHowManyCoins(int changeValue) {
        List<Integer> T = prepareSpecialList(changeValue);

        for (int coinValue : coins) {
            for (int j = 0; j <= changeValue - coinValue; j++) {
                if (T.get(j) < Integer.MAX_VALUE)
                    if (T.get(j) + 1 < T.get(j + coinValue)) {
                        T.set(j + coinValue, T.get(j) + 1); //dodajemy jeden, bo używamy monety
                    }
            }

        }
        return T;
    }

    private List<Integer> prepareSpecialList(int changeValue) {
        List<Integer> T = new ArrayList<>(changeValue);
        T.add(0);   //"recursive" stop
        // wartości początkowe
        // lista T musi mieć tyle pól ile wynosi "reszta"
        for (int i = 1; i <= changeValue; i++) {
            T.add(Integer.MAX_VALUE);
        }
        return T;
    }

    private List<Integer> pickCoins(int changeValue, List<Integer> T) {
        int numOfChangeCoins = T.get(T.size() - 1);
        int guessedChangeValue = 0;
        List<Integer> coinGuesses = null;
        Random random = new Random();

        while (guessedChangeValue != changeValue) {
            guessedChangeValue = 0;
            coinGuesses = new ArrayList<>();

            for (int i = 0; i < numOfChangeCoins; i++) {
                int rndCoin = coins.get(random.nextInt(coins.size()));
                coinGuesses.add(rndCoin);
                guessedChangeValue += rndCoin;
            }

        }
        sortIt(coinGuesses);
        return coinGuesses;
    }

    private void sortIt(List<Integer> coinGuesses) {
        if (coinGuesses != null) {
            Collections.sort(coinGuesses);
        }
    }
}