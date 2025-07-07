import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age_1 = scanner.nextInt();
        int age_2 = scanner.nextInt();
        System.out.println(age_1+age_2);

        scanner.close();
    }
}