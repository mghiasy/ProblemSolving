package HackerRank;

import java.util.*;

public class TwoStrings {
    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {

        Set set = new HashSet();
        for(int i=0;i<s1.length();++i){
            set.add(s1.charAt(i));
        }
        for(int i=0;i<s2.length();++i){
            if(set.contains(s2.charAt(i))){
                return  "YES";
            }
        }
    return  "NO";
    }
}
