

import java.util.*;
//count pair so that A+K=B
public class CountPairsSumEqualK {
    public static int countPairs(List<Integer> numbers, int k) {
        // Write your code here
        Map<Integer,Integer> map = new HashMap<>();
        int res =0;
        for(int i=0;i<numbers.size();++i){
            map.put(numbers.get(i),numbers.get(i)-k);
        }
        for(int i=0;i<numbers.size();++i){
            if(map.containsKey(numbers.get(i))){
                if((numbers.get(i) != k - numbers.get(i)) && map.get(numbers.get(i)) != i){
                    res++;
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {

    }


}



