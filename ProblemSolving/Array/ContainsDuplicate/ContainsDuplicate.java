package LeetCode;

import java.util.*;

public class ContainsDuplicate {
    //sort check with next =>o(nlogn)
    //space: O(1) :o(nlogn)=>for quicksort

    //In general, it is not a good practice to modify the input.
    // //One may make a copy of nums and operate on the copy instead.
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

    //better way
    public boolean containsDuplicate2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry entry : map.entrySet()) {
            if ((int) entry.getValue() > 1) {
                return true;
            }
        }
        return false;
    }
    //perfect way 1 loop with set
    public boolean ContainsDuplicate3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length;++i){
            set.add(nums[i]);
        }
        return set.size() != nums.length;
    }
}
