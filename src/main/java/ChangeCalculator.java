import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ChangeCalculator {

    private final List<Integer> coins;

    public ChangeCalculator(List<Integer> coins) {
        this.coins = coins;
    }


    public List<Integer> computeMostEfficientChange(int changeValue) {
        int numOfAvailableCoins = coins.size();
        List<Integer> T = new ArrayList<>();
        T.add(0);   //"recursive" stop
        // wartości początkowe
        // lista T musi mieć tyle pól ile wynosi "reszta"
        for (int i = 1; i <= changeValue; i++) {
            T.add(i, Integer.MAX_VALUE);
        }

        for (int i = 0; i < numOfAvailableCoins; i++) {
            int coinValue = coins.get(i);

            for (int j = 0; j <= changeValue - coinValue; j++) {
                if (T.get(j) < Integer.MAX_VALUE)
                    if (T.get(j) + 1 < T.get(j + coinValue)) {
                        T.set(j + coinValue, T.get(j) + 1); //dodajemy jeden, bo używamy monety
                    }
            }

        }

        int numOfChangeCoins = T.get(T.size());

        return T;
    }
}