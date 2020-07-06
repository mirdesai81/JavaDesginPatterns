package com.java.algorithm.list;

/*class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}*/

class PalindromicLinkedList {

    public static boolean isPalindrome(ListNode head) {
        // TODO: Write your code here
        ListNode slow = head;
        ListNode fast = head;
        ListNode prevSlow = null;
        int length = 0;
        boolean isOdd = true;


        // 1 2 3 4

        while(fast != null && fast.next != null) {

            fast = fast.next.next;
            prevSlow = slow;
            slow = slow.next;
            prevSlow.next = slow;
            length++;
            if(fast == null) {
                isOdd = false;
            }
        }

        if(isOdd) {
            length = length*2 + 1;
            //prevSlow = slow;
            slow = slow.next;
        } else {
            length = 2*length;
        }

        System.out.println(length);
        if(prevSlow != null)
            prevSlow.next = null;

        ListNode p1 = head;
        ListNode p2 = reverse(slow);

        while(p1 != null && p2 != null) {
            if(p1.value != p2.value) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    // 5 - 4 - 3
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
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

        head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
    }
}