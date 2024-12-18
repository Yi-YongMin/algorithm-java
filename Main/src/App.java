import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        int K = Integer.parseInt(bf.readLine());
        int N;
        int sum = 0;
        for (int i = 0; i < K; i++) {
            N = Integer.parseInt(bf.readLine());
            if (N == 0) {
                stack.pop();
            } else {
                stack.push(N);
            }
        }
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}
