package algor.Search;

/**
 * 红黑树
*/
public class RedBlackTree<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    // 红黑树的结点表示
    private class Node {
        Key key;
        Value val;
        Node left, right;
        int N;
        boolean color;

        Node(Key key, Value val, int N, boolean color) {
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    // 左旋转
    Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }
    // 右旋转
    Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    // 颜色转换
    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public int size() { return size(root); }
    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }
    // 查找key，找到则更新其值，否则新建一个结点
    public void put(Key key, Value val) {
        root = put(root, key, val);
        root.color = BLACK;
    }
    private Node put(Node h, Key key, Value val) {
        if (h == null) return new Node(key, val, 1, RED);
        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else h.val = val;
        // 右链接为红，左链接黑，此时左旋转
        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        // 左链接为红，左子结点的左链接为空，为连续的两条红色链接情况，
        // 此时需右旋转
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        // 左链接为红，右链接为红，此时颜色转换
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    private Node moveRedLeft(Node h) {
        flipColors(h);
        if (isRed(h.right.left)) {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
        }
        return h;
    }

    public Node balance(Node h) {
        if (isRed(h.right)) h = rotateLeft(h);

        // 右链接为红，左链接黑，此时左旋转
        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        // 左链接为红，左子结点的左链接为空，为连续的两条红色链接情况，
        // 此时需右旋转
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        // 左链接为红，右链接为红，此时颜色转换
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    public void deleteMin() {
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;
        root = deleteMin(root);
        if (!isEmpty()) root.color = BLACK;
    }
    private Node deleteMin(Node h) {
        if (h.left == null) return null;
        if (!isRed(h.left) && !isRed(h.left.left))
            h = moveRedLeft(h);
        h.left = deleteMin(h.left);
        return balance(h);
    }

    public void delete(Key key) {
        if (!isRed(root.left) && !isRed(h.right))
            root.color = RED;
        root = delete(root, key);
        if (!isEmpty()) root.color = BLACK;
    }
    private Node delete(Node h, Key key) {

    }
}