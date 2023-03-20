package Tutor1;
import java.util.*;

public class StringIntMap {
    private Map<String, Integer> hashmap;

    public StringIntMap() {
        this.hashmap = new HashMap<>();
    }

    public Map<String, Integer> getHashmap() {
        return hashmap;
    }

    public void put(String key, Integer value) {
        hashmap.put(key, value);
    }

    public void remove(String key, Integer value) {
        hashmap.remove(key, value);
    }

    public Integer lookup(String key) {
        return hashmap.get(key);
    }
}
