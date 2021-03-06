package  vahid.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HashUtil {

    public static Map<String, Double> sortByValue(Map<String, Double> unsortMap) {

        // 1. Convert Map to List of Map
        List<Entry<String, Double>> list =
                new LinkedList<Entry<String, Double>>(unsortMap.entrySet());

        // 2. Sort list with Collections.sort(), provide a custom Comparator
        //    Try switch the o1 o2 position for a different order
        Collections.sort(list, new Comparator<Entry<String, Double>>() {
            public int compare(Entry<String, Double> o1,
                               Entry<String, Double> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<String, Double> sortedMap = new LinkedHashMap<String, Double>();
        for (Entry<String, Double> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

		/*
        //classic iterator example
        for (Iterator<Map.Entry<String, Integer>> it = list.iterator(); it.hasNext(); ) {
            Map.Entry<String, Integer> entry = it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }*/


        return sortedMap;
    }

    public static String getRandomElementFromDist(Map<String, Double> probHash) {
        double p = Math.random();
        double cumulativeProbability = 0.0;

        for (Entry<String, Double> entry : probHash.entrySet()) {
            cumulativeProbability += entry.getValue();

            if (p <= cumulativeProbability) {
                return entry.getKey();
            }
        }
        return null;

    }

}
