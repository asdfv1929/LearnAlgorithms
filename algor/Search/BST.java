package algor.Search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉查找树
 * 
*/
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int n;

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            this.n = n;
        }
    }

    public int size() {
        return size(root);
    }
    public int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.n;
        }
    }

    public Value get(Key key) {
        return get(root, key);
    }
    // 递归查找
    // 若树为空，则查找未命中
    // 若被查找的键和根结点的键相等，则查找命中
    // 否则就递归地在子树中继续查找
    // 若被查找的键较小就选择左子树，较大则选择右子树
    public Value get(Node x, Key key)  {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }

    public void put(Key key, Value val) {
        root =  put(root, key, val);
    }
    // 若key存在于以x为根结点的子树中则更新其值
    // 否则以key和val为键值对的新结点插入到该子树中
    public Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key max() {
        return max(root).key;
    }
    private Node max(Node x) {
        if (x.right == null) return x;
        return max(x.right);
    }
    public Key min() {
        return min(root).key;
    }
    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }
    // 查找小于等于key的最大结点
    // 若相等，则返回结点x
    // 若小于，则目标一定在左子树上，递归查找左子树
    // 若大于，则只有当根结点右子树中存在小于等于key的结点时，小于等于key的最大键才会出现在右子树中，
    // 否则根结点就是小于等于key的最大键
    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }

    public Key select(int k) {
        return select(root, k).key;
    }
    private Node select(Node x, int k) {
        if (x == null) return null;
        int t = size(x.left);
        if (t > k) return select(x.left, k);
        else if (t < k) return select(x.right, k-t-1);
        else return x;
    }
//    public int rank() {}

    public void deleteMin() { root = deleteMin(root); }
    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete() {}
    private Node delete(Node x, Key key) {

    }

    public Iterable<Key> keys() { return keys(min(), max()); }
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new LinkedList<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.add(x.key);
        if (cmphi > 0) keys(x.right, queue, lo, hi);
    }

}