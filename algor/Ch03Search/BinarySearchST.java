package algor.Ch03Search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 基于有序数组的二分查找
 * 
*/
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private static final int INIT_CAPACITY = 2;
    private Key[] keys;
    private Value[] vals;
    private int n = 0;

    public BinarySearchST() {
        this(INIT_CAPACITY);
    }
    @SuppressWarnings("unchecked")
    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }
    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        Key[] tmpk = (Key[]) new Comparable[capacity];
        Value[] tmpv = (Value[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            tmpk[i] = keys[i];
            tmpv[i] = vals[i];
        }
        keys = tmpk;
        vals = tmpv;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        return get(key) != null;
        }

    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            return vals[i];
        } 
        return null;
    }

    /**
     * 基于有序数组的二分查找（迭代）
     */ 
    public int rank(Key key) {
        int lo = 0; 
        int hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            }
            else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    /**
     * 递归的二分查找
    */
    public int rank(Key key, int lo, int hi) {
        if (hi < lo) {
            return lo;
        }
        int mid = lo + (hi - lo) / 2;
        int cmp = key.compareTo(keys[mid]);
        if (cmp < 0) {
            return rank(key, lo, mid-1);
        }
        else if (cmp > 0) {
            return rank(key, mid+1, hi);
        }
        else {
            return mid;
        }
    }

    public void put(Key key, Value val) {
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            vals[i] = val; return;
        }

        if (n == keys.length) {
            resize(2 * keys.length);
        }

        for (int j = n; j > i; j--) {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key; vals[i] = val;
        n++;
    }

    public void delete(Key key) {
        int i = rank(key);
        if (i == n || keys[i].compareTo(key) != 0) {
            return;
        }
        for (int j = i; j < n-1; j++) {
            keys[j] = keys[j+1];
            vals[j] = vals[j+1];
        }
        n--;
        keys[n] = null;
        vals[n] = null;

        if (n > 0 && n == keys.length / 4) {
            resize(keys.length / 2);
        }
    }

    public Key min() {
        return keys[0];
    }
    public Key max() {
        return keys[n-1];
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new LinkedList<Key>();
        if (lo.compareTo(hi) > 0) return queue;
        for (int i = rank(lo); i < rank(hi); i++){
            queue.add(keys[i]);
        }
        if (contains(hi)) {
            queue.add(keys[rank(hi)]);
        }
        return queue;
    }

    public static void main(String[] args) { 
        BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>();
        Scanner scan = new Scanner(System.in);
        Integer k = 0;
        while (!scan.hasNext("end")) {
            String key = scan.nextLine();
            st.put(key, k);
            k++;
        }
        scan.close();
        // for (int i = 0; i < st.size(); i++)
        //     System.out.println(st.keys[i]);
        System.out.print(st.vals[0]);
    }
}