package Algorithms.WarmUp.timeConversion;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {

         int hour=Integer.parseInt(s.substring(0,2));
         String strHour="";
         String retStr="";

         if(s.substring(8,10).equals("PM") && hour<12){
             hour+=12;
             strHour=String.valueOf(hour);
             retStr = strHour+s.substring(2,8);
         }
         else if(s.substring(8,10).equals("AM") && hour==12){
             retStr = "00"+s.substring(2,8);
         }
        
         else retStr=s.substring(0,8);
         return retStr;

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}


