import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // N명이라는 입력 받기
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        // N명 숫자 입력
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        // 옆줄로 빠질 Stack
        Stack<Integer> stack = new Stack<>();

        // ans = 1일때 nice 출력
        int ans = 1;

        // 현재 순서가 N이 아니면 계속 돌기
        for (int i = 0; i < N; i++) {
            if (arr.get(i) == i + 1) {
                continue;
            }
            if (stack.size() != 0) {
                // 1. 스택이 존재하고 , top이 cnt 면 pop
                if (stack.peek() == i + 1) {
                    stack.pop();
                } else {// 2. 스택이 존재하고 , top이 cnt 아니면
                    if (stack.peek() < arr.get(i)) {
                        System.out.println("Sad");
                        ans = 0;
                        break;
                    } else {
                        stack.push(i + 1);
                    }
                }
            } else {// 스택이 존재하지 않고 , 줄 첫번째도 cnt가 아니니 푸쉬
                stack.push(arr.get(i));
            }
        }
        if (ans == 1)
            System.out.println("Nice");
    }
}
