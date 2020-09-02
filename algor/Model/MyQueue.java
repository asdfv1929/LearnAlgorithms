package algor.Model;

public class MyQueue<E> {
    private Node first;
    private Node last;
    private int n;
    private class Node {
        E item;
        Node next;
    }

    public boolean isEmpty() { return first == null; }
    public int size() { return n; }

    public void enqueue(E item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
        n++;
    }

    public E dequeue() {
        E item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        n--;
        return item;
    }

    public void print() {
        for (Node curr = first; curr != null; curr = curr.next) {
            System.out.print(curr.item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(12);
        queue.enqueue(5);
        queue.enqueue(7);
        queue.enqueue(9);
        queue.enqueue(1);
        queue.print();

        queue.dequeue();
        queue.print();
    }

}