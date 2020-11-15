package HackerRank;

import java.lang.reflect.Array;
import java.util.*;

public class FrequencyQueries {
    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        int length = queries.size();
        Map<Integer, Integer> numbersMap = new HashMap<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();
        for (List<Integer> query : queries) {
            int op = query.get(0);
            int num = query.get(1);
            if (op == 1) {//add to array
                if (!numbersMap.containsKey(num)) {
                    numbersMap.put(num, 1);
                    freqMap.put(1,0);
                } else {
                    numbersMap.put(num, numbersMap.get(num) + 1);
                }
            } else if (op == 2) {//remove from array
                if (numbersMap.containsKey(num)) {
                    numbersMap.put(query.get(1), numbersMap.get(num) - 1);
                    if(numbersMap.get(num)==0){
                        numbersMap.remove(num);
                    }
                }
            } else if (op == 3) {//check frequency
                if(numbersMap.containsValue(num)){
                    resultList.add(1);
                }
                else resultList.add(0);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        List<List<Integer>> t = Arrays.asList(Arrays.asList(1, 3),
                Arrays.asList(1, 38),
                Arrays.asList(2, 1),
                Arrays.asList(1, 16),
                Arrays.asList(2, 1),
                Arrays.asList(2, 2),
                Arrays.asList(1, 64),
                Arrays.asList(1, 84),
                Arrays.asList(3, 1),
                Arrays.asList(1, 100),
                Arrays.asList(1, 10),
                Arrays.asList(2, 2),
                Arrays.asList(2, 1),
                Arrays.asList(1, 67),
                Arrays.asList(2, 2),
                Arrays.asList(3, 1),
                Arrays.asList(1, 99),
                Arrays.asList(1, 32),
                Arrays.asList(1, 58),
                Arrays.asList(3, 2));
        System.out.println(freqQuery(t));
    }

}
