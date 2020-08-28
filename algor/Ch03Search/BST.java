package algor.Ch03Search;

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
    public Value get(Node x, Key key)  {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }

    public void put(Key key, Value val) {
        root =  put(root, key, val);
    }
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
    public int rank() {}
    public void delete() {}
    public Key[] keys() {}

}