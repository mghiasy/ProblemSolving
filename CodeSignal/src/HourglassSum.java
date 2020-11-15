package HackerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//time O(n^2)
//Space O(n^2)
public class HourglassSum {
    static int hourglassSum(int[][] arr) {
        List<Integer> tempSums= new ArrayList<>();
        int tempSum=0;
        int maxTemoSum=0;
        for (int i=0;i<4;++i){
            for (int j=0;j<4;++j){
                    tempSum=arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1]+arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
                    tempSums.add(tempSum);
            }
        }
        Collections.sort(tempSums);
        maxTemoSum=tempSums.get(tempSums.size()-1);
        return maxTemoSum;
    }
    public static void main(String[] args) {
    int[][] x={{1, 1, 1, 0, 0, 0},
               {0 ,1 ,0 ,0 ,0, 0},
               {1 ,1 ,1, 0, 0, 0},
               {0 ,0, 2, 4 ,4, 0},
               {0, 0, 0, 2, 0, 0},
               {0, 0, 1, 2, 4, 0}};
        hourglassSum(x);
    }

}
