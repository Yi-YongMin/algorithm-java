import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N장의 카드
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> arr = new LinkedList<>();
        // 큐에 숫자
        for (int i = 0; i < N; i++) {
            arr.add(i + 1);
        }

        while (arr.size() != 1) {
            arr.poll();
            if (arr.size() == 1)
                break;
            arr.add(arr.poll());
        }
        System.out.println(arr.poll());
    }
}
