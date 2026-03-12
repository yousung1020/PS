import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine()), top = -1;
        Integer[] stack = new Integer[n + 1];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String command = tokenizer.nextToken();

            if (command.equals("push")) {
                int pushData = Integer.parseInt(tokenizer.nextToken());
                stack[++top] = pushData;
            } else if (command.equals("pop")) {
                if (top == -1) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(stack[top--]).append("\n");
                }
            } else if (command.equals("size")) {
                sb.append(top + 1).append("\n");
            } else if (command.equals("empty")) {
                if (top == -1) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            } else if (command.equals("top")) {
                if (top == -1) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(stack[top]).append("\n");   
                }
            }
        }

        System.out.println(sb);
    }
}