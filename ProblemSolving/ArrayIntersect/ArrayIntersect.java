package LeetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;

public class ArrayIntersect {
    //time:o(nlogn)
    //space:o(2nlogn+n)
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int minLength = nums1.length < nums2.length ? nums1.length : nums2.length;
        int[] resultList = new int[minLength];

        //num1.length<num2.length
        int i = 0, j = 0,p=0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                resultList[p++]=nums1[i];
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) j++;
            else if (nums1[i] < nums2[j]) i++;
        }
        return Arrays.copyOfRange(resultList,0,p);
    }

    //better solution
    //Time complexity: O(n+m)
    //Space complexity: O(min(n,m))
    public static int[] intersect2(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            return intersect2(nums2, nums1);
        }
        //key :num, value:frequency
        Map<Integer,Integer> map= new HashMap<>();
        for(int num:nums1){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int[] resultArray =new int[nums1.length];//smaller array
        Map<Integer,Integer> resultMap = new HashMap<>();
        int count=0;
        int p=0;
        for(int num2:nums2){
            if(map.containsKey(num2)){
                count=map.getOrDefault(num2,0);
                if(count>0){
                    resultArray[p++]=num2;
                    map.put(num2,count-1);//reduce the value in map
                }
            }
        }
        //we inserted p number in resultArray
        return Arrays.copyOfRange(resultArray,0,p-1);
    }

    public static void main(String[] args) {
        int[] a1 = {9,4,9,8,4};
        int[] a2 = {4,9,5};
        intersect2(a1, a2);
    }
}

