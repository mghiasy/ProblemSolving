package Algorithms.WarmUp.Plus_Minus;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {

        float negCount=0;
        float posCount=0;
        float zeroCount=0;
        float size=arr.length;
        for (int i=0;i<size;i++){
            if(arr[i]>0){
                posCount++;
            }
            else if(arr[i]<0){
                negCount++;
            }
            else if(arr[i]==0){
                zeroCount++;
            }
        }

        float posPercent=posCount/size;
        float negPercent=negCount/size;
        float zeroPercent=zeroCount/size;

        System.out.println(posPercent);
        System.out.println(negPercent);
        System.out.println(zeroPercent);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}

