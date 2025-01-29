import java.io.*;
import java.util.*;

public class Main {
    static int[] x_knight = { 1, 2, 2, 1, -1, -2, -2, -1 };
    static int[] y_knight = { 2, 1, -1, -2, -2, -1, 1, 2 };
    static int len; // l
    static int[] cur = new int[2];
    static int[] dest = new int[2];;
    static String input;
    static boolean[][] visited;
    static int[][] map;
    static Queue<int[]> q = new LinkedList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            len = Integer.parseInt(br.readLine());
            visited = new boolean[len][len];
            map = new int[len][len];
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input, " ");
            cur[0] = Integer.parseInt(st.nextToken());
            cur[1] = Integer.parseInt(st.nextToken());
            input = br.readLine();
            st = new StringTokenizer(input, " ");
            dest[0] = Integer.parseInt(st.nextToken());
            dest[1] = Integer.parseInt(st.nextToken());
            bfs();
        }
    }

    static void bfs() throws IOException {
        if (cur[0] == dest[0] && cur[1] == dest[1]) {
            bw.write(0 + "\n");
            bw.flush();
            q.clear();
            return;
        }
        q.add(cur);
        int[] next = new int[2];
        while (!q.isEmpty()) {
            next = q.poll();//
            if (visited[next[0]][next[1]])
                continue;
            visited[next[0]][next[1]] = true;
            for (int i = 0; i < 8; i++) {
                int mvX = next[0] + x_knight[i];
                int mvY = next[1] + y_knight[i];
                if (mvX >= len || mvX < 0 || mvY >= len || mvY < 0)
                    continue;
                if (visited[mvX][mvY])
                    continue;
                q.add(new int[] { mvX, mvY });
                map[mvX][mvY] = map[next[0]][next[1]] + 1;
                if (mvX == dest[0] && mvY == dest[1]) {
                    bw.write(map[mvX][mvY] + "\n");
                    bw.flush();
                    q.clear();
                    return;
                }
            }
        }
    }
}
