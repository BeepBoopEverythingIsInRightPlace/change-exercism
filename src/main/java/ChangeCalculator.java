import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChangeCalculator {

    private final List<Integer> coins;
    private List<Integer> output = new ArrayList<>();

    public ChangeCalculator(List<Integer> asList) {
        coins = asList;
    }

    public List<Integer> computeMostEfficientChange(int change) {
        if (change == 0) return Collections.emptyList();
        if (change < 0) throw new IllegalArgumentException("Negative totals are not allowed.");
        for (int i = coins.size() - 1; i >= 0; i--) {
            if (change >= coins.get(i)) {
                List<Integer> output = new ArrayList<>();
                output.add(coins.get(i));
                int currentChange = change - coins.get(i);
                computeMostEfficientChange(currentChange, output);
            }
        }
        if (this.output.isEmpty()) {
            throw new IllegalArgumentException("The total " + change + " cannot be represented in the given currency.");
        }
        Collections.sort(this.output);
        return this.output;
    }

    public void computeMostEfficientChange(int change, List<Integer> output) {
        if (change == 0) {
            this.output = output;
        }
        if(output.size() < this.output.size() || this.output.isEmpty())
        {
            for (int i = coins.size() - 1; i >= 0; i--) {
                List<Integer> currentOutput = new ArrayList<>(output);
                Collections.copy(currentOutput, output);
                if (change >= coins.get(i) && coins.get(i) <= output.get(output.size()-1)) {
                    currentOutput.add(coins.get(i));
                    int currentChange = change - coins.get(i);
                    computeMostEfficientChange(currentChange, currentOutput);
                }
            }
        }

    }
}
