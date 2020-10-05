package HackerRank;

import java.util.*;
//time : O(n+nlogn+n)=O(nlogn)
//Space O(2n)=O(n)
public class luckBalance {
    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        int maxLuckBalance=0;
        List<Integer> importantList= new ArrayList<>();
        int noImportantLuck= 0;
        for(int i=0;i<contests.length;++i) {//O(n)
            if(contests[i][1] ==0){
                noImportantLuck+=contests[i][0];
            }
            else{
                importantList.add(contests[i][0]);
            }
        }
       // importantList.sort((y,x)->x.compareTo(y));
        importantList.sort(Comparator.reverseOrder());//O(nlogn)
    for(int i=0;i<importantList.size();++i){//O(n)
        if(i<k){
            maxLuckBalance+=importantList.get(i);
        }
        else{
            maxLuckBalance-=importantList.get(i);
        }
    }
    return maxLuckBalance+noImportantLuck;
    }

    public static void main(String[] args) {
        int[][] x= {{5, 1},
                {2 ,1},
                { 1, 1},
                {8, 1},
                {10, 0},
                {5, 0}};
        luckBalance(3,x);

    }
}
