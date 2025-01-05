import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        // 500,000 까지의 소수 전부 넣어버리기
        for (int i = 2; i < 500000; i++) {
            if (isPrime(i))
                arr.add(i);
        } // 2 3 5 7 11 13 17 19
        int size = arr.size();
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            int halfOfInput = input / 2; // input은 무조건 짝수만 들어온다.
            int cnt = 0;
            for (int j = 0; j < size; j++) {
                int current = arr.get(j);
                // 배열의 현재 인덱스 값이 인풋의 절반보다 크면 스탑
                if (current > halfOfInput)
                    break;
                if (isPrime(input - current))
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
