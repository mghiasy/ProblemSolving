package LeetCode;

import java.util.Stack;

public class CalPoints {
    public int calPoints(String[] ops) {
        Stack<Integer> st= new Stack<>();
        int sum=0;
        for(String op:ops){

            if(op.equals("C")){
                if(!st.isEmpty()) {
                    int temp = st.pop();
                    sum-=temp;
                }
            }
            else if(op.equals("D")){
                int temp = st.peek();
                st.push(temp*2);
                sum +=temp*2;
            }
            else if(op.equals("+")){
                int temp1 = st.pop();
                int temp2=st.peek();
                st.push(temp1);
                st.push(temp1+temp2);
                sum+=temp1+temp2;
            }
            else{
                int num= Integer.parseInt(op);
                st.push(num);
                sum+=num;
            }
        }
        return sum;
    }
}
