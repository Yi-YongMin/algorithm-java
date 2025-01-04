import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        // StringTokenizer stringTokenizer = new StringTokenizer(str, " ");
        // int N = Integer.parseInt(stringTokenizer.nextToken());

        // N번
        for (int i = 0; i < N; i++) {
            long input = Long.parseLong(br.readLine());
            if (input == 0 || input == 1) {
                System.out.println(2);
                continue;
            }

            int end = 0;
            while (true) {
                // max까지만 돌리기
                int max = (int) Math.sqrt(input); // 얘가 문제였다. -> 계속 업데이트 시켜줘야 함

                for (int j = 2; j <= max; j++) {
                    // 하나라도 약수가 있다면 , 바로 break 걸고 다음 수로
                    if (input % j == 0) {
                        end = 1;
                        break;
                    }
                }
                if (end == 1) { // 1이면 input 1증가, 0 max까지 약수가 없었으므로 소수 판단.
                    end = 0;
                    input++;
                } else {
                    System.out.println(input);
                    break;
                }
            }
        }
    }

}