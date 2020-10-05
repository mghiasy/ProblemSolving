package HackerRank;

import java.util.Arrays;

public class MinAbsoluteDiff {
    // Complete the minimumAbsoluteDifference function below.
    //first consider conditions;
    static int minimumAbsoluteDifference(int[] arr) {
        Arrays.sort(arr);
        int[] arr2= new int[arr.length-1];
        for(int i=0;i<arr2.length;++i){
            arr2[i]=Math.abs(arr[i]-arr[i+1]);
        }
        Arrays.sort(arr2);
        return arr2[0];
    }

    public static void main(String[] args) {
        int[] random = { 33, 22, 11, 21, 55, 32, 3, 4 };
        minimumAbsoluteDifference(random);

    }
}
