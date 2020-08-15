package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue=null;
    Queue<Integer> queueHelp=null;
    public MyStack() {
         queue= new LinkedList<>();
         queueHelp=new LinkedList<>();
    }

    /** Push element x onto stack. */
    //TimeComplexity = O(2*n)=O(n)
    public void push(int x) {
        if(queue.isEmpty()) {
            queue.add(x);
        }
        else{
            while (!queue.isEmpty()){
                int item =queue.remove();
                queueHelp.add(item);
            }
            queue.add(x);
            while (!queueHelp.isEmpty()){
                int item =queueHelp.remove();
                queue.add(item);
            }
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    //TimeComplexity = o(1)
    public int pop() {
        return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack x= new MyStack();
        x.push((1));
        x.push((2));
        x.push((3));
        x.top();

    }
}
//with 1 queue
 class MyStack2 {
    Queue<Integer> queue=null;
    public MyStack2() {
        queue= new LinkedList<>();
    }

    /** Push element x onto stack. */
    //TimeComplexity =O(n)
    public void push(int x) {
        int queueSize=queue.size();
        queue.add(x);
        while (queueSize>0){
            //remove from front and add to end => reverse the queue
            queue.add(queue.remove());
            queueSize--;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    //TimeComplexity = o(1)
    public int pop() {
        return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
