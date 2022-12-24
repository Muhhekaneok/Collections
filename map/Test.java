package justforfun.collections.map;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

// sorting values in Map
public class Test {
    public static void main(String[] args) {
        Map<String, Integer> nonSortedMap = Map.of(
                "Two", 2,
                "Three", 3,
                "Five", 5,
                "One", 1,
                "Four", 4
        );

        Map<String, Integer> sortedMap = sortByValue(nonSortedMap);
        sortedMap.entrySet().forEach(x -> System.out.println(x));

        System.out.println();

        nonSortedMap.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .forEach(System.out::println);
    }

    public static Map<String, Integer> sortByValue(Map<String, Integer> map) {
        Map<String, Integer> temp = new TreeMap<>(new MyMapComparator(map));
        temp.putAll(map);
        return temp;
    }

    static class MyMapComparator implements Comparator<String> {
        private final Map<String, Integer> map;

        public MyMapComparator(Map<String, Integer> map) {
            this.map = map;
        }

        @Override
        public int compare(String o1, String o2) {
            return map.get(o1) - map.get(o2);
        }
    }
}