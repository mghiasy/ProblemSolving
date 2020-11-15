package HackerRank;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayManipulation {
    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long[] sumArray= new long[n+1];
        for(int i =0;i<queries.length;++i){
                for(int k=queries[i][0];k<=queries[i][1];++k){
                    sumArray[k]+=queries[i][2];
                }
        }
        Arrays.sort(sumArray);
        return sumArray[n];
    }

    public static void main(String[] args) {
        int[][] x = {{2 ,6, 8},
                { 3, 5, 7},
                { 1, 8 ,1},
                {5,9,15}};
        System.out.println(arrayManipulation(10,x));

    }
}
