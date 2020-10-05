package serviceNow;
import java.lang.reflect.Array;
import java.util.*;
public class GroupAnagrams {
    //time:n*mlogm
    //space
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> charMap= new HashMap<>();

        for(String str:strs){//O(n) =>n= size of strs
            char[] chars= str.toCharArray();
            Arrays.sort(chars); //O(mlogm) => m=size of every letter
            if(!charMap.containsKey(chars)){
                List<String> strList= new ArrayList<>();
                strList.add(str);
                charMap.put(str,strList);
            }
            else{
                charMap.get(str).add(str);
            }
        }

//        List<List<String>> res= new ArrayList<>();
//        for(List<String> list:charMap.values()){
//            res.add(list);
//        }
//        return res;
        return new ArrayList(charMap.values());//creates a new list and add Items to it one by one
    }

    public static void main(String[] args) {
        String[] x ={"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(x);
    }
}
