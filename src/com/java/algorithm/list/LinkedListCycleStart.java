package com.java.algorithm.list;

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

public class LinkedListCycleStart {

    public static ListNode findCycleStart(ListNode head) {
        // TODO: Write your code here
        ListNode fast = head;
        ListNode slow = head;
        int cycleLength = 0;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast) {
                cycleLength = cycleLength(slow);
                break;
            }

        }


        System.out.println(cycleLength);
        return cycleSart(head,cycleLength);
    }

    public static ListNode cycleSart(ListNode head,int K) {
        ListNode p2 = head;
        ListNode p1 = head;

        while(K-- > 0) {
            p2 = p2.next;
        }

        while(p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }

    public static int cycleLength(ListNode slow) {
        ListNode current = slow;
        int length = 1;
        current = current.next;
        while(current != slow)  {
            current = current.next;
            ++length;
        }

        return length;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
    }
}