import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) {
            String[] arr = bf.readLine().split(" ");
            int first = Integer.parseInt(arr[0]);
            int second;
            int top;
            switch (first) {
                case 1:
                    second = Integer.parseInt(arr[1]);
                    stack.push(second);
                    break;
                case 2:
                    top = (stack.isEmpty()) ? -1 : stack.pop();
                    System.out.println(top);
                    break;
                case 3:
                    System.out.println(stack.size());
                    break;
                case 4:
                    int ans = (stack.isEmpty()) ? 1 : 0;
                    System.out.println(ans);
                    break;
                default:
                    top = (stack.isEmpty()) ? -1 : stack.peek();
                    System.out.println(top);
            }
        }
        bf.close();
    }
}
