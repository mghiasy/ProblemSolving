package HackerRank;

import java.util.Arrays;
//time : O(2nlogn+n)  => o(nlogn)
//Space:O(4n)
public class MaxMin {
    // Complete the maxMin function below.
    static int maxMin(int k, int[] arr) {
        Arrays.sort(arr);//time O(nlogn) space:O(n) in worse case
        int len=arr.length;
        int newArrLen=len-k+1;
        int[] newArr=new int[newArrLen];//space:O(n)
        for(int i=0;i<=newArrLen-1;++i){//O(n)
            newArr[i]=arr[i+(k-1)]-arr[i];
        }
        Arrays.sort(newArr);//time O(nlogn) space:O(n) in worse case
        int minAmount=newArr[0];
        return minAmount;
    }

    public static void main(String[] args) {
int[] x ={4504,
        1520,
        5857,
        4094,
        4157,
        3902,
        822,
        6643,
        2422,
        7288,
        8245,
        9948,
        2822,
        1784,
        7802,
        3142,
        9739,
        5629,
        5413,
        7232
};
        System.out.printf(""+maxMin(5,x));

    }
}
