import java.util.*;

//return the max length of substrings without repeat
public class LongestSubString {
    public static String lengthOfLongestSubstring(String s) {
//        Set<Character> set = new HashSet<>();
//        int result = 0;
//        for(int i=0;i<s.length();++i){
//            if(!set.contains(s.charAt(i))){
//                set.add(s.charAt(i));
//            }
//            else{
//                result= Math.max(result,set.size());
//                set.removeAll(set);
//                i--;
//            }
//        }
//        return Math.max(result,set.size());

        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);

            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return String.valueOf(set);

    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
