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

    public static void main(String[] args) {
        int[] num = {3, 3};
        twoSum(num, 6);
    }
}
