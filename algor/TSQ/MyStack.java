package algor.TSQ;

import java.util.EmptyStackException;

public class MyStack<E> {
    private Object[] elementData;
    private int elementCount = 0;

    public MyStack() {
        this.elementData = new Object[10];
    }

    public E push(E item) {
        addElement(item);
        return item;
    }
    private synchronized void addElement(E obj) {

        elementData[elementCount++] = obj;
    }

    public E pop() {
        E obj;
        int len = size();
        
        obj = peek();
        removeElementAt(len - 1);
        return obj;
    }

    public synchronized void removeElementAt(int index) {
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " + elementCount);
        }
        else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        for (int i = index; i < elementCount - 1; i++) {
            elementData[i] = elementData[i+1];
        }
        elementCount--;
        elementData[elementCount] = null;
    }
    @SuppressWarnings("unchecked")
    public synchronized E peek() {
        int len = size();
        if (len == 0) {
            throw new EmptyStackException();
        }
        return (E) elementData[len - 1];
    }

    public synchronized int size() { return elementCount; }

    public boolean isEmpty() {
        return size() == 0;
    }

    // public synchronized int search() {}

    public void print() {
        for (int i = 0; i < elementCount; i++) {
            System.out.print(elementData[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(2);
        stack.push(5);
        stack.push(11);
        stack.push(7);
        stack.print();
        stack.pop();
        stack.print();
    }
    
}