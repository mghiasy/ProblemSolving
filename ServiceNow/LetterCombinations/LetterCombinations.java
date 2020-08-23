package serviceNow;

import java.util.*;
import java.util.stream.Collectors;

public class LetterCombinations {
    Map<Character, char[]> digitsMap;
    public List<String> letterCombinations(String digits) {
        digitsMap = new HashMap<>();
        digitsMap.put('2', new char[]{'a', 'b', 'c'});
        digitsMap.put('3', new char[]{'d', 'e', 'f'});
        digitsMap.put('4', new char[]{'g', 'h', 'i'});
        digitsMap.put('5', new char[]{'j', 'k', 'l'});
        digitsMap.put('6', new char[]{'m', 'n', 'o'});
        digitsMap.put('7', new char[]{'p', 'q', 'r','s'});
        digitsMap.put('8', new char[]{'u', 't', 'v'});
        digitsMap.put('9', new char[]{'w', 'x', 'y','z'});

        //List<StringBuilder> res= new ArrayList<>();
        List<String> res= new ArrayList<>();//use string instead of StringBuilder => for every append create a NEW string
        res.add("");
        for(int i=0;i<digits.length();++i){
            res=combineStrings(res,digits.charAt(i));
        }
        return res.stream().map(x->String.valueOf(x)).collect(Collectors.toList());
    }
    public List<String> combineStrings(List<String> res,char digit) {
        char[] chars = digitsMap.get(digit);
        List<String> tempRes= new ArrayList<>();
        for (String s : res) {
            for (char c : chars) {
                tempRes.add(s+c);
            }
        }
        return tempRes;
    }
    //In Comments
    public List<String> letterCombinations2(String digits) {
        List<String> ans = new ArrayList<String>();
        if(digits==null||digits.length()==0) return ans;
        char[][] map = new char[8][];
        map[0]="abc".toCharArray();
        map[1]="def".toCharArray();
        map[2]="ghi".toCharArray();
        map[3]="jkl".toCharArray();
        map[4]="mno".toCharArray();
        map[5]="pqrs".toCharArray();
        map[6]="tuv".toCharArray();
        map[7]="wxyz".toCharArray();

        char[] input = digits.toCharArray();
        ans.add("");
        for(char c:input)
            ans=expand(ans,map[c-'2']);
        return ans;
    }
    private List<String> expand(List<String> l,char[] arr)
    {
        List<String> next = new ArrayList<String>();
        for(String s:l)
            for(char c:arr)
                next.add(s+c);
        return next;
    }

    public static void main(String[] args) {
        LetterCombinations lc = new LetterCombinations();
        lc.letterCombinations("2346");
    }

}
