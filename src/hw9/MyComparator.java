package hw9;

import java.util.Comparator;
import java.util.Map;

public class MyComparator implements Comparator<String>{
    private final Map<String, Integer> map;

    public MyComparator(Map<String, Integer> map) {
        this.map = map;
    }

    @Override
    public int compare(String o1, String o2) {
        return map.get(o2) - map.get(o1);
    }
}
