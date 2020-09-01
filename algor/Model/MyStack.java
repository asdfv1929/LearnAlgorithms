package algor.Model;

import java.util.EmptyStackException;
import java.util.Iterator;

public class MyStack<E> implements Iterable<E>{
    private E[] elementData;        // 栈元素
    private int elementCount = 0;   // 元素数量

    public MyStack() {
        this.elementData = (E[]) new Object[1];
    }

    // 调整大小
    private void resize(int newCapacity) {
        E[] temp = (E[]) new Object[newCapacity];
        for (int i = 0; i < elementCount; i++) {
            temp[i] = elementData[i];
        }
        elementData = temp;
    }

    public E push(E item) {
        addElement(item);
        return item;
    }
    private synchronized void addElement(E obj) {
        if (elementCount == elementData.length) {
            resize(2 * elementData.length);
        }
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
        if (elementCount > 0 && elementCount == elementData.length/4) {
            resize(elementData.length/2);
        }
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

    public Iterator<E> iterator() {
        return new ReverseArrayIterator();
    }
    private class ReverseArrayIterator implements Iterator<E> {
        private int i = elementCount;
        public boolean hasNext() { return i > 0; }
        public E next() { return elementData[--i]; }
        public void remove() { }
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(2);
        stack.push(5);
        stack.push(11);
        stack.push(7);
        stack.push(1);
        stack.push(8);
        stack.print();
        stack.pop();
        stack.print();
    }
    
}