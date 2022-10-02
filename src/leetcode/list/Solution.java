package leetcode.list;

import leetcode.struct.ListNode;

public class Solution {
    /**
     * 160. 相交链表
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }


        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }

        return p1;
    }

    /**
     * 203. 移除链表元素
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;

        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return dummyHead.next;
    }

    /**
     * 206. 反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;

        }
        return pre;
    }

    /**
     * 剑指 Offer 18. 删除链表的节点
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = head;
        ListNode prev = dummy;
        while (p != null) {
            if (p.val == val) {
                prev.next = p.next;
                break;
            }
            prev  = p;
            p = p.next;
        }
        return dummy.next;
    }

    public ListNode reverseList1(ListNode head) {
        ListNode p = head;
        ListNode prev = null;
        while (p != null) {
            ListNode curr = p;
            ListNode next = p.next;
            curr.next = prev;
            prev = curr;
            p = next;
        }
        return prev;
    }

    public void deleteNode(ListNode node) {
        ListNode p = node;

    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(5);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;

        Solution s = new Solution();
        s.reverseList1(node1);
    }
}
