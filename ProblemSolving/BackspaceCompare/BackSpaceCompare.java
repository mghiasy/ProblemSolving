package LeetCode;

import java.util.Stack;

public class BackSpaceCompare {
    //Time Complexity: O(M + N), where M, N are the lengths of S and T respectively.
    //because of 2 for loop
    //Space Complexity: O(2M + 2N). //2Stack +2String
    public static boolean backspaceCompare(String S, String T) {
        String helpStrS="" , helpStrT="";
        Stack<Character> stackS= new Stack<>();
        Stack<Character> stackT= new Stack<>();
        //This repeating code can be separate helping method:
        for(char c: S.toCharArray()){
            if(c=='#'){
                if(!stackS.isEmpty())
                    stackS.pop();
            }
            else stackS.push(c);
        }
//        while(!stackS.isEmpty()){
//            helpStrS+=st.pop();
//        }

        //Change stack to string:
        helpStrS=String.valueOf(stackT);
        for(char c: T.toCharArray()){
            if(c=='#'){
                if(!stackT.isEmpty())
                    stackT.pop();
            }
            else stackT.push(c);
        }
//        while(!stackT.isEmpty()){
//            helpStrT+=st.pop();
//        }
        helpStrT=String.valueOf(stackT);
        return helpStrS.equals(helpStrT);
    }
//with helping function
//Time Complexity: O(M + N), where M, N are the lengths of S and T respectively.
//because of 2 times for loop
//Space Complexity: O(M + N). //2Stack => we do not use str
    public static boolean backspaceCompare2(String S, String T) {
        return helperMethod(S).equals(helperMethod(T));
    }
    public static String helperMethod(String S){
        Stack<Character> st= new Stack<>();
        for(char c: S.toCharArray()){
            if(c=='#'){
                if(!st.isEmpty())
                    st.pop();
            }
            else st.push(c);
        }
        return String.valueOf(st);
    }
//with out stack with stringBuilder and deleteChatAt() method
public static boolean backspaceCompare3(String S, String T) {
    return helperMethod2(S).equals(helperMethod2(T));
}
public static String helperMethod2(String S){
    StringBuilder stb= new StringBuilder();
    for(int i=0;i<S.length();++i){
        if(S.charAt(i)!='#'){
            stb.append(S.charAt(i));
        }
        else if(stb.length()>0){
            stb.setLength(stb.length()-1);
        }
    }
    return String.valueOf(stb);
}


    public static void main(String[] args) {
        String S= "ab##";
        String T= "c#d#";
        System.out.println(backspaceCompare3(S,T));
    }
}
