package leetcode;

import leetcode.struct.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class BSTIterator {

    Deque<Integer> deque = new LinkedList<>();
    TreeNode root ;


    public BSTIterator(TreeNode root) {
        this.root = root;
        constructorStack();
    }

    private void constructorStack() {
        if (root != null) {
            TreeNode head = root;
            inOrder(head);
        }
    }

    private void inOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        inOrder(head.left);
        deque.push(head.val);
        inOrder(head.right);
    }

    public int next() {
        return deque.pollLast();
    }

    public boolean hasNext() {
        return !deque.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node15 = new TreeNode(15);
        TreeNode node20 = new TreeNode(20);

        node7.left = node3;
        node7.right = node15;
        node15.left = node9;
        node15.right = node20;


        BSTIterator bSTIterator = new BSTIterator(node7);
        System.out.println(bSTIterator.next());    // 返回 3
        System.out.println(bSTIterator.next());    // 返回 7
        System.out.println(bSTIterator.hasNext()); // 返回 True
        System.out.println(bSTIterator.next());    // 返回 9
        System.out.println(bSTIterator.hasNext()); // 返回 True
        System.out.println(bSTIterator.next());    // 返回 15
        System.out.println(bSTIterator.hasNext()); // 返回 True
        System.out.println(bSTIterator.next());    // 返回 20
        System.out.println(bSTIterator.hasNext()); // 返回 False
    }
}
