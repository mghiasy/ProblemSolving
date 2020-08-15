
import java.util.Map;
import java.util.Stack;
//Time Complexity : O(1)O(1) for all operations.
//Space Complexity : O(n)
//Worst case is that all the operations are push => O(2* n) =O(n) space used.
public class MinStack {
    //the first element in array is the number and the second Minvalue of stack until now.
    Stack<int[]> st= null;
    Integer minValue =  null;
    public MinStack() {
        st = new Stack<>();
    }

    public void push(int x) {
        if(st.isEmpty()){
            st.push(new int[]{x, x});
        }
        else{
            int[] top= st.peek();
            if(top[1] >x){
                st.push(new int[]{x,x});
            }
            else{
                st.push(new int[]{x,top[1]});
            }
        }
    }

    public void pop() {
        st.pop();
    }

    public int top() {
        int[] top= st.peek();
        return top[0];
    }

    public int getMin() {
        int[] top= st.peek();
        return top[1];
    }
}
//approach with 2 stacks
public class MinStack2 {
    //the first element in array is the number and the second Minvalue of stack until now.
    Stack<Integer> st= null;
    Stack<Integer> stMin= null;
    Integer minValue =  null;
    public MinStack2() {
        st = new Stack<>();
        stMin= new Stack<>();
    }

    public void push(int x) {
        st.push(x);
        if(stMin.isEmpty()){
            stMin.push(x);
        }
        else{
            int min= stMin.peek();
            if(min >=x){
                stMin.push(x);
            }
        }
    }

    public void pop() {
        int topSt=st.pop();
        int topMin= stMin.peek();
        if(topSt==topMin){
            stMin.pop();
        }
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return stMin.peek();
    }
}