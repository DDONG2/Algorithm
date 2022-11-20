package weeks8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DistantNode {

    private static ArrayList<Integer>[] adj;
    private static int[] visit;
    private static int depth = 0;

    public static void main(String[] args) throws IOException {


        int[][] test =
                {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        Solution(6, test);
    }

    public static int Solution(int n, int[][] test) {
        int answer = 0;
        visit = new int[n + 1];
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < test.length; i++) { // 모든 노드의 연결관계를 정리
            adj[test[i][0]].add(test[i][1]);
            adj[test[i][1]].add(test[i][0]);
        }

        bfs(1, 1);

        for (int i = 1; i <= n; i++) {
            if (depth == visit[i]) answer += 1; // 가장긴 거리를 가진 값이 몇개인지 체크
        }

        return answer;
    }

    private static void bfs(int start, int count) {
        Queue<Integer> q = new LinkedList();
        q.add(start); // 스타트 노드
        q.add(count); // 이동거리
        visit[start] = count;

        while (!q.isEmpty()) { // 모든 노드 검사
            int node = q.poll(); // 현재 계산중인 노드
            int n = q.poll(); // 현재 계산중인 노드 거리값

            if (depth < n) {
                depth = n;
            } // 노드 이동 거리

            for (int i = 0; i < adj[node].size(); i++) {
                int next = adj[node].get(i); // 해당노드의 다음 노드값

                if (visit[next] != 0) continue; // 방문 했었는지 체크 (방문했던 노드면 와일문 종료)
                visit[next] = n + 1; // 거리값 + 1
                q.add(next); // 다음 계산할 노드 셋
                q.add(n + 1); // 노드 이동거리 카운팅
            }
        }
    }
}
