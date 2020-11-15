package LeetCode;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.*;

public class DestinationCity {
    public static String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        for (List<String> path : paths) {
            if (!map.containsKey(path.get(0))) {
                map.put(path.get(0), path.get(1));
            }
        }
        String res = paths.get(0).get(0);
        while (map.containsKey(res)) {
            res = map.get(res);
        }
        return res;
//        List<String> sources= new ArrayList<>();
//        List<String> dests= new ArrayList<>();
//        for(List<String> path: paths){
//                sources.add(path.get(0));
//                dests.add(path.get(1));
//        }

    }

    public static void main(String[] args) {
        List<List<String>> x = Arrays.asList(Arrays.asList("London", "New York"), Arrays.asList("New York", "Lima"), Arrays.asList("Lima", "Sao Paulo"));
        destCity(x);
    }
}

