package BOJ;

import java.io.*;
import java.util.Arrays;

public class BOJ2751 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int oneLine = Integer.parseInt(reader.readLine());

        int[] arr = new int[oneLine];

        for(int i = 0; i < oneLine; i++){
            arr[i] =  Integer.parseInt(reader.readLine());
        }

        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr);
        for(int i = 0; i < oneLine; i++){
            sb.append(arr[i]).append('\n');
        }

        System.out.print(sb);  // '\n'이 다 들어가 있으니까 println이 아니라 print도 OK

    }
}
