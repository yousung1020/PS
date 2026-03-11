import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = reader.readLine();
        }

        Arrays.sort(words, (i1, i2) -> {
            if (i1.length() != i2.length()) {
                return i1.length() - i2.length();
            } else {
                return i1.compareTo(i2);
            }
        });

        StringBuilder sb = new StringBuilder();
        sb.append(words[0]).append("\n");

        for (int i = 1; i < n; i++) {
            if (!words[i].equals(words[i - 1])) {
                sb.append(words[i]).append("\n");
            }
        }

        System.out.println(sb);
    }
}