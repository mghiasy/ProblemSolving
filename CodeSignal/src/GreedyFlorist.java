package HackerRank;

import java.util.Arrays;
//time O(nlogn+n) ->O(nlogn)
//Space O(n) -> Logn+n-->O(n)
public class GreedyFlorist {
    static int getMinimumCost(int k, int[] c) {
        Arrays.sort(c);//time O(nlogn), Space O(logn)-->QuickSort
        int maxResult=0;
        int len = c.length;
        int temp=0;
        if(k>0) {
            for (int i = len - 1; i >= 0; --i) {//O(n)
                temp=(len-1-i)/k;
                maxResult += c[i]*(1+temp);
            }
        }
        return maxResult;
    }

    public static void main(String[] args) {
        int[] arr ={1, 3, 5, 7, 9};
        getMinimumCost(3,arr);
    }
}
