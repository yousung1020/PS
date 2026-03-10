import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        // 컴퓨터의 수만큼 인접리스트 생성
        ArrayList<Integer>[] adj = new ArrayList[n + 1];

        int edges = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());

            adj[u].add(v);
            adj[v].add(u);
        }

        boolean[] isVisit = new boolean[n + 1];
        Queue<Integer> deque = new ArrayDeque<>();
        int count = 0;

        // 1번 컴퓨터부터 시작하므로
        isVisit[1] = true;
        deque.add(1);

        while (!deque.isEmpty()) {
            int current = deque.poll();

            for (int nei: adj[current]) {
                if (!isVisit[nei]) {
                    deque.add(nei);
                    isVisit[nei] = true;
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}