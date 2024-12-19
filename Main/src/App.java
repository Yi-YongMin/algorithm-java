import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int K = Integer.parseInt(bf.readLine());
        for (int i = 0; i < K; i++) {
            int sum = 0;
            String str = bf.readLine();
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '(') {
                    sum += 1;
                } else {
                    sum--;
                }
                if (sum < 0) {
                    break;
                }
            }
            if (sum == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        bw.close();
    }
}
