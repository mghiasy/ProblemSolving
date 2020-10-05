package HackerRank;

import java.util.HashMap;
import java.util.Map;

public class MinSwaps {
    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int swapCount=0;
        int temp=0;
        for (int j=0;j<arr.length;++j) {
            if(arr[j] != j+1){
                while (arr[j]!=j+1){
                    swapCount++;
                    temp=arr[j];
                    arr[j]=arr[temp-1];
                    arr[temp-1]=temp;

                }
            }
        }
        return swapCount;
    }
    public static void main(String[] args) {
    int[] arr={7,1,3,2,4,5,6};
    int[] arr2={4,3,1,2};
    int[] arr3={2 ,3, 4, 1, 5};

        System.out.println(""+ minimumSwaps(arr2));
    }
}
