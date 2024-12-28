import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N개의 명령어
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(str, " ");
        LinkedList<Integer> arr = new LinkedList<>();
        LinkedList<Integer> idxArr = new LinkedList<>();
        String ans = "";
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(stringTokenizer.nextToken()));
            idxArr.add(i + 1); // i번 인덱스에 i+1 이 들어있는 상태
        }

        int start = 0;

        while (arr.size() != 1) {
            // start는 항상 현재 사이즈보다 작아야 한다.
            // 시작하는 풍선 인덱스와 값 확인
            int idx = idxArr.get(start);
            int moving = arr.get(start);

            // ans 에 추가
            ans += idx + " ";

            // 해당 인덱스에 존재하는 것들 삭제
            idxArr.remove(start);
            arr.remove(start);

            // start 최신화 -> 이동을 뜻 함
            if (moving > 0) {
                start = (start + moving - 1) % arr.size();
            } else {
                start = (start + moving) % arr.size();
                if (start < 0)
                    start += arr.size();
            }
        }
        ans += idxArr.poll();
        System.out.println(ans);
    }
}
