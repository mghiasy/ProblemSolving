package ServiceNow;

import java.util.*;

//In mathematics a polydivisible number (or magic number) is a number in a given number base
// with digits abcde... that has the following properties :
//
//Its first digit a is not 0.
//The number formed by its first two digits ab is a multiple of 2.
//The number formed by its first three digits abc is a multiple of 3.
//The number formed by its first four digits abcd is a multiple of 4.
//etc.
//
//
//Write a method to verify weather the given input is poly-divisible number.

public class PolyDivisible {
    public static boolean polydivisible(int n){
        String s= String.valueOf(n);
        int number = 0;
        StringBuilder sb = new StringBuilder();
        //Its first digit a is not 0.
        if(s.charAt(0)=='0') return false;

        for(int i=0;i<s.length();++i){
            sb= sb.append(s.charAt(i));

            number = Integer.parseInt(String.valueOf(sb));
            if((number%(i+1))!=0) return false;
        }
        return true;
    }

    // new requirement => write another method => not to have any repeated number
    public static boolean polydivisible_unique(int n){
        String s= String.valueOf(n);
        int number = 0;
        StringBuilder sb = new StringBuilder();
        //Its first digit a is not 0.
        if(s.charAt(0)=='0') return false;
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<s.length();++i){
            if(map.containsKey(Character.getNumericValue(s.charAt(i))) )return false;
            map.put(Character.getNumericValue(s.charAt(i)),map.getOrDefault(Character.getNumericValue(s.charAt(i)),0)+1);
        }

        for(int i=0;i<s.length();++i){
            sb= sb.append(s.charAt(i));

            number = Integer.parseInt(String.valueOf(sb));
            if((number%(i+1))!=0) return false;
        }
        return true;
    }

    // new requirement => write another method => create polyDivisable number
    //input : number of digits => output : equivalant polyDivisable number
    //?
    public static int polydivisible_Create(int count){
        if(count == 1) return 1;
        int i=1;
        StringBuilder sb = null;
        for(int p=1;p<=9;++p) {
            sb = new StringBuilder();
            sb.append(p);
            while (i < count-1) {
                for (int j = 1; j <= 9; ++j) {
                    sb.append(j);
                    if (Integer.parseInt(String.valueOf(sb)) % i == 0) break;
                    else {
                        sb.setLength(sb.length() - 1);
                    }
                }
                i++;
            }
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        polydivisible_Create(3);
    }


}
