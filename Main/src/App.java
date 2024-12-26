import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N개의 명령어
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> arr = new LinkedList<>();
        // 큐에 숫자
        for (int i = 0; i < N; i++) {
            String[] instruction = br.readLine().split(" ");
            if (instruction.length == 2 && instruction[0].equals("1")) {
                arr.offerFirst(Integer.parseInt(instruction[1]));
            } else if (instruction.length == 2 && instruction[0].equals("2")) {
                arr.offerLast(Integer.parseInt(instruction[1]));
            } else if (instruction[0].equals("3")) {
                int ans = arr.size() != 0 ? arr.poll() : -1;
                System.out.println(ans);
            } else if (instruction[0].equals("4")) {
                int ans = arr.size() != 0 ? arr.pollLast() : -1;
                System.out.println(ans);
            } else if (instruction[0].equals("5")) {
                System.out.println(arr.size());
            } else if (instruction[0].equals("6")) {
                int ans = arr.isEmpty() ? 1 : 0;
                System.out.println(ans);
            } else if (instruction[0].equals("7")) {
                int ans = arr.size() != 0 ? arr.peek() : -1;
                System.out.println(ans);
            } else if (instruction[0].equals("8")) {
                int ans = arr.size() != 0 ? arr.peekLast() : -1;
                System.out.println(ans);
            }
        }
    }
}
