package leetcode;

import java.util.Stack;

public class MyQueue {

    private Stack<Integer> firstStack ;
    private Stack<Integer> secondStack;

    private int size;

    public MyQueue() {

        firstStack = new Stack<Integer>();
        secondStack = new Stack<Integer>();
        size = 0;
    }

    public void push(int x) {
        pop();
        while (!secondStack.empty()) {
            size++;
            firstStack.push(secondStack.pop());
        }
        firstStack.push(x);
    }

    public int pop() {
        while (size > 0) {
            secondStack.push(firstStack.pop());
            size--;
        }
        return secondStack.pop();
    }

    public int peek() {
        while (size > 0) {
            secondStack.push(firstStack.pop());
            size--;
        }
        return secondStack.peek();
    }

    public boolean empty() {
        return firstStack.isEmpty() && secondStack.isEmpty();
    }

    /**
     * Your MyQueue object will be instantiated and called as such:
     *
     *
     *
     *
     *
     */
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.push(5);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
    }
}
