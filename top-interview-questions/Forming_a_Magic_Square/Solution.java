package Algorithms.Implementation.Forming_a_Magic_Square;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the formingMagicSquare function below.
    static String formingMagicSquare(int[][] s) {
        Map<Integer, List<Integer>> hashMatrix = new HashMap<>();
        hashMatrix.put(0, new ArrayList<Integer>(){{add(s[0][0]);add(s[0][1]);add(s[0][2]);}});
        hashMatrix.put(1, new ArrayList<Integer>(){{add(s[1][0]);add(s[1][1]);add(s[1][2]);}});
        hashMatrix.put(2, new ArrayList<Integer>(){{add(s[2][0]);add(s[2][1]);add(s[2][2]);}});
        hashMatrix.put(3, new ArrayList<Integer>(){{add(s[0][0]);add(s[1][0]);add(s[2][0]);}});
        hashMatrix.put(4, new ArrayList<Integer>(){{add(s[0][1]);add(s[1][1]);add(s[2][1]);}});
        hashMatrix.put(5, new ArrayList<Integer>(){{add(s[0][2]);add(s[1][2]);add(s[2][2]);}});
        hashMatrix.put(6, new ArrayList<Integer>(){{add(s[0][0]);add(s[1][1]);add(s[2][2]);}});
        hashMatrix.put(7, new ArrayList<Integer>(){{add(s[0][2]);add(s[1][1]);add(s[2][0]);}});

        int[] sumArr = new int[8];
        //Calc all sums
        for(Map.Entry<Integer, List<Integer>> entry : hashMatrix.entrySet()){
            int tempSum=0;
            for (int i=0;i<3;i++){
                tempSum += entry.getValue().get(i);
            }
            sumArr[entry.getKey()]=tempSum;
        }

        //compare other sums with maxsum
        int totalCost=0;
        String xx="";  
        for(int i=0;i<8;i++){
            int Diff= 15 - sumArr[i];
             
            List<Integer> itemValue = hashMatrix.get(i);
            if(Diff != 0){
                for(int j=0;j<3;j++){   
                    int itemNum=itemValue.get(j);
                    if(itemNum+Diff <=9){
                        totalCost+=Math.abs(Diff);
                        itemValue.set(j,itemNum+Diff);
                        hashMatrix.put(i,itemValue);
                        xx+= "i="+i+",j="+j+"itemNum="+itemNum+"totalCost"+totalCost+"\n";
                        break;
                    }

                    //Calc and update all sums again
                    for(Map.Entry<Integer,List<Integer>> en : hashMatrix.entrySet()){
                        int tempSum=0;
                        for (int k=0;k<3;k++){
                            tempSum += en.getValue().get(k);
                        }
                        sumArr[en.getKey()]=tempSum;
                    }
                }
             }

        }
        return xx;
       // return totalCost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        //int result = formingMagicSquare(s);
        String result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

