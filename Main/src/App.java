import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String K = br.readLine();
        Set<Character> setLeft = new HashSet<Character>();
        Set<Character> setRight = new HashSet<Character>();

        setRight.add(']');
        setLeft.add('[');
        setLeft.add('(');
        setRight.add(')');
        while (!K.equals(".")) {
            // no일경우에는 1 , yes 일 경우에는 0 인 변수 하나 설정.
            int ans = 0;
            // 스택 생성
            Stack<Character> stack = new Stack<>();
            // 문장 읽기
            String str = K;
            // 문장을 순회하면서 좌측 괄호의 경우에는 스택에 넣고 , 우측 괄호의 경우에는 pop해서 바로 비교
            for (int i = 0; i < str.length() - 1; i++) {
                if (setLeft.contains(str.charAt(i))) {// 좌측 괄호를 만나면 스택에 푸쉬
                    stack.push(str.charAt(i));
                } else if (setRight.contains(str.charAt(i)) && !stack.isEmpty()) {// 우측 괄호를 만나면 스택에서 바로 pop한뒤에 비교
                    // pop을 위해서는 stack이 비어있어서는 안된다.
                    Character left = stack.pop();
                    Character right = str.charAt(i);
                    if (left.equals('(') && right.equals(')'))
                        continue;
                    else if (left.equals('[') && right.equals(']'))
                        continue;
                    else {
                        System.out.println("no");
                        ans = 1;
                        break;
                    }
                } else if (setRight.contains(str.charAt(i)) && stack.isEmpty()) { // 우측 괄호를 만났지만 , 스택이 비어있는 경우
                    System.out.println("no");
                    ans = 1;
                    break;
                }
            }
            if (ans == 0 && stack.isEmpty()) {
                System.out.println("yes");
            } else if (ans == 0 && !stack.isEmpty()) {
                System.out.println("no");
            }
            K = br.readLine();
        }
    }
}
