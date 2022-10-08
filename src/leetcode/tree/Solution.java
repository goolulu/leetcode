package leetcode.tree;

import leetcode.struct.ListNode;
import leetcode.struct.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
    public List<Integer> preorderTraversal_Recursion(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    public void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    public List<Integer> preorderTraversal_iteration(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }

        }
        return list;
    }

    /**
     * 101. 对称二叉树
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;

        return symmetric(root.left, root.right);
    }

    private boolean symmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null ^ right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }

        return symmetric(left.right, right.left) && symmetric(left.left, right.right);

    }


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int minDepth_Recursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            min = Math.min(minDepth_Recursive(root.left), min);
        }
        if (root.right != null) {
            min = Math.min(minDepth_Recursive(root.right), min);
        }
        return min + 1;
    }
    public int minDepth_iteration(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        int depth = 1;
        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < stack.size(); i++) {
                TreeNode node = stack.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.right != null) {
                    stack.offer(node.right);
                }
                if (node.left != null) {
                    stack.offer(node.left);
                }
            }
            depth++;
        }
        return depth;
    }

    /**
     * 112.路径总和
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum_iteration(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(targetSum,root));

        int temp = targetSum;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                QueueNode cur = queue.poll();
                if (cur.node.left != null && Math.abs(cur.node.val) <= Math.abs(cur.value)) {
                    queue.offer(new QueueNode(cur.value - cur.node.val,cur.node.left) );
                }

                if (cur.node.right != null && Math.abs(cur.node.val) <= Math.abs(cur.value)) {
                    queue.offer(new QueueNode(cur.value - cur.node.val,cur.node.right) );
                }

                if (cur.node.right == null && cur.node.left == null) {
                    if (cur.value == cur.node.val) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    public static class QueueNode {
        public int value;
        public TreeNode node;

        public QueueNode(int value, TreeNode node) {
            this.value = value;
            this.node = node;
        }
    }

    public boolean hasPathSum_Recursive(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        return hasPathSum_Recursive(root.left, targetSum - root.val) || hasPathSum_Recursive(root.right, targetSum - root.val);
    }

    /**
     * 226. 翻转二叉树
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(9);
//        TreeNode node8 = new TreeNode(2);
//        TreeNode node9 = new TreeNode(1);


        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node7;
//        node4.right = node8;
//        node6.right = node9;
//        node5.right = node7;

//        node3.left = node4;
//        node3.right = node5;
//
//        node4.left = node6;
//        node4.right = node7;

        Solution solution = new Solution();
        solution.invertTree(node1);
    }
}
