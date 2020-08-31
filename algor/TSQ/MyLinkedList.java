package algor.TSQ;

import java.util.Iterator;

/**
 * 双向链表的简单实现
*/
public class MyLinkedList<AnyType> implements Iterator<AnyType>{
    

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
}