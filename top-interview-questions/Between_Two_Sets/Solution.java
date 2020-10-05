package Algorithms.Implementation.Between_Two_Sets;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */
     //public static String xx="";
    public static int gcd(int a,int b){
        int temp=0;
        while(b>=1){
            temp= b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public static int gcdArr(List<Integer> arr){
        int rsp=arr.get(0);
        for (int i=1;i<arr.size();i++){
            rsp=gcd(rsp,arr.get(i));
        }
        return rsp;
    }
    public static int lcm(int a,int b){
        int gcd=gcd(a,b);
        return a * (b/gcd);
    }
    public static int lcmArr(List<Integer> arr){
        int rsp=arr.get(0);
        for(int i=1;i<arr.size();i++){
            if(rsp % arr.get(i) !=0){
                rsp=lcm(rsp,arr.get(i));
            }
        }
        return rsp;
    }
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        int count = 0;
        int lcmA=lcmArr(a);
        int gcdB=gcdArr(b);
        for (int i=lcmA,j=2; i<=gcdB; i=j*lcmA, j++){
            if(gcdB% i ==0) count++;
        }
        return count;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
