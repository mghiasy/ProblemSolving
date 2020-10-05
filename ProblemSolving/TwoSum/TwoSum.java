package LeetCode;

import java.util.*;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            if (hm.containsKey(nums[i])) {
                res[0]=i;
                res[1]=hm.get(nums[i]);
                return res;
            }
            hm.put(target - nums[i],i);
        }
        return res;
    }
//
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;++i){
            map.put(target-nums[i],i);
        }
        int temp = 0;
        boolean flag= false;
        for(int i=0;i<nums.length;++i){
            if(map.containsKey(nums[i])){
                if((nums[i] != target-nums[i] )&& map.get(nums[i])!=i )
                    return new int[]{i,map.get(nums[i])};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] num = {3,3};
        System.out.println(twoSum2(num, 6));
    }
}
