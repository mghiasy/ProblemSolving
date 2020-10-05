package Algorithms.WarmUp.Mini_Max_Sum;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;

import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        int maxDig=arr[0];
        int minDig=arr[0];
        long sum=arr[0];
        long minSum=0,maxSum=0;
        for(int i=1; i<5;i++){
            sum+=arr[i];
            if(arr[i]>maxDig){
                maxDig=arr[i];
            }
            else if(arr[i]< minDig){
                minDig=arr[i];
            }
        }
        minSum=sum-maxDig;
        maxSum=sum-minDig;

        System.out.print(minSum+" "+maxSum);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
