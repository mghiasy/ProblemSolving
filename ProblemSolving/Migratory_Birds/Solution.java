package Algorithms.Implementation.Migratory_Birds;

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

public class Solution {

    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
        HashMap<Integer,Integer> typeMap= new HashMap<>();
        //initialise hasMap
        for (int i=1;i<=5;i++){
            typeMap.put(i,0);
        }
        String ss="";
        int key=0,value=0;
        for (int i=0;i<arr.size();i++){
            key=arr.get(i);
            value= typeMap.get(key)+1;
            typeMap.put(key,value);
        }
        int maxValue=0,maxKey=0;
        for(Map.Entry<Integer,Integer> entry : typeMap.entrySet()){
           // ss+="key="+entry.getKey()+" value="+entry.getValue()+"\n";
            if(entry.getValue()>maxValue){
                maxValue=entry.getValue();
                maxKey=entry.getKey();
                
            }
        }
        return maxKey;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

