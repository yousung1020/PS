import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int u = Integer.parseInt(tokenizer.nextToken()); // 정점의 개수
        int v = Integer.parseInt(tokenizer.nextToken()); // 간선의 개수
        int startNode = Integer.parseInt(tokenizer.nextToken()); // 시작 정점

        ArrayList<Integer>[] adj = new ArrayList[u + 1];

        for (int i = 1; i <= u; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= v; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());
            adj[first].add(last);
            adj[last].add(first);
        }

        for (int i = 1; i <= u; i++) {
            Collections.sort(adj[i]);
        }

        // dfs
        StringBuilder sbDfs = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        boolean[] visitedDfs = new boolean[u + 1];
        int[] indexNode = new int[u + 1];

        stack.push(startNode);
        visitedDfs[startNode] = true;
        sbDfs.append(startNode).append(" ");

        while (!stack.isEmpty()) {
            int peekData = stack.peek();
            boolean isMoved = false;

            while (indexNode[peekData] < adj[peekData].size()) {
                int next = adj[peekData].get(indexNode[peekData]);
                indexNode[peekData]++;

                if (!visitedDfs[next]) {
                    stack.push(next);
                    visitedDfs[next] = true;
                    sbDfs.append(next).append(" ");
                    isMoved = true;
                    break;
                }
            }

            if (!isMoved) {
                stack.pop();
            }
        }

        System.out.println(sbDfs);

        // bfs
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] visitedBfs = new boolean[u + 1];
        StringBuilder sbBfs = new StringBuilder();

        queue.add(startNode);
        visitedBfs[startNode] = true;
        sbBfs.append(startNode).append(" ");
        
        while (!queue.isEmpty()) {
            int pollData = queue.poll();

            for (int nei: adj[pollData]) {
                if (!visitedBfs[nei]) {
                    visitedBfs[nei] = true;
                    queue.add(nei);
                    sbBfs.append(nei).append(" ");
                }
            }
        }

        System.out.println(sbBfs);
    }
}