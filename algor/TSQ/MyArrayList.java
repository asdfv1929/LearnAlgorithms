package algor.TSQ;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * ArrayList的简单实现
 * @param <AnyType>
*/
public class MyArrayList<AnyType> implements Iterable<AnyType> {
    private final int DEFAULT_CAPACITY = 10;
    private int n;
    private AnyType[] items;

    public MyArrayList() {
        init();
    }

    // 初始化，创建初始容量的数组
    private void init() {
        n = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    // 针对传入的新容量值，创建新数组
    public void ensureCapacity(int newCapacity) {
        if (newCapacity < n) return;
        AnyType[] oldItem = items;
        items = (AnyType[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            items[i] = oldItem[i];
        }
    }

    public AnyType get(int idx) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return items[idx];
    }

    public AnyType set(int idx, AnyType val) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        AnyType old = items[idx];
        items[idx] = val;
        return old;
    }

    public int size() {
        return n;
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    public void clear() {
        init();
    }

    // 在数组末尾插入新值
    public boolean add(AnyType x) {
        add(size(), x);
        return true;
    }
    // 在指定位置插入值
    // 1.判断数组是否已满
    // 2.将指定位置后的数据后移一位，空出该位置
    // 3.插入数据，数量加1
    public void add(int idx, AnyType x) {
        if (items.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }
        for (int i = n; i > idx; i--) {
            items[i] = items[i-1];
        }
        items[idx] = x;
        n++;
    }

    // 1.将待删除数值赋给临时变量，最后返回其值
    // 2.将目标值后面的数据依次往前进一格，以达到删除效果
    // 3.数量减1，并返回指定值
    public AnyType remove(int idx) {
        AnyType deleteItem = items[idx];
        for (int i = idx; i < size() - 1; i++) {
            items[i] = items[i + 1];
        }
        n--;
        return deleteItem;
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            System.out.print(items[i] + " ");
        }
        // for (AnyType anyType : items) {
        //     System.out.print(anyType + " ");
        // }
        System.out.println();
    }

    // 实现Iterator方法
    public Iterator<AnyType> iterator() {
        return new ArrayListIterator();
    }
    private class ArrayListIterator implements Iterator<AnyType> {
        private int current = 0;
        
        public boolean hasNext() {
            return current < size();
        }

        public AnyType next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return items[current++];
        }

        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }


    public static void main(String[] args) {
        MyArrayList<Integer> array = new MyArrayList<>();
        array.add(10);
        array.add(23);
        array.add(32);
        array.add(41);
        array.add(55);
        array.print();
    }

}