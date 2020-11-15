package HackerRank;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the simplifiedChessEngine function below.
     */
    static String simplifiedChessEngine(char[][] whites, char[][] blacks, int moves) {
        /*
         * Write your code here.
         */
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(scanner.nextLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {
            String[] wbm = scanner.nextLine().split(" ");

            int w = Integer.parseInt(wbm[0].trim());

            int b = Integer.parseInt(wbm[1].trim());

            int m = Integer.parseInt(wbm[2].trim());

            char[][] whites = new char[w][3];

            for (int whitesRowItr = 0; whitesRowItr < w; whitesRowItr++) {
                String[] whitesRowItems = scanner.nextLine().split(" ");

                for (int whitesColumnItr = 0; whitesColumnItr < 3; whitesColumnItr++) {
                    String whitesItemStr = whitesRowItems[whitesColumnItr];

                    char whitesItem = whitesItemStr.charAt(0);
                    whites[whitesRowItr][whitesColumnItr] = whitesItem;
                }
            }

            char[][] blacks = new char[b][3];

            for (int blacksRowItr = 0; blacksRowItr < b; blacksRowItr++) {
                String[] blacksRowItems = scanner.nextLine().split(" ");

                for (int blacksColumnItr = 0; blacksColumnItr < 3; blacksColumnItr++) {
                    String blacksItemStr = blacksRowItems[blacksColumnItr];

                    char blacksItem = blacksItemStr.charAt(0);
                    blacks[blacksRowItr][blacksColumnItr] = blacksItem;
                }
            }

            String result = simplifiedChessEngine(whites, blacks, m);
        }

        bufferedWriter.close();
    }
}
