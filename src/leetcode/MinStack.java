package leetcode;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> supportStack = new Stack<>();

    public MinStack() {
        supportStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        if (supportStack.isEmpty() || val < supportStack.peek()) {
            supportStack.push(val);
        } else {
            supportStack.push(getMin());
        }
        stack.push(val);
    }

    public void pop() {
        stack.pop();
        supportStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return supportStack.peek();
    }

    /**
     * ["MinStack","push","push","push","getMin","top","pop","getMin"]
     * [[],[-2],[0],[-1],[],[],[],[]]
     * @param args
     */
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println(minStack.getMin());//   --> 返回 -3.
        minStack.top();//
        minStack.pop();//
        System.out.println(minStack.getMin());

    }
}
