import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // front, rear를 구현해야 함
        int n = Integer.parseInt(reader.readLine()), front = -1, rear = -1;

        int[] queue = new int[n];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String command = tokenizer.nextToken();

            if (command.equals("push")) {
                queue[++rear] = Integer.parseInt(tokenizer.nextToken());
            } else if (command.equals("front")) {
                if (front == rear) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(queue[front + 1]).append("\n");
                }
            } else if (command.equals("back")) {
                if (front == rear) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(queue[rear]).append("\n");
                }
            } else if (command.equals("pop")) {
                if (front == rear) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(queue[++front]).append("\n");
                }
            } else if (command.equals("empty")) {
                if (front == rear) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            } else if (command.equals("size")) {
                sb.append(rear - front).append("\n");
            }
        }

        System.out.println(sb);
    }
}