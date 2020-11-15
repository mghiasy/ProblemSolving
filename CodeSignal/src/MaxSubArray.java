package LeetCode;

import java.lang.reflect.Array;
import java.util.*;

public class MaxSubArray {
    //brote force =>n^log(n)
    public static int maxSubArray(int[] nums) {
        //int[] sums= new int[nums.length*(nums.length+1)/2];
        Set<Integer> sums = new TreeSet<>(Collections.reverseOrder());
        //int p=0; //int sumLength=0;
        int sum=0;
        for(int i=0;i<nums.length;++i){
            sum=nums[i];
            sums.add(sum);
            //sumLength++;
            for(int j=i+1;j<nums.length;++j){
                sum+=nums[j];
                sums.add(sum);
                //sumLength++;
            }
        }
        //Arrays.sort(sums);
        return sums.stream().findFirst().get();
    }
    //Greedy
    public static int maxSubArray2(int[] nums) {
        if(nums.length==0) return 0;
        int i=0;
        int maxSum=0;
        int sum=0;
        //maxSum[0]=nums[0];
        while(i<nums.length){
            sum+=nums[i];
            maxSum=Math.max(sum,maxSum);
            i++;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] x ={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray2(x));
    }
}
