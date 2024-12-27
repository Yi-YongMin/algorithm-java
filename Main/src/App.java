import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N개의 명령어
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        LinkedList<Integer> arr = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        System.out.println(arr.size());
    }
}
