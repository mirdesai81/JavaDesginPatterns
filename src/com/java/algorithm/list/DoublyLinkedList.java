package com.java.algorithm.list;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * Created by Mihir.Desai on 3/23/2017.
 */
public class DoublyLinkedList<T> {
    private Node first;
    private Node last;
    int n = 0;

    public class  Node {
        Node prev;
        Node next;
        T item;

        public Node(T item) {
            this.item = item;
            prev = null;
            next = null;
        }

    }

    public int size() { return n;}

    public void add(T item) {
        Node n = new Node(item);

        if(this.n == 0) {
            first = n;
            last = n;
        } else {
            n.next = first;
            first.prev = n;
            first = n;
        }
        this.n++;
    }

    public void addAtEnd(T item) {
        Node n = new Node(item);

        if(this.n == 0) {
            first = n;
            last = n;
        } else {
            last.next = n;
            n.prev = last;
            last = n;
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

        next.prev = n;
        n.prev = prev;

        this.n++;
    }

    public void delete() {
        if(this.n == 0) {
            throw new EmptyStackException();
        }

        first = first.next;
        n--;
    }

    public void deleteFromEnd() {
        if(this.n == 0) {
            throw new EmptyStackException();
        }

        if(this.n == 1) {
            delete();
        }

        Node prev = last.prev;
        last = prev;
        prev.next = null;
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
        while(curr != null) {
            s.append(curr.item + " <-> ");
            curr = curr.next;
        }

        s.append("NULL");
        System.out.println(s.toString());
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> d = new DoublyLinkedList();
        d.add(2);
        d.add(1);
        d.addAtEnd(3);
        d.addAfter(4,2);
        d.print();
        d.delete();
        d.print();
        d.add(1);
        d.print();
        d.deleteFromEnd();
        d.print();
        System.out.println("Size of the Linked List: " + d.size());
    }
}
