package Tutor1;
import java.util.Set;
import java.util.TreeSet;

public class EvenIntSet {
    private Set<Integer> set;

    public EvenIntSet() {
        set = new TreeSet<>();
    }

    public void add(int i) {
        if (i % 2 == 0) {
            set.add(i);
        }
        else {
            throw new IllegalArgumentException("Number must be even");
        }
    }

    public Set<Integer> getSet() {
        return set;
    }

}
