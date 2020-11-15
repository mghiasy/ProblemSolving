import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> arrival = Arrays.asList(new Integer[] {1, 1, 1, 1, 4});
        List<Integer> duration = Arrays.asList(new Integer[] {10, 3, 6, 4, 2});

        System.out.println(maxEvents(arrival, duration));

    }

    public static int maxEvents(List<Integer> arrival, List<Integer> duration) {
        // Write your code here
        //sort according to duration
        int count = 1;
        int size =arrival.size();
        //int end = arrival.get(0) + duration.get(0);
        int[] end= new int[size];
        Map<Integer,Integer> Comp= new HashMap<>();
        //Comp.put()


        for (int i = 0; i < size; i++){
            //end[i]=arrival.get(i) + duration.get(i);
            Comp.put(i,arrival.get(i) + duration.get(i));
        }
        //sort data based on start & end time
        Map<Integer, Integer> sortedByPrice = Comp.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue())
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

System.out.println(sortedByPrice);
        for (int i = 1; i < arrival.size(); i++) {
//            if (arrival.get(i) <= end) {
//                count++;
//            }
//            end = arrival.get(i) + duration.get(i);
        }
        return count;
    }
}
