/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortedlist;

import java.util.NoSuchElementException;

/**
 *
 * @author samda
 */
public class SortedLinkedList<E extends Comparable<E>> implements SortedList<E> {
    private int size=0;
    private class Node {
        E val;
        Node next;
        public Node(E val) {
            this.val=val;
        }
    }
    private Node head;
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return size==0;
    }
    @Override
    public void add(E val) {
        Node node = new Node(val);
        if (size==0){
            head = node;
            size++;
            return;
        }
        if (size==1) {
            if (node.val.compareTo(head.val)<0) {
                node.next=head;
                head = node;
            }
            else head.next=node;
            size++;
            return;
        }
        if (node.val.compareTo(head.val)<0) {
            node.next=head;
            head = node;
            size++;
            return;
        }
        Node current = head;
        while (current.next!=null&&current.next.val.compareTo(node.val)<0) {
            current=current.next;
        }
        node.next = current.next;
        current.next=node;
        size++;
    }
    @Override
    public E getMin() {
        if (isEmpty()) throw new NoSuchElementException();
        return head.val;
    }
    @Override
    public E removeMin() {
        if (isEmpty()) throw new NoSuchElementException();
        E val = head.val;
        head = head.next;
        size--;
        return val;
    }
    @Override
    public String toString() {
        if(isEmpty()){
            return "Empty List";
        }
        StringBuilder res = new StringBuilder();
        Node current = head;
        while(current!=null){
            res.append(current.val).append(" -> ");
            current = current.next;
        }
        res.append("NULL");
        return res.toString();
    }
}