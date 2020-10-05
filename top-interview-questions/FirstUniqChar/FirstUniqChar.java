package ServiceNow;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqChar {
    //o(n^2)
    //Runtime: 239 ms, faster than 5.06% of Java online submissions for First Unique Character in a String.
    //Memory Usage: 95.2 MB, less than 5.03% of Java online submissions for First Unique Character in a String.
    public static int firstUniqChar(String s) {
        if(s.length()==0) return -1;
        String[] strArray=s.split("");
        Map<String,Integer> map = new LinkedHashMap<>();
        for(String str:strArray){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        String value=null;
        for(Map.Entry<String,Integer> entry:map.entrySet()){//O(n)
            if(entry.getValue() ==1){
                value= entry.getKey();
                return  s.indexOf(value);//o(n)
            }
        }
        return -1;
    }

    //o(n) solution
    //Runtime: 53 ms, faster than 15.45% of Java online submissions for First Unique Character in a String.
    //Memory Usage: 52.2 MB, less than 9.36% of Java online submissions for First Unique Character in a String.
    public static int firstUniqChar2(String s) {
        if(s.length()==0) return -1;
        char[] chrArray=s.toCharArray(); //o(n)
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(char c:chrArray){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        String value=null;
        for(int i=0;i<s.length();++i){//O(n)
            if(map.get(s.charAt(i)) ==1){//O(1)
                return  i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        firstUniqChar("leetcode");
    }
}
