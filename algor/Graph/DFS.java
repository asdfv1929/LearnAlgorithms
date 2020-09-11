package algor.Graph;

import java.util.Stack;

/**
 * 使用深度优先搜索查找图中的路径
 * 
*/
public class DFS {
    private boolean[] marked;    //标记该定点是否已调用过dfs()
    private int[] edgeTo;        //从起点到一个顶点的已知路径上的最后一个顶点
    private final int s;          //起点

    public DFS(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        //当前结点标记为 true，已访问
        //遍历当前结点的各个邻居结点
        for (int w : G.adj(v)) {
            //若未标记（未访问）
            if (!marked[w]) {
                edgeTo[w] = v; //从起点到当前邻居结点的路径上最后一个结点
                dfs(G, w);     //递归该邻居结点
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