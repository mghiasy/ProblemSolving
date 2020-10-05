package InterviewQuestions;

import java.util.*;

//find all numbers that occur more than once in an array of integers.
// What is a second way you might do the same problem?
// Which approach would you prefer and why?
public class FindRepeated {
    public List<Integer> findRepeated(int[] arr) {
//        First Approach:

        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; ++i) {
            if (!set.contains(arr[i])) {
                set.add(arr[i]);
            } else {
                result.add(arr[i]);
            }
        }
        return result;
    }


//////////////
    public List<Integer>  findRepeated2(int[] arr){
        //        Second Approach:

        List<Integer> result= new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length;++i){
            map.put(arr[i], map.getOrDefault(0,arr[i])+1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()>1){
                result.add(entry.getKey());
            }
        }
        return result;
    }
}
