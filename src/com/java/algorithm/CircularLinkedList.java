package com.java.algorithm;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * Created by Mihir.Desai on 3/23/2017.
 */
public class CircularLinkedList<T> {
    private Node first;
    private Node last;
    int n = 0;

    public class  Node {
        Node next;
        T item;

        public Node(T item) {
            this.item = item;
        }

    }

    public int size() { return n;}

    public void add(T item) {
        Node n = new Node(item);

        if(this.n == 0) {
            first = n;
            last = n;
            n.next = first;
        } else {
            n.next = first;
            first = n;
            last.next = first;
        }
        this.n++;
    }

    public void addAtEnd(T item) {
        Node n = new Node(item);

        if(this.n == 0) {
           add(item);
        } else {
            last.next = n;
            last = n;
            last.next = first;
        }
        this.n++;
    }

    public void addAfter(T item,int index) {
        Node prev = elementAt(index);
        if(prev == null) {
            throw new NoSuchElementException("Node cannot be empty");
        }

        if(prev == last) {
            addAtEnd(item);
            return;
        }

        Node n = new Node(item);
        Node next = prev.next;
        n.next = next;
        prev.next = n;
        this.n++;
    }

    public void delete() {
        if(this.n == 0) {
            throw new EmptyStackException();
        }

        first = first.next;
        last.next = first;
        n--;
    }

    public void deleteFromEnd() {
        if(this.n == 0) {
            throw new EmptyStackException();
        }

        if(this.n == 1) {
            delete();
        }

        Node temp = elementAt(n-1);
        last = temp;
        last.next = first;
        this.n--;
    }

    private Node elementAt(int index) {
        if(index > n) {
            throw new NoSuchElementException("No element found at index "+index);
        }

        Node n = first;
        while(index-1 != 0) {
            n = n.next;
            index--;
        }
        return n;
    }

    public void print() {
        StringBuilder s = new StringBuilder();
        Node curr = first;
        do {
            s.append(curr.item + " -> ");
            curr = curr.next;
        } while(curr != first);

        s.append(first.item);
        System.out.println(s.toString());
    }



    public static void main(String[] args) {
        CircularLinkedList<Integer> d = new CircularLinkedList();
        d.add(2);
        d.add(1);
        d.addAtEnd(3);
        d.addAfter(4,2);
        d.print();
       /* d.delete();
        d.print();
        d.add(1);
        d.print();
        d.deleteFromEnd();
        d.print();*/
        System.out.println("Size of the Linked List: " + d.size());
    }
}
