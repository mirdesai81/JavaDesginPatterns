package com.java.algorithm.list;

/**
 * Created by Mihir.Desai on 3/24/2017.
 */

import com.java.algorithm.list.LinkedStack.Node;
public class LinkedListTest {

    public static void main(String args[]) {
        LinkedListTest test = new LinkedListTest();

   /*     LinkedStack<String> stack = new LinkedStack<>();
        String[] data = new String[]{"to","be","-","or","to","not","-","-","that","-"};
        for(String s : data) {
            if(!s.equals("-"))
                stack.addFirst(s);
            else if(!stack.isEmpty()) {
                System.out.println(stack.First());
            }
        }

        System.out.println("Size left on stack - "+stack.size());
        System.out.println(test.getItems(stack.getFirst()));*/

        /*Iterator<String> it = stack.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }*/

        //test.reverse(stack.getFirst());
        /*System.out.println(stack.toString());*/

        LinkedStack<Integer> stack1 = new LinkedStack<>();
     /*   for(int i = 1 ; i < 10;i++) {
            stack1.addFirst(i);
        }

        System.out.println("Before swap - "+test.getItems(stack1.getFirst()));
        Node newHead = test.swapNodes(stack1.getFirst());
        System.out.println("After swap - "+test.getItems(newHead));*/


        stack1 = new LinkedStack<>();
        stack1.addFirst(15);
        stack1.addFirst(10);
        stack1.addFirst(3);
        stack1.addFirst(4);
        stack1.addFirst(1);
        stack1.addFirst(11);

      /*  System.out.println("Before finding palindrome - "+test.getItems(stack1.getFirst()));
        System.out.println("Max palindrome - " + test.maxPalindrome(stack1.getFirst()));
*/
       /* System.out.println("Before Swap - "+test.getItems(stack1.getFirst()));
        test.swapKthNode(stack1.getFirst(),2);

        System.out.println("Before Swap - "+test.getItems(stack1.getFirst()));
        test.swapKthNode(stack1.getFirst(),1);*/

     /*   stack1 = new LinkedStack<>();
        stack1.push(1);
        stack1.push(3);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);
        stack1.push(6);
        stack1.push(7);
        stack1.push(8);
        stack1.push(9);
        stack1.push(10);

        System.out.println("Original List - "+test.getItems(stack1.getFirst()));
        Node head = test.reverseAltKNodes(stack1.getFirst(),2);
        System.out.println("After calling reverse alternate 2 nodes - " + test.getItems(head));

        Node sortedList = test.mergeSort(head);
        System.out.println("After calling merge sort - " + test.getItems(sortedList));

        stack1 = new LinkedStack<>();
        stack1.pushAtEnd(1);
        stack1.pushAtEnd(2);
        stack1.pushAtEnd(3);
        stack1.pushAtEnd(4);
        stack1.pushAtEnd(5);
        stack1.pushAtEnd(6);
        stack1.insertLoop(2);
        test.displayLoop(stack1.getFirst());
        test.findLoop(stack1.getFirst());*/

        stack1 = new LinkedStack<>();
        stack1.addLast(10);
        stack1.addLast(30);
        stack1.addLast(70);
        stack1.addLast(80);
        stack1.addLast(90);
        System.out.println("List 1 Before Sort and Merge : " + test.getItems(stack1.getFirst()));
        LinkedStack<Integer> stack2 = new LinkedStack<>();
        stack2.addLast(40);
        stack2.addLast(60);
        stack2.addLast(20);
        System.out.println("List 2 Before Sort and Merge : " + test.getItems(stack2.getFirst()));

        Node merge =  test.mergeList(test.mergeSort(stack1.getFirst()),test.mergeSort(stack2.getFirst()));
       // Node merge =  test.mergeList(stack1.getFirst(),stack2.getFirst());
        System.out.println("Merged List L1 & L2 after sort : "+test.getItems(merge));

        stack1 = new LinkedStack<>();
        stack1.addLast(1);
        stack1.addLast(2);
        stack1.addLast( 3);
        stack1.addLast(4);
        stack1.addLast(5);
        stack1.addLast(6);
        System.out.println("List before reverse sublist from 1 to 4 : "+test.getItems(stack1.getFirst()));
        Node reverse = test.reverseSubList(stack1.getFirst(),1,4);
        System.out.println("List after reverse sublist from 1 to 4 : " + test.getItems(reverse));


        stack1 = new LinkedStack<>();
        stack1.addLast(1);
        stack1.addLast(2);
        stack1.addLast( 3);
        stack1.addLast(4);
        stack1.addLast(5);
        stack1.addLast(6);
        System.out.println("List 1 before overlapping test : "+test.getItems(stack1.getFirst()));

        stack2 = new LinkedStack<>();
        stack2.addLast(12);
        stack2.addLast( 10);
        stack2.addLast(4);
        stack2.addLast(5);
        stack2.addLast(6);
        System.out.println("List 2 before overlapping test : "+test.getItems(stack2.getFirst()));

        Node overlapping = test.overlappingListNoCycle(stack1.getFirst(),stack2.getFirst());
        System.out.println("List to find overlapping test : "+test.getItems(overlapping));

        stack1 = new LinkedStack<>();
        stack1.addLast(1);
        stack1.addLast(2);
        stack1.addLast( 3);
        stack1.addLast(4);
        stack1.addLast(5);
        stack1.addLast(6);
        System.out.println("List before removing 3rd last node : "+test.getItems(stack1.getFirst()));

        Node kLast = test.removeKthLast(stack1.getFirst(),3);
        System.out.println("List after removing 3rd last node : "+test.getItems(kLast));


        stack1 = new LinkedStack<>();
        stack1.addLast(1);
        stack1.addLast(2);
        stack1.addLast( 2);
        stack1.addLast(4);
        stack1.addLast(4);
        stack1.addLast(6);
        System.out.println("List before removing duplicates : "+test.getItems(stack1.getFirst()));

        Node first = test.removeDuplicatesFromSortedList(stack1.getFirst());
        System.out.println("List after removing duplicates : "+test.getItems(first));

        stack1 = new LinkedStack<>();
        stack1.addLast(1);
        stack1.addLast(1);
        stack1.addLast( 1);
        stack1.addLast(4);
        stack1.addLast(4);
        stack1.addLast(6);
        System.out.println("List before removing duplicates : "+test.getItems(stack1.getFirst()));

        Node nodes = test.removeDuplicatesFromSortedList(stack1.getFirst(),3);
        System.out.println("List after removing duplicates : "+test.getItems(nodes));


        stack1 = new LinkedStack<>();
        stack1.addLast(1);
        stack1.addLast(1);
        stack1.addLast( 4);
        stack1.addLast(4);
        stack1.addLast(4);
        stack1.addLast(6);
        System.out.println("List before removing duplicates : "+test.getItems(stack1.getFirst()));

        nodes = test.removeDuplicatesFromSortedList(stack1.getFirst(),3);
        System.out.println("List after removing duplicates : "+test.getItems(nodes));

        stack1 = new LinkedStack<>();
        stack1.addLast(1);
        stack1.addLast(2);
        stack1.addLast( 3);
        stack1.addLast(4);
        stack1.addLast(5);
        stack1.addLast(6);
        System.out.println("List before right shift: "+test.getItems(stack1.getFirst()));

        nodes = test.cyclicallyRightShift(stack1.getFirst(),5);
        System.out.println("List after right shift : "+test.getItems(nodes));

        stack1 = new LinkedStack<>();
        stack1.addLast(1);
        stack1.addLast(2);
        stack1.addLast( 3);
        stack1.addLast(4);
        stack1.addLast(5);
        stack1.addLast(6);
        System.out.println("List before even odd merge: "+test.getItems(stack1.getFirst()));

        nodes = test.evenOdd(stack1.getFirst());
        System.out.println("List after even odd merge : "+test.getItems(nodes));

        stack1 = new LinkedStack<>();
        stack1.addLast(1);
        stack1.addLast(2);
        stack1.addLast( 3);
        stack1.addLast(1);
        stack1.addLast(2);
        stack1.addLast(1);
        System.out.println("List before isPalindrome: "+test.getItems(stack1.getFirst()));

        boolean isPalindrome = test.isPalindrome(stack1.getFirst());
        System.out.println("IsPalindrome test: "+isPalindrome);

        stack1 = new LinkedStack<>();
        stack1.addLast(1);
        stack1.addLast(2);
        stack1.addLast( 3);
        stack1.addLast(2);
        stack1.addLast(1);
        System.out.println("List before isPalindrome: "+test.getItems(stack1.getFirst()));

        isPalindrome = test.isPalindrome(stack1.getFirst());
        System.out.println("IsPalindrome test: "+isPalindrome);

        stack1 = new LinkedStack<>();
        stack1.addLast(10);
        stack1.addLast(5);
        stack1.addLast( 2);
        stack1.addLast(3);
        stack1.addLast(1);
        System.out.println("List before Partition: "+test.getItems(stack1.getFirst()));

        nodes = test.partition(stack1.getFirst(),4);
        System.out.println("List after partition: "+test.getItems(nodes));

        stack1 = new LinkedStack<>();
        stack1.addLast(5);
        stack1.addLast(9);
        stack1.addLast( 6);
        System.out.println("List 1 before addition: "+test.getItems(stack1.getFirst()));

        stack2 = new LinkedStack<>();
        stack2.addLast(3);
        stack2.addLast(8);
        stack2.addLast( 7);
        System.out.println("List 2 before addition: "+test.getItems(stack2.getFirst()));

        nodes = test.addTwoNumbers(stack1.getFirst(),stack2.getFirst());
        System.out.println("List after addition: "+test.getItems(nodes));



    }

    /**
     * Swap Alternate Nodes in a list
     * @param first
     * @return
     */
    public Node swapNodes(Node first) {
        Node ptrOne_prev = null;
        Node newFirst = null;

        while(first != null && first.next != null) {
            Node ptrOne = first;
            Node ptrTwo = first.next;
            Node ptrTwoNext = ptrTwo.next;

            ptrOne.next = ptrTwoNext;

            if(ptrOne_prev != null) {
                ptrOne_prev.next = ptrTwo;
            } else {
                newFirst = ptrTwo;
            }

            ptrTwo.next = first;
            ptrOne_prev = ptrOne;
            first = ptrTwoNext;
        }

        return newFirst;
    }

    /**
     * Find the length of longest palindrome in a list
     * @param first
     * @return
     */
    public int maxPalindrome(Node first) {
        int result = 0;
        Node prev = null;
        Node curr = first;

        while(curr != null) {
            Node next = curr.next;
            curr.next = prev;
            result = Math.max(result,2*countCommon(prev,next) + 1);
            result = Math.max(result,2*countCommon(curr,next));
            prev = curr;
            curr = next;

        }

        return result;
    }

    private int countCommon(Node a, Node b) {
        int count = 0;
        for(;a!=null && b!= null;a=a.next,b=b.next) {
            /*System.out.println("A : "+a.item+", B: "+b.item);*/
            if(a.item instanceof String) {
                if(((String) a.item).equalsIgnoreCase((String)b.item)) {
                    ++count;
                } else {
                    return count;
                }
            } else {
                if(a.item == b.item) {
                    ++count;
                }
                else return count;
            }
        }

        return count;
    }



    /**
     * Reverse the complete linked list
     * @param first
     */
    public Node reverse(Node first) {
        Node curr = first;
        Node prev = null;
        Node next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        first = prev;
        /*System.out.println(getItems(first));*/
        return prev;
    }


    public Node reverseSubList(Node a, int start,int finish) {
        if(start == finish) {
            return a;
        }

        Node result = a;
        Node head = result;
        //result.setNext(null);
        int k = 1;
        while(k++ < start) {
            head = head.getNext();
        }

        Node next = head.getNext();

        while(start++ < finish) {
            Node temp = next.getNext();
            next.setNext(temp.getNext());
            temp.setNext(head.getNext());
            head.setNext(temp);
        }

        return result;
    }

    /**
     * Get Linked List as string
     * @param first
     * @return
     */
    public String getItems(Node first) {
        StringBuilder s = new StringBuilder();
        Node curr = first;
        while(curr != null) {
            s.append(curr.item + " -> ");
            curr = curr.next;
        }

        s.append("NULL");
        return s.toString();
    }


    /**
     * Reverse K nodes alternatively
     * @param first
     * @param k
     * @return
     */
    public Node reverseAltKNodes(Node first,int k) {
        Node curr = first;
        Node prev = null;
        Node next = null;
        int count = 0;

        // reverse 1st K nodes of list;
        while(count < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        // now move the head which is cur to k+1 node
        if(first != null) {
            first.next = curr;
        }

        count = 0;
        while(count < k-1 && curr != null) {
            curr = curr.next;
            count++;
        }

        // recursive call from curr.next node
        if(curr != null) {
            curr.next = reverseAltKNodes(curr.next,k);
        }

        first = prev;
        System.out.println(getItems(first));
        return first;
    }



    public void swapNodes(Comparable x, Comparable y, Node first) {
        // x and y are same do not swap
        if(x.compareTo(y) == 0) {
            return;
        }

        Node currX = first;
        Node prevX = null;

        // store prevX and currX till we find 1st item
        while(currX != null && currX.getItem().compareTo(x) != 0){
            prevX = currX;
            currX = currX.getNext();
        }

        Node currY = first;
        Node prevY = null;

        // store prevY and currY till we find 2nd item
        while(currY != null && currY.getItem().compareTo(y) != 0){
            prevY = currY;
            currY = currY.getNext();
        }

        // if either of currX or cuurY is null then cannot swap
        if(currX == null || currY == null) {
            return;
        }

        // if prevX is null then make currY is the new head
        // if prevX is not null then set prevX.next to currY
        if(prevX != null) {
            prevX.setNext(currY);
        } else {
            first = currY;
        }

        // if prevY is empty then it is head node so make currX as new head
        // if prevY is not empty then set prevY.next to currX
        if(prevY != null) {
            prevY.setNext(currX);
        } else {
            first = currX;
        }

        // swap currY.next with currX.next
        Node temp = currY.getNext();
        currY.setNext(currX.getNext());
        currX.setNext(temp);
        System.out.println(getItems(first));
    }

    /**
     * Swap Kth node from both end of list ( 1st kth node with kth node from last)
     * @param first
     * @param k
     */
    public void swapKthNode(Node first,int k) {
        int length = getLength(first);
        if(length < k) {
            return;
        }
        
        if(2*k - 1 == length) {
            return;
        }
        
        Node currX = first;
        Node prevX = null;

        for(int i = 1; i < k;i++) {
            prevX = currX;
            currX = currX.getNext();
        }

        Node currY = first;
        Node prevY = null;

        for(int i = 1; i < length - k + 1;i++) {
            prevY = currY;
            currY = currY.getNext();
        }

      /*  if(currX == null || currY == null){
            return;
        }*/

        if(prevX != null) {
          prevX.setNext(currY);
        } else {
            first = currY;
        }

        if(prevY != null) {
            prevY.setNext(currX);
        } else {
            first = currX;
        }

        Node temp = currX.getNext();
        currX.setNext(currY.getNext());
        currY.setNext(temp);
        /*System.out.println("First Node - "+first.getItem());*/
        System.out.println(getItems(first));
    }

    public int getLength(Node a) {
        int count = 0;
        Node h = a;
        while (h != null) {
            count++;
            h = h.next;
        }
        return count;
    }

    /**
     * Merge Sort a linked list
     * @param first
     * @return
     */
    public Node mergeSort(Node first) {
        Node oldFirst = first;
        int mid = getLength(first)/2;
        if(first.next == null) {
            return first;
        }

        //find new head for second sublist
        while(mid-1 > 0) {
            oldFirst = oldFirst.next;
            mid--;
        }

        Node newFirst = oldFirst.next;
        // break 1st list
        oldFirst.next = null;
        //move back pointer to first node
        oldFirst = first;
        Node t1 = mergeSort(oldFirst);
        Node t2 = mergeSort(newFirst);
        return mergeList(t1,t2);
    }

    public Node mergeList(Node a, Node b) {

        Node result = null;
        if(a == null) {
            return b;
        }

        if(b == null) {
            return a;
        }

        if(((Integer)a.item) > ((Integer)b.item)) {
            result = b;
            b = b.getNext();
        } else {
            result = a;
            a = a.getNext();
        }

        Node curr = result;

        while(a != null && b != null) {
            if(((Integer)a.item) > ((Integer)b.item)) {
                curr.setNext(b);
                b = b.getNext();

            } else {
                curr.setNext(a);
                a = a.getNext();
            }

            curr = curr.getNext();
        }



        curr.setNext(a != null ? a : b);

        /*if(((Integer)a.item) > ((Integer)b.item)) {
            result = b;
            result.next = mergeList(a,b.next);
        } else {
            result = a;
            result.next = mergeList(a.next,b);
        }*/

        return result;
    }

    /**
     * Find loop in a linked list , loop length and break the loop
     */
    public void findLoop(Node first) {
        Node a = first;
        Node b = first.next.next;

        while(a != null) {
            if(a != b) {
                a = a.next;
                b = b.next.next;
            } else {
                System.out.println("loop starts at - "+a.item);
                int length = findLoopLength(a,b);
                System.out.println("length of loop - "+length);
                breakLoop(a,b);
                break;
            }
        }
    }

    private int findLoopLength(Node a, Node b) {
        int loopLength = 1;
        a = a.next;
        while(a != b) {
            a = a.next;
            loopLength++;
        }

        return loopLength;
    }

    private void breakLoop(Node a, Node b){
        a = a.next;
        while(a.next !=b) {
            a = a.next;
        }
        a.next = null;
    }

    public void displayLoop(Node first){
        System.out.println("");
        Node currNode = first;
        int cnt = 15;
        while(cnt!=0){
            System.out.print("->" + currNode.item);
            currNode=currNode.next;
            cnt--;
        }
    }

    private Node hasCycle(Node first) {
        Node slow = first;
        Node fast = first;

        while(fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) { // there is a cycle
                slow = first;
                while(slow != fast) {
                    slow = slow.next;
                    first = first.next;
                }

                return slow;
            }
        }
        return null;
    }

    public Node overlappingListNoCycle(Node l1,Node l2) {
        int l1Length = length(l1);
        int l2Length = length(l2);

        if(l1Length > l2Length) {
            l1 = advanceByK(l1Length - l2Length,l1);
        } else {
            l2 = advanceByK(l2Length - l1Length,l2);
        }

        while(l1 != null && l2 != null && l1.getItem().compareTo(l2.getItem()) != 0) {
            l1 = l1.next;
            l2 = l2.next;
        }

        return l1;
    }

    private  Node advanceByK(int k, Node l) {
        while(k-- > 0) {
            l = l.next;
        }

        return l;
    }

    private  int length(Node l) {
        int len = 0;

        while(l != null) {
            len++;
            l = l.next;
        }

        return len;
    }


    public Node overlappingLists(Node l1, Node l2) {

        Node root1 = hasCycle(l1);
        Node root2 = hasCycle(l2);

        // there are no cycles in both list so call overlapping List No Cycle
        if(root1 == null && root2 == null) {
            return overlappingListNoCycle(l1,l2);
        }


        // One has cycle and other has no cycle then there is no overlap
        if((root1 != null && root2 == null) ||
                (root1 == null && root2 != null)) {
            return null;
        }

        Node temp = root2;
        do {
            temp = temp.next;
        } while(temp != root1 && temp != root2);

        // l1 and l2 do not end in same cycle
        if(temp != root1) {
            return null;
        }

        int distance1 = distance(l1,root1);
        int distance2 = distance(l2,root2);

        if(distance1 > distance2) {
            l1 = advanceByK(distance1 - distance2, l1);
        } else {
            l2 = advanceByK(distance2 - distance1,l2);
        }

        while(l1 != l2 && l1 != root1 && l2 != root2) {
            l1 = l1.next;
            l2 = l2.next;
        }

        // if l1 == l2 before reaching root1 it means overlap happens before the cycle starts;
        // otherwise , the first overlapping node is not unique, so we can return any node on the cycle.
        return l1 == l2 ? l1 : root1;
    }

    private int distance(Node a,Node b) {
        int dist = 0;
        while(a != b) {
            dist++;
            a = a.next;
        }

        return dist;
    }

    public Node removeKthLast(Node head,int k) {
        Node curr = head;
        while(k-- > 0) {
            curr = curr.next;
        }
        Node second = head;
        while(curr.next != null) {
            curr = curr.next;
            second = second.next;
        }

        second.next = second.next.next;

        return head;
    }

    public Node removeDuplicatesFromSortedList(Node first) {
        Node curr = first;
        while(curr != null) {
            Node next = curr.next;
            while(next != null && next.getItem().compareTo(curr.getItem()) == 0) {
                next = next.next;
            }
            curr.next = next;
            curr = next;
        }

        return first;
    }

    public Node removeDuplicatesFromSortedList(Node first,int k) {

        Node curr = first;
        Node prev = curr;
        while(curr != null) {
            Node next = curr.next;
            int count = 1;
            while(next != null && next.getItem().compareTo(curr.getItem()) == 0) {
                next = next.next;
                count++;
            }

            if(count >= k) {
                if(first.getItem().compareTo(curr.getItem()) == 0) {
                    first = next;
                    curr = next;
                    prev = curr;
                } else {
                    prev.next = next;
                    curr = next;
                }
            } else {
                prev = curr;
                curr = curr.next;
            }



        }

        return first;
    }

    public Node cyclicallyRightShift(Node first,int k) {
        if(first == null) {
            return first;
        }

        //find length and tail node;
        Node tail = first;
        int n = 1;
        while(tail.next != null) {
            n++;
            tail = tail.next;
        }
        // if k > n
        k = k % n;
        if(k == 0) {
            return first;
        }

        // create a cycle
        tail.next = first;
        // move by n - k with new tail
        int step = n - k ;
        Node newTail = tail;
        while(step-- > 0) {
            newTail = newTail.next;
        }

        // head becomes new tails next
        // new tails next is null after breaking the cycle
        Node newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }

    public Node evenOdd(Node first) {
        if(first == null) {
            return first;
        }

        Node odd = first;
        Node even = first.next;
        Node evenHead = even;
        while(true) {
            if(odd == null ||
                    even == null ||
                    even.next == null) {
                odd.next = evenHead;
                break;
            }

            // connect odd nodes by setting odd next to even next
            // move odd to even next
            odd.next = even.next;
            odd = even.next;

            // if there are no even nodes after current odd
            // even = odd.next
            if(odd.next == null) {
                even.next = null;
                odd.next = even.next;
                break;
            }

            //connect even nodes
            // odd.next is even node
            // move even to odd next which is even
            even.next = odd.next;
            even = odd.next;
        }

        return first;
    }

    public boolean isPalindrome(Node first) {
        Node slow = first;
        Node fast = first;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node firstHalf = first;
        Node secondHalf = reverse(slow);

        while(firstHalf != null && secondHalf != null) {
            if(firstHalf.getItem().compareTo(secondHalf.getItem()) != 0) {
                return false;
            }

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }


        return true;
    }

    public Node partition(Node first,int x) {
        Node smallerHead = null, smallerTail = null;
        Node greaterHead = null, greaterTail = null;
        Node equalHead = null, equalTail = null;

        while(first != null) {
            Integer data = (Integer)first.getItem();

            if(data == x) {
                if(equalHead == null) {
                    equalHead = equalTail = first;
                } else {
                    equalTail.next = first;
                    equalTail = equalTail.next;
                }
            } else if( data < x) {
                if(smallerHead == null) {
                    smallerHead = smallerTail = first;
                } else {
                    smallerTail.next = first;
                    smallerTail = first;
                }
            } else {
                if(greaterHead == null) {
                    greaterHead = greaterTail = first;
                } else {
                    greaterTail.next = first;
                    greaterTail = first;
                }
            }

            first = first.next;
        }

        // set greaterTail next to null if greater has nodes
        if(greaterTail != null) {
            greaterTail.next = null;
        }

        // if smaller list is empty
        if(smallerHead == null) {
            // if equal is also empty then return greater
            if(equalHead == null) {
                return greaterHead;
            }

            // set equal next to greater head and return equal head
            equalTail.next = greaterHead;
            return equalHead;
        }

        //if equal list is empty
        if(equalHead == null) {
            // condition is already checked before
           /* if(smallerHead == null) {
                return greaterHead;
            }*/

            smallerTail.next = greaterHead;
            return smallerHead;
        }

        // if both equal and smaller list are not empty
        smallerTail.next = equalHead;
        equalTail.next = greaterHead;
        return smallerHead;
    }

    public Node addTwoNumbers(Node l1,Node l2) {
        Node p1 = reverse(l1);
        Node p2 = reverse(l2);
        Node result = null;
        Node head = null;
        int carry = 0;

        while(p1 != null || p2 != null) {
            int sum = carry;
            if(p1 != null) {
                sum += (Integer)p1.getItem();
                p1 = p1.next;
            }

            if(p2 != null) {
                sum += (Integer)p2.getItem();
                p2 = p2.next;
            }

            if(result == null) {
                LinkedStack stack = new LinkedStack();
                result = stack.new Node(sum%10,null);
                head = result;
            } else {
                LinkedStack stack = new LinkedStack();
                result.next = stack.new Node(sum%10,null);
                result = result.next;
            }
            carry = sum/10;
        }

        if(carry > 0) {
            LinkedStack stack = new LinkedStack();
            result.next = stack.new Node(carry,null);
        }


        return reverse(head);
    }
}
