package test;


public class AVL {
    TreeNode head;

    public void insert(int value) {
        if (head == null) {
            head = new TreeNode(value);
        } else {
            head = head.insert(head, value);
        }

    }

    public void printTree() {
        head.iteratior(head);
    }

    private class TreeNode {
        int value;
        int height;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        public int getHeight(TreeNode node) {
            if (node == null) {
                return 0;
            }

            int leftHeight = getHeight(node.left);
            int rightHeight = getHeight(node.right);
            int height = Math.max(leftHeight, rightHeight) + 1;
            node.height = height;
            return height;
        }


        public TreeNode insert(TreeNode head, int value) {
            if (head == null) {
                return new TreeNode(value);
            }
            if (head.value > value) {
                head.left = insert(head.left, value);
                //L
                if (getHeight(head.left) - getHeight(head.right) > 1) {
                    if (value < head.left.value) {
                        head = rotateLL(head);
                    } else {
                        head = rotateLR(head);
                    }
                }

            } else if (head.value < value) {
                head.right = insert(head.right, value);
                if (getHeight(head.right) - getHeight(head.left) > 1) {
                    if (value < head.right.value) {
                        head = rotateRL(head);
                    } else {
                        head = rotateRR(head);
                    }
                }

            } else {
                System.out.printf("error");
            }
            return head;
        }

        public TreeNode rotateLL(TreeNode root) {


            TreeNode newTop = root.left;
            root.left = newTop.right;
            newTop.right = root;

            root.height = getHeight(root);
            newTop.height = getHeight(newTop);
            return newTop;
        }

        public TreeNode rotateRR(TreeNode root) {
            TreeNode newTop = root.right;
            root.right = newTop.left;
            newTop.left = root;

            root.height = getHeight(root);
            newTop.height = getHeight(newTop);
            return newTop;
        }

        public TreeNode rotateLR(TreeNode root) {
            root.left = rotateRR(root.left);
            return rotateLL(root);
        }

        public TreeNode rotateRL(TreeNode root) {
            root.right = rotateLL(root.right);
            return rotateRR(root);
        }

        public void select(TreeNode head, int value) {

        }

        public void iteratior(TreeNode head) {
            if (head == null) {
                return;
            }
            iteratior(head.left);
            System.out.print(head.value + ",");
            iteratior(head.right);
        }
    }

    public static void main(String[] args) {
        AVL avl = new AVL();

        avl.insert(3);
        avl.insert(2);
        avl.insert(1);
        avl.insert(4);
        avl.insert(5);
        avl.insert(6);
        avl.insert(7);
        avl.insert(16);
        avl.insert(15);
        avl.insert(14);
        avl.insert(13);
        avl.insert(12);
        avl.insert(11);
        avl.insert(10);
        avl.insert(8);
        avl.insert(9);

        avl.printTree();
    }
}
