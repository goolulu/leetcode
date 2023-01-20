package test;


import java.util.LinkedList;
import java.util.Queue;

public class BST {

    TreeNode head;

    public static void main(String[] args) {
        BST b = new BST();
        b.insert(15);
        b.insert(6);
        b.insert(18);
        b.insert(3);
        b.insert(7);
        b.insert(17);
        b.insert(20);
        b.insert(2);
        b.insert(4);
        b.insert(13);
        b.insert(9);

        b.printTree();
        System.out.println(" ");
        b.head.BFS(b.head);
//        TreeNode node = b.head.sucessor(b.select(13));
//        System.out.println(node);
        b.head.delete(b.head, 13);
        System.out.println();
        b.head.BFS(b.head);
    }

    public void insert(int value) {
        if (head == null) {
            head = new TreeNode(value);
        } else {
            head.insert(head, value);
        }
    }

    public TreeNode select(int value) {
        if (head.select(head, value) == null) {
            System.out.println("not find");
            return new TreeNode(-1);
        }
        return head.select(head, value);
    }

    public void printTree() {
        this.head.iterator(head);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode select(TreeNode head, int val) {
            TreeNode curr = head;
            while (curr != null) {
                if (curr.val == val) {
                    return curr;
                } else if (curr.val < val) {
                    curr = curr.right;
                } else if (curr.val > val) {
                    curr = curr.left;
                }
            }

            return null;
        }

        public TreeNode maximum(TreeNode head) {
            if (head == null) {
                return null;
            }
            while (head.right != null) {
                head = head.right;
            }
            return head;
        }

        public TreeNode minimum(TreeNode head) {
            if (head == null) {
                return null;
            }
            while (head.left != null) {
                head = head.left;
            }
            return head;
        }

        public void insert(TreeNode head, int val) {
            TreeNode curr = head, p = null;
            while (curr != null) {
                if (curr.val == val) {
                    System.out.printf("val[%s] value has bean existed\n", val);
                } else if (curr.val < val) {
                    p = curr;
                    curr = curr.right;
                } else if (curr.val > val) {
                    p = curr;
                    curr = curr.left;
                }
            }
            curr = new TreeNode(val);
            if (p.val < val) {
                p.right = curr;
            } else {
                p.left = curr;
            }
            curr.parent = p;

        }

        public void delete(TreeNode head, int val) {
            TreeNode node = select(head, val);

            if (node.left == null) {
                head = transplant(head, node, node.right);
            } else if (node.right == null) {
                head = transplant(head, node, node.left);
            } else {
                TreeNode sucessor = sucessor(node);
                if (sucessor.parent != node) {
                    head = transplant(head, sucessor, sucessor.right);
                    sucessor.right = node.right;
                    sucessor.right.parent = sucessor;
                }
                head = transplant(head, node, sucessor);
                sucessor.left = node.left;
                sucessor.left.parent = sucessor;
            }

        }

        public void iterator(TreeNode head) {
            if (head == null) {
                return;
            }
            iterator(head.left);
            System.out.print(head.val + ",");
            iterator(head.right);
        }

        public TreeNode transplant(TreeNode head, TreeNode original, TreeNode target) {
            if (original.parent == null) {
                head = target;
            } else if (original == original.parent.left) {
                original.parent.left = target;
            } else {
                original.parent.right = target;
            }
            if (target != null) {
                target.parent = original.parent;
            }
            return head;
        }

        public void BFS(TreeNode head) {
            Queue<TreeNode> queue = new LinkedList<>();

            if (head != null) {
                queue.add(head);
            }
            while (!queue.isEmpty()) {
                TreeNode current = queue.poll();
                System.out.print(current.val + ",");
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }

        public TreeNode sucessor(TreeNode node) {
            if (node.right != null) {
                return minimum(node.right);
            }

            TreeNode p = node.parent;
            while (p != null && p.right == node) {
                node = p;
                p = node.parent;
            }
            return p;
        }

        public TreeNode predecessor(TreeNode node) {
            if (node.left != null) {
                return maximum(node.left);
            }
            TreeNode x = node.parent;
            while (x != null && x.left == node) {
                node = x;
                x = node.parent;
            }

            return x;
        }
    }
}


