import java.util.ArrayList;
import java.util.List;

public class ChangeCalculator {

    private final List<Integer> coins;

    public ChangeCalculator(List<Integer> coins) {
        this.coins = coins;
    }

    //please refactor me (i am working for fist test only)
    public List<Integer> computeMostEfficientChange(int changeValue) {
        List<Integer> change = new ArrayList<>();
        boolean found = false;      //please kill me
        for (int i = 0; i < coins.size(); i++) {
            for (int j = 0; j < coins.size(); j++) {
                if (changeValue == coins.get(i) + coins.get(j) && !found) {     //suicide.commit()
                    change.add(coins.get(i));
                    change.add(coins.get(j));
                    found = true;
                }
            }
        }
        return change;
    }
}