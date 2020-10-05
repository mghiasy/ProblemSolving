package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//inline for and while in total will be executed m times (where m = nums2.length)
// the first for will be executed n times (where n= nums1.length)
//time complexity = o(n*m)
//Space complexity : O(m). helpArray of size m is used.
public class nextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int size = nums1.length;
        int[] helpArray = new int[size];
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < nums2.length; ++j) {
                if (nums1[i] == nums2[j]) {
                    if (j == nums2.length - 1) {
                        helpArray[i] = -1;
                    } else {
                        while (j < nums2.length-1) {
                            j = j + 1;
                            if (nums2[j] > nums1[i]) {
                                helpArray[i] = nums2[j];
                                break;
                            }
                        }
                        if (helpArray[i] == 0) {
                            helpArray[i] = -1;
                        }
                    }
                }
            }
        }
        return helpArray;
    }

    //using Map brute force
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int size = nums1.length;
        int[] helpArray = new int[size];
        //add num2 in map
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums2.length;++i){
            map.put(nums2[i],i);
        }


        for (int i = 0; i < size; ++i) {
            for (int j = map.get(nums1[i]); j < nums2.length; ++j) {
                if(nums2[j]>nums1[i]){
                    helpArray[i]=nums2[j];
                    break;
                }
                if(j==nums2.length-1){
                    helpArray[i]=-1;
                }
            }
        }
        return helpArray;
    }
//using stack
    //Space and time:O(m+n)
    public int[] nextGreaterElement3(int[] nums1, int[] nums2) {
        int size = nums1.length;
        int[] helpArray = new int[size];
        //add num2 in map
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack=new Stack<>();
        //check all the elements in nums2 and insert pair elements,first greatest into map
        for(int i=0;i<nums2.length;++i) {
            stack.push(nums2[i]);
            while (!stack.isEmpty() && nums2[i+1]>stack.peek())
                    map.put(stack.pop(),nums2[i]);
            stack.push(nums2[i+1]);
        }
        for(int i=0;i<nums1.length;++i){
            helpArray[i]=map.get(nums1[i]);
        }
        return helpArray;
    }
}
