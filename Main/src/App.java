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

        int cnt = 1;
        int ans = 1;
        // 깔끔하게 안비어 있으면 계속 돌아라
        while (arr.size() != 0 || !stack.isEmpty()) {
            if (arr.size() != 0) {
                if (arr.get(0) == cnt) {
                    // System.out.println("줄에 순서가 알맞아서 통과 : " + arr.get(0));
                    arr.remove(0);
                    cnt++;
                    continue;
                }
                if (stack.isEmpty()) {
                    stack.push(arr.get(0));
                    // System.out.println("스택 push : " + arr.get(0));
                    arr.remove(0);
                } else {
                    if (stack.peek() == cnt) {
                        // System.out.println("스택 pop : " + stack.pop());
                        stack.pop();
                        cnt++;
                    } else if (stack.peek() < arr.get(0)) {
                        ans = 0;
                        System.out.println("Sad");
                        break;
                    } else {
                        // System.out.println("스택 push : " + arr.get(0));
                        stack.push(arr.get(0));
                        arr.remove(0);
                    }
                }
            } else if (cnt != stack.peek()) {// 비교할때는 peek써야지;;; pop말고.
                ans = 0;
                System.out.println("Sad");
                break;
            } else {
                cnt++;
                // System.out.println("스택 pop : " + stack.pop());
                stack.pop();
            }
        }
        if (ans == 1)
            System.out.println("Nice");
    }
}
