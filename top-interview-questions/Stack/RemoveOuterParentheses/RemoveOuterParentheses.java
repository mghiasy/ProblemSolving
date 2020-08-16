package LeetCode;

import java.util.Stack;

public class RemoveOuterParentheses {
    public static String removeOuterParentheses(String S) {
        StringBuilder stb= new StringBuilder();
        int openP=0,closeP=0;
        int i=0;
        while(i<S.length()){
            if(S.charAt(i)==')'){
                closeP++;
                ++i;
            }
            else{
                openP++;
                ++i;
            }
            if(openP==closeP && openP!=0){
                stb.append(S.substring(1,i-1));
                S=S.substring(i);
                openP=0;
                closeP=0;
                i=0;
            }
        }
        return String.valueOf(stb);
    }
//using stack add pointer to ( in stack
public static String removeOuterParentheses2(String S) {
    StringBuilder stb= new StringBuilder();
    Stack<Integer> st = new Stack<>();
    int i=0;
    while(i<S.length()){
        if(S.charAt(i)=='('){
            st.push(i);
        }
        else{
            int openingIndex = st.pop();
            if(st.isEmpty()){
                stb.append(S.substring(openingIndex+1,i));//by removing outer parantheses
            }
        }
        ++i;
    }
    return String.valueOf(stb);
}
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses2("(()())(())"));
    }
}
