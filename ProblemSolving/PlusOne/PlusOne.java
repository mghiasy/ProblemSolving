package LeetCode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Enumeration;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int[] resultArray = new int[digits.length + 1];
        int lastIndex = digits.length - 1;
        if (digits[lastIndex] < 9) {
            digits[lastIndex] += 1;
            return digits;
        } else do {
           // resultArray[lastIndex + 1] = 0;
            lastIndex--;
        }while (lastIndex>=0 && digits[lastIndex] == 9);
        if(lastIndex>=0) {
            resultArray[lastIndex + 1] = digits[lastIndex] + 1;
            System.arraycopy(digits, 0, resultArray,1,lastIndex );
            int[] xx= Arrays.copyOfRange(resultArray, 1, digits.length+1);
            return xx;
        }
        else {
            resultArray[0] =1;
        }
        return resultArray;

    }

    public static void main(String[] args) {
        int[] x = {1, 2, 1, 2, 3, 8};
        int[] x2 = {1, 2, 1, 2, 3, 9};
        int[] x3 = {9, 9, 9, 9, 9};
        int[] x4 = {8, 9, 9, 9, 9};
        x4= new int[6];
        x4[0]=0;
        plusOne(x4);
    }
}
