package LeetCode;

import java.util.Map;
import java.util.TreeMap;

public class MaxProfit {
    public static int maxProfit(int[] prices) {
        long buyPrice = 0, sellPrice = 0;
        int profit = 0;
        if (prices.length == 1) return 0;
        else if (prices.length > 1) {
            buyPrice = prices[0];
            for (int j = 1; j < prices.length; ++j) {
                if (prices[j] > sellPrice && prices[j] >buyPrice) {
                    sellPrice = prices[j];
                }
                if (prices[j] < sellPrice || j == prices.length - 1) {
                    profit += (sellPrice - buyPrice)>0 ? (sellPrice - buyPrice) :0;
                    buyPrice = prices[j];
                    sellPrice = 0;
                }
                else if (prices[j] < buyPrice) {
                    buyPrice = prices[j];
                }
            }
        }
        return profit > 0 ? profit : 0;
    }
    //better solution
    public int maxProfit2(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] x = {2,4,1};
        int[] xx={7,1,5,3,6,4};
        int[] x2={1,2,3,4,5};
        int[] x3={1,7,4,2};
        System.out.println(maxProfit(x2));
        ;
    }
}
