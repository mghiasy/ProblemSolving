package LeetCode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ReverseString {
    public static void reverseString(char[] s) {
        char temp;
        for (int i = 0, j = s.length - 1; i < s.length - 1 && j > i; ++i, --j) {
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        int j = 0;
    }
//with while
    public static void reverseString3(char[] s) {
        char temp;
        int i=0;int j=s.length-1;
        while (j>i) {
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
        int ss=0;
    }

    //recursion
    //Time complexity : O(N) time to perform N/2N/2 swaps.
    //Space complexity : O(N) to keep the recursion stack.
    public static void reverseString2(char[] s) {
        recReverseString(s, 0, s.length - 1);
        int x = 1;
    }

    public static void recReverseString(char[] s, int left, int right) {
        char temp;
        if (right <= left) return;
        temp = s[left];
        s[left] = s[right];
        s[right] = temp;


        int newLeft=left+1;
        int newRight=right-1;
        recReverseString(s, newLeft, newRight);
    }

    public static void main(String[] args) {
        char[] t = {'a', 'b', 'c', 'd','e'};
        reverseString3(t);
    }
}
