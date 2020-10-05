package HackerRank;

import java.util.Stack;

public class MyQueue<T> {
    Stack<T> firstStack = new Stack<>();
    Stack<T> secondStack = new Stack<>();
    public void enqueue(T t){
        firstStack.push(t);
    }
    public T dequeue(){
        if(secondStack.isEmpty()) {
            while (!firstStack.empty()) {
                secondStack.push(firstStack.pop());
            }
        }
        T t=secondStack.pop();
        return t;
    }
    public T peek(){
        if(secondStack.isEmpty()) {
            while (!firstStack.empty()) {
                secondStack.push(firstStack.pop());
            }
        }
        T t=secondStack.peek();
        return t;
    }
}
