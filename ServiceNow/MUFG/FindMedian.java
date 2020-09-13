package Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FindMedian {
    public static double arrayMedian(int[] sequence){
        Arrays.sort(sequence);
        int length = sequence.length;
        if(length % 2 != 0){
            return (double) sequence[(length-1)/2];
        }
        else {
            return (double) (sequence[length/2] + sequence[(length-1)/2]) /2;
        }
    }

    public static void main(String[] args) {
        int[] arr= {-1,3,-2,2};
        int[] arr2 ={1,3,2};
        System.out.println(arrayMedian(arr2));
    }
}
