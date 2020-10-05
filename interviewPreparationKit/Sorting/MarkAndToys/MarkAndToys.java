package HackerRank;

import java.lang.reflect.Array;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;
//time : O(nlogn+n)  => o(nlogn)
//Space:O(2n)
public class MarkAndToys {
    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        Arrays.sort(prices);//time O(nlogn) space:O(n) in worse case
        int sumPrices=0;
        int countPrices=0;
        for(int i=0;i<prices.length;++i){//O(n)
            sumPrices+=prices[i];
            if(sumPrices<=k){
                //sumPrices+=prices[i];
                countPrices++;
            }
            else{
                break;
            }
        }
        return countPrices;
    }

    public static void main(String[] args) {
        int[] p ={1, 2,3,4};
        int m =50;
        System.out.println(maximumToys(p,7));

    }
}
