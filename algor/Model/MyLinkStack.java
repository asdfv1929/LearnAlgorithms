package algor.Model;

import java.util.Iterator;

/**
 * 栈的链表实现
 * 
*/
public class MyLinkStack<E> implements Iterable<E>{
    private Node first;
    private int elementCount;   // 元素数量
    public class Node {
        E val;
        Node next;
    }

    public boolean isEmpty() { return first == null; }

    public int size() { return elementCount; }

    // 入栈，新建结点，将其next指针指向原first结点，成为新first
    public void push(E item) {
        Node oldFirst = first;
        first = new Node();
        first.val = item;
        first.next = oldFirst;
        elementCount++;
    }

    // 出栈
    public E pop() {
        E item = first.val;
        first = first.next;
        elementCount--;
        return item;
    }

    public void print() {
        for (Node curr = first; curr != null; curr = curr.next) {
            System.out.print(curr.val + " ");
        }
        System.out.println();
    }

    public Iterator iterator() { return new listIterator(); }
    private class listIterator implements Iterator<E> {
        private Node current = first;
        public boolean hasNext() { return current != null; }
        public E next() {
            E item = current.val;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        MyLinkStack<Integer> stack = new MyLinkStack<>();
        stack.push(12);
        stack.push(5);
        stack.push(7);
        stack.push(1);
        stack.push(9);
        stack.print();

        stack.pop();
        stack.print();
        // 9 1 7 5 12
        // 1 7 5 12
    }
}