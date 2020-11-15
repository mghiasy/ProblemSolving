package HackerRank;

import java.util.Stack;
//time : O(n)
//Space:O(2n)
public class MyQueue<T> {
    Stack<T> firstStack = new Stack<>();
    Stack<T> secondStack = new Stack<>();
    public void enqueue(T t){//O(1)
        firstStack.push(t);
    }
    public T dequeue(){
        if(secondStack.isEmpty()) {
            while (!firstStack.empty()) {//O(n)
                secondStack.push(firstStack.pop());
            }
        }
        T t=secondStack.pop();
        return t;
    }
    public T peek(){
        if(secondStack.isEmpty()) {
            while (!firstStack.empty()) {//O(n)
                secondStack.push(firstStack.pop());
            }
        }
        T t=secondStack.peek();
        return t;
    }
}
