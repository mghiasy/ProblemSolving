import java.util.*;

public class PatternMatch {
    public static int binaryPatternMatching(String pattern, String s) {
        String[] str = s.split("");
        List<String> vowels=Arrays.asList(new String[]{"a","e","i","o","u"});
        StringBuilder sb = new StringBuilder();
        for(String st:str){
            sb.append(vowels.contains(st)? "0"  : "1");
        }
        String binaryStr= String.valueOf(sb);
        int count =0;
        for(int i=0;i<=binaryStr.length()-pattern.length() ;++i){
            String subStr= binaryStr.substring(i,i+pattern.length());
            if(subStr.equals(pattern)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String pattern= "0";
        String  s= "y";
        System.out.println(binaryPatternMatching(pattern,s));
    }
}
