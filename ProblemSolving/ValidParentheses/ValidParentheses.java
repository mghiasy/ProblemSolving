package ServiceNow;

import java.util.*;
//Runtime: 1 ms, faster than 99.18% of Java online submissions for Valid Parentheses.
//Memory Usage: 37.4 MB, less than 84.69% of Java online submissions for Valid Parentheses.
public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        for(char c : s.toCharArray()){
            if(map.containsKey(c)){
//                if(!st.isEmpty()){
//                    char bracket =st.pop();
//                    if(bracket != map.get(c)) return false;
//                }
//                else{
//                    return false;
//                }

//**************** //better way  ****************
                char bracket = st.isEmpty() ? '#': st.pop();
                if(bracket != map.get(c)) return false;
            }
            else{
                st.push(c);
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println(isValid("{[]}"));
    }
}
