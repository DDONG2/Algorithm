package weeks7;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.org.apache.xpath.internal.operations.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PermutationCycle {
    static BufferedReader br;
    static StringTokenizer st;
    static int T, N;
    static List<Integer>[] list;
    static boolean[] visit;

    public static void main(java.lang.String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int tc = 0; tc < T; tc++) {

            N = Integer.parseInt(br.readLine());  // 순열의 크기 N
            list = new ArrayList[N + 1];

            for (int i = 1; i <= N; i++) {
                list[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine()); // 숫자 입력 3 2 7 8 1 4 5 6

            for (int i = 1; i <= N; i++) {

                int v = Integer.parseInt(st.nextToken());

                list[i].add(v);
                list[v].add(i);   // 그다음 연결되는 노드를 저장하기위함 (순열이라 중복되는 값은 없음으로 리스트2개)
            }

            visit = new boolean[N + 1]; // 방문 했는지 안했는지 여부

            int cnt = 0;

            for (int i = 1; i <= N; i++) {

                if (!visit[i]) { // dfs 이후 방문 여부에 따라서 다시 탐색 해야할지 판별
                    dfs(i);
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }


    static void dfs(int num) {
        if (visit[num]) {
            return;
        }
        visit[num] = true; // 방문처리
        for (int x : list[num]) { // 사이클 추적하면서 방문한적 없는곳은 다시 dfs
            if (!visit[x]) {
                dfs(x);
            }
        }
    }
}

