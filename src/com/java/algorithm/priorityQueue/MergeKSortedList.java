package com.java.algorithm.priorityQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class MergeKSortedList {
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length <= 0) return null;

        List<ListNode> iters = new ArrayList<>();

        for(ListNode node : lists) {
            if(node != null) {
                iters.add(node);
            }
        }

        if(iters.isEmpty()) {
            return null;
        }

        if(iters.size() == 1) {
            return iters.get(0);
        }

        PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(
                iters.size(), new Comparator<ArrayEntry>() {
            @Override
            public int compare(ArrayEntry ol , ArrayEntry o2) {
                return Integer.compare(ol.value , o2.value);
            }
        }
        );
        for(int i = 0; i < iters.size();i++) {
            ListNode node = iters.get(i);
            minHeap.add(new ArrayEntry(node.val,i));
            iters.set(i,node.next);
        }

        ListNode result = null;
        ListNode head = null;
        while(!minHeap.isEmpty()) {
            ArrayEntry headEntry = minHeap.poll();
            ListNode newNode = new ListNode(headEntry.value);
            if(result == null) {
                result = newNode;
                head = result;
            } else {
                result.next = newNode;
                result = result.next;
            }

            ListNode node = iters.get(headEntry.arrayId);

            if(node != null) {
                minHeap.add(new ArrayEntry(node.val,headEntry.arrayId));
                iters.set(headEntry.arrayId,node.next);
            }
        }

        return head;
    }


    private static class ArrayEntry {
        private Integer value;
        private Integer arrayId;


        public ArrayEntry(Integer value, Integer arrayId) {
            this.value = value;
            this.arrayId = arrayId;

        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Integer getArrayId() {
            return arrayId;
        }

        public void setArrayId(Integer arrayId) {
            this.arrayId = arrayId;
        }


    }


     private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


  public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        l1.next = new ListNode(10);

        ListNode l2 = new ListNode(6);
        l2.next = new ListNode(9);

        ListNode[] lists = new ListNode[]{l1,l2};

        ListNode result = mergeKLists(lists);

  }
}