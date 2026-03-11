import java.io.*;
public class Main {
    public static void main(String[] args) {
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))){
            int n = Integer.parseInt(bf.readLine());

            int count = 0, num = 0;
            while(true){
                if(String.valueOf(num).contains("666")) {
                    count++;
                }
                if (n == count) {
                    break;
                }
                num++;
            }
            System.out.println(num);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}