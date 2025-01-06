import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
    static int cnt = 0;
    static int[] tmp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input, " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        tmp = new int[N];
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(arr, 0, N - 1, K);
        // System.out.println(cnt);
        if (cnt < K) {
            bw.write(-1 + "\n");
            bw.flush();
        }
    }

    // 4 5 1 3 2
    public static void mergeSort(int[] arr, int p, int r, int K) {// arr 0 4 K
        int q = p; // 0
        if (p < r) {
            q = (p + r) / 2; // 2
            mergeSort(arr, p, q, K); // 0 2
            mergeSort(arr, q + 1, r, K); // 3 4
            merge(arr, p, q, r, K);
        }
    }

    public static void merge(int[] arr, int p, int q, int r, int K) {
        int i = p;
        int j = q + 1;
        int t = 0;
        while (i <= q && j <= r) {
            if (arr[i] <= arr[j])
                tmp[t++] = arr[i++];
            else
                tmp[t++] = arr[j++];
        }
        while (i <= q)
            tmp[t++] = arr[i++];
        while (j <= r)
            tmp[t++] = arr[j++];
        i = p;
        t = 0;
        while (i <= r) {
            arr[i++] = tmp[t++];
            cnt++;
            if (cnt == K)
                System.out.println(arr[i - 1]);
        }
    }
}