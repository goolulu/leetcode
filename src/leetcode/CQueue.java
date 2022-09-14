package leetcode;

import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 */
public class CQueue {
    Stack<Integer> stack;
    Stack<Integer> stack1;

    public CQueue() {
        stack = new Stack<>();
        stack1 = new Stack<>();
    }

    public void appendTail(int value) {
        stack.push(value);
    }

    public int deleteHead() {
        if (!stack1.isEmpty()) {
            return stack.pop();
        } else {
            while (!stack.isEmpty()) {
                stack1.push(stack.pop());
            }
        }
        if (stack1.isEmpty()) {
            return -1;
        } else {
            return stack1.pop();
        }
    }

    public static void main(String[] args) {
        CQueue queue = new CQueue();
        queue.appendTail(3);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }
}
