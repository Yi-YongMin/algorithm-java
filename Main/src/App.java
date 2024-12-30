import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 정점의 수 N (5 ≤ N ≤ 100,000), 간선의 수 M (1 ≤ M ≤ 200,000), 시작 정점 R (1 ≤ R ≤ N)이
        // 주어진다.
        String str = br.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(str, " ");
        int N = Integer.parseInt(stringTokenizer.nextToken()), M = Integer.parseInt(stringTokenizer.nextToken()),
                R = Integer.parseInt(stringTokenizer.nextToken());

        Stack<Node> stack = new Stack<>();
        // N개의 노드를 그래프로 만들기
        Node[] graph = new Node[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new Node();
            graph[i].idx = i;
        }
        for (int i = 0; i < M; i++) {
            str = br.readLine();
            stringTokenizer = new StringTokenizer(str, " ");
            int first = Integer.parseInt(stringTokenizer.nextToken());
            int second = Integer.parseInt(stringTokenizer.nextToken());
            Node n1 = graph[first];
            Node n2 = graph[second];

            // 만약 n1의 인접노드에 n2가 포함되어있지 않았다면,
            if (!n1.adjacent.contains(n2))
                graph[first].adjacent.add(graph[second]);
            if (!n2.adjacent.contains(n1))
                graph[second].adjacent.add(graph[first]);
        }

        // 오름차순으로 정렬
        for (int i = 1; i <= N; i++) {
            graph[i].adjacent.sort((n1, n2) -> n1.idx - n2.idx);
        }

        // 방문 순서를 출력할 때 쓰일 변수 선언
        int cnt = 1;
        // 맨 처음에는 R부터 시작
        graph[R].visited = cnt++;
        stack.push(graph[R]);
        // 근데 인접 노드는 낮은 숫자부터 오름차순으로 방문,,,?
        while (!stack.isEmpty()) {
            Node p = stack.pop();
            for (Node n : p.adjacent) {
                if (n.visited == 0) {
                    n.visited = cnt++;
                    stack.push(n);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(graph[i].visited);
        }
    }
}

class Node implements Comparable<Node> {
    int idx;
    // 디폴트로 일단 방문 안한 것.
    int visited = 0;
    LinkedList<Node> adjacent = new LinkedList<>();

    // 오름차순으로 출력하기 위한 compareTo 오버라이딩
    @Override
    public int compareTo(Node node) {
        return this.idx - node.idx;
    }
}
