package algor.Ch03Search;


import java.util.Queue;
import java.util.LinkedList;

/**
 * 顺序查找
 * 基于无序链表
*/
public class SequentialSearchST<Key, Value> {
    // 链表首结点
    private Node first;
    private int n;
    // 链表结点的定义
    private class Node {
        Key key;
        Value val;
        Node next;
        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key) {
        // 查找给定键，返回相应值
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;
            }
        }
        return null;
    }

    public void put(Key key, Value val) {
        // 查找给定键，找到并更新，否则新建结点
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        // 新结点的next指向旧的首结点，成为新首结点
        first = new Node(key, val, first);
        n++;
    }

    public boolean contains(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return true;
            }
        }
        return false;
    }

    public Integer size() {
        return n;
    }
    // 将所有键放入队列中
    public Iterable<Key> keys() {
        Queue<Key> queue = new LinkedList<>();
        for (Node x = first; x != null; x = x.next) {
            queue.add(x.key);
        }
        return queue;
    }

    // 删除指定键值
    public void delete(Key key) {
        first = delete(first, key);
    }
    // 删除指定键值
    // 先判断是否为空
    // 后判断待删除键值是否为链表中当前结点，若是，则数量减1，前结点指向待删除结点的next结点，即为删除链表中当前结点
    // 若不是当前结点，则继续递归，去遍历查找链表中指定键值对结点
    public Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }
        if (node.key.equals(key)) {
            n--;
            return node.next;
        }
        node.next = delete(node.next, key);
        return node;
    }
}


class Test{
    public static void main(String[] args) {
        SequentialSearchST<Integer, String> st = new SequentialSearchST<>();
        st.put(2, "ceshi");
        st.put(4, "haha");
        System.out.println(st.keys());
    }
}