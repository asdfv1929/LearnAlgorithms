package algor.Graph;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class BFS {
    private boolean[] marked;    //标记该定点是否已调用过dfs()
    private int[] edgeTo;        //从起点到一个顶点的已知路径上的最后一个顶点
    private final int s;          //起点

    public BFS(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new PriorityQueue<>();
        marked[s] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v; 
                    marked[w] = true;
                    queue.add(w); 
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) 
            path.push(x);
        path.push(s);
        return path;
    }
}