package algor.Model;


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

    public void push(E item) {
        Node oldFirst = first;
        first = new Node();
        first.val = item;
        first.next = oldFirst;
        elementCount++;
    }

    public E pop() {
        E item = first.val;
        first = first.next;
        elementCount--;
        return item;
    }
}