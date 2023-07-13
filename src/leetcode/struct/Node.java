package leetcode.struct;

import java.util.List;

public class Node {

    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int _val, List<Node> children) {
        this.val = _val;
        this.children = children;
    }


}
