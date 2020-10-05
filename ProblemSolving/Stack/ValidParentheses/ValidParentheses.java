package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//Time :O(n) :n=size of String
//Space: O(n) m: size of stack =>in worse case all the string in opening bracket ==> in worse case :stack size = string size
public class ValidParentheses {
    public static boolean isValid(String s) {
        if (s.length() == 0) return true;
        String[] sArray = s.split("");
        Stack<String> st = new Stack();
        for (String ss : sArray) {
            if ((ss.equals("{")) || (ss.equals("[")) || (ss.equals("(")))
                st.push(ss);
            else {
                if (!st.isEmpty()) {
                    String popElement = st.pop();
                    if ((ss.equals("}") && !popElement.equals("{")) || (ss.equals(")") && !popElement.equals("(")) || (ss.equals("]") && !popElement.equals("["))) {
                        return false;
                    }
                } else return false;
            }
        }
        if (st.isEmpty())
            return true;
        return false;
    }

    //better solution using map for mapping opening and closing bracket
    public static boolean isValid2(String s) {
        if (s.length() == 0) return true;
        Stack<Character> st = new Stack();
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c))//was in the list of map keys => is opening bracket
                st.push(c);
            else {
                Character popElement = st.isEmpty() ? '#' : st.pop();
                //if stack is empty => map.get will be not equal to popElement => will return false
                if(map.get(c) != popElement)
                    return false;
            }
        }
        //instead of if(st.isEmpty) return true else return false
        // a boolean condition => we can put it as return value
        return st.isEmpty();
}

    public static void main(String[] args) {
        String s = "}}";

        isValid(s);
    }
}
