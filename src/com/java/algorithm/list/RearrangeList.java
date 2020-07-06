package com.java.algorithm.list;




class RearrangeList {

    public static void reorder(ListNode head) {
        // TODO: Write your code here
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode p2 = reverse(slow);
        ListNode p1 = head;

        while(p1 != null && p2 != null) {
            ListNode temp = p1.next;
            p1.next = p2;
            p1 = temp;

            temp = p2.next;
            p2.next = p1;
            p2 = temp;

        }

        if(p1 != null) {
            p1.next = null;
        }

    }


    public static ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        RearrangeList.reorder(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}