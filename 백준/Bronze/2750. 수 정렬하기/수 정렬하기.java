import java.io.*;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))){
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = Integer.parseInt(bf.readLine());

            int[] arr = new int[n];

            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(bf.readLine());
            }

            for(int i = 0; i < n - 1; i++){
                for(int j = 0; j < n - 1 - i; j++){
                    if(arr[j] > arr[j + 1]){
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }

            for(int i = 0; i < n; i++){
                bw.write(String.valueOf(arr[i]));
                bw.newLine();
            }
            bw.close();
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}