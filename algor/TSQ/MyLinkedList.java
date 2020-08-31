package algor.TSQ;

import java.util.Iterator;

/**
 * 双向链表的简单实现
*/
public class MyLinkedList<AnyType> implements Iterator<AnyType>{
    private int size;
    private Node<AnyType> head;
    private Node<AnyType> tail;
    private int modCount;

    private static class Node<AnyType> {
        public AnyType data;
        public Node<AnyType> prev;
        public Node<AnyType> next;

        public Node(AnyType d, Node<AnyType> p, Node<AnyType> n) {
            data = d;
            prev = p;
            next = n;
        }
    }

    public MyLinkedList() {
        clear();
    }

    // 初始化空链表
    public void clear() {
        head = new Node<AnyType>(null, null, null);
        tail = new Node<AnyType>(null, head, null);
        head.next = tail;

        size = 0;
        modCount++;
    }

    public int size() { return size; }

    public boolean isEmpty() { return size() == 0; }

    public boolean add(AnyType x) {
        add(size(), x);
        return true;
    }
    public void add(int idx, AnyType x) {

    }

    public void addBefore(Node<AnyType> p, AnyType x) {
        Node<AnyType> newNode = new Node<>(x, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        size++;
        modCount++;
    }

    public AnyType get(int idx) {
        return getNode(idx).data;
    }
    private Node<AnyType> getNode(int idx) {
        return getNode(idx, 0, size()-1);
    }
    private Node<AnyType> getNode(int idx, int lower, int upper) {
        Node<AnyType> p;
        if (idx < lower || idx > upper) {
            throw new IndexOutOfBoundsException();
        }

        if (condition) {
            
        }
    }

    public AnyType set(int idx, AnyType val) {}

    public AnyType remove(Node<AnyType> p) {
        p.next.prev = p.prev;
        p.prev.next = p.next;
        size--;
        modCount++;

        return p.data;
    }

}