import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 자료구조 개수 N개
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(str, " ");

        // 자료구조 수열
        int[] structure = new int[N];
        // 값을 넣어놓을 배열
        int[] value = new int[N];

        // 큐가 어느 인덱스에 있는지 확인하기 위한 idxArr
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            structure[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        // System.out.println(Arrays.toString(structure));
        str = br.readLine();
        stringTokenizer = new StringTokenizer(str, " ");
        for (int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(stringTokenizer.nextToken());
            if (structure[i] == 0)
                q.addLast(value[i]);
        }
        // System.out.println(Arrays.toString(value));

        int M = Integer.parseInt(br.readLine());
        str = br.readLine();
        stringTokenizer = new StringTokenizer(str, " ");

        StringBuilder ans = new StringBuilder();
        // 수열의 길이 M번만큼 반복을 해야 합니다.
        // 시간초과 -> 큐만 따로 생각해야 함
        for (int i = 0; i < M; i++) {
            // 여행을 다닐 변수를 선언합니다. 수열 c의 값들이 여행을 시작하는 상황.
            int traveler = Integer.parseInt(stringTokenizer.nextToken());

            // 여행을 시작합니다.
            q.addFirst(traveler);
            traveler = q.pollLast();

            // 여행이 끝난 traveler 은 , ans 에 추가합니다.
            ans.append(traveler + " ");
        }
        ans.trim();
        System.out.println(ans);
        br.close();
    }
}
