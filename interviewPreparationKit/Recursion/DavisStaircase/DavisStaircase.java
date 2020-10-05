package HackerRank;

import java.util.ArrayList;
import java.util.List;

public class DavisStaircase {
    // Complete the stepPerms function below.
    static int stepPerms(int n) {
        int[] tempSums= new int[n];
        int tempValue=0;
        if (n == 1) {
            return 1;
        }
        else if (n == 2) {
            return 2;
        }
        else if (n == 3) {
            return 4;
        }
        else {
            tempSums[0]=1;
            tempSums[1]=2;
            tempSums[2]=4;

            for (int i = 3; i <= n-1; ++i) {
                tempValue = tempSums[i - 1] + tempSums[i - 2] + tempSums[i - 3];
                tempSums[i]=tempValue;
            }
        }
        return tempSums[n-1];
    }

    public static void main(String[] args) {
        System.out.println(stepPerms(5));
    }
}
