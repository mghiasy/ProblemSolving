package LeetCode;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.*;
import java.util.Map;

public class SingleNumber{
    //Time complexity : O(n)
    //Space complexity : O(n)
        public int singleNumber(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int k:nums) {
                map.put(k, map.getOrDefault(k, 0) + 1);
            }
            for (int k: nums) {
                if (map.get(k) == 1) {
                    return k;
                }
            }
        return 0;
        }
    public int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sumOfNums=0;
        int sumOfSet=0;
        for (int num :nums) {
            if(!set.contains(num)) {
                set.add(num);
                sumOfSet+=num;
            }
            sumOfNums+=num;
        }

        return 2*sumOfNums-sumOfNums;
    }
    //best solution bit operator
    public static int singleNumber3(int[] nums) {
        int a = 0;
        for (int i : nums) {
            //exclusive OR ifa==0 => i else abs(a-i);
            //a⊕0=a && a⊕a=0
            a ^= i;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] x ={1,3,2,1,3,2,4};
        singleNumber3(x);
    }

}
