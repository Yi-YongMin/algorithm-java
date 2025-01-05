import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0)
                break;
            int cnt = 0;
            // n 초과 , 2n 이하인 소수들의 갯수
            for (int i = n + 1; i < 2 * n + 1; i++) {
                if (isPrime(i))
                    cnt++;
            }
            bw.write(cnt + "\n");
            bw.flush();
        }
    }

    static boolean isPrime(int N) {
        if (N <= 1)
            return false;
        if (N <= 3)
            return true;
        if (N % 2 == 0 || N % 3 == 0)
            return false;
        int until = (int) Math.sqrt(N);
        // 소수의 배수면 그것 또한 탈락
        for (int i = 5; i <= until; i += 6) {
            if (N % i == 0 || N % (i + 2) == 0)
                return false;
        }
        // 앞에꺼 다 통과하면 소수맞다.
        return true;
    }

}
