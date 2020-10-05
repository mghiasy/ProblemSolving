package HackerRank;

import java.util.Arrays;

public class LeftRotation {
    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int[] shiftedArr= new int[a.length];
        for(int i=d;i<a.length;++i){
            shiftedArr[i-d] = a[i];
        }
        System.arraycopy(a, 0, shiftedArr, a.length-d, d);
        int x=1;
    return shiftedArr;
    }

    public static void main(String[] args) {
        int[] a={1 ,2 ,3, 4 ,5};
        System.out.println(""+rotLeft(a,4).toString());
    }
}
