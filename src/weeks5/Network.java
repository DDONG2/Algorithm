package weeks5;

import java.io.IOException;

// https://school.programmers.co.kr/learn/courses/30/lessons/43162
public class Network {
    public static void main(String[] args) throws IOException {
        int[][] computers =
                {{1, 1, 0},
                        {1, 1, 0},
                        {0, 1, 1}}; //int[3][3]
        Solution(3, computers);
    }

//    public static int Solution(int n, int[][] computers) { // 1개가 2개이상 연결될 경우는 해당조건 만족 X
//
//        for(int i=0; i<=n; i++) {
//            for(int j=0; j<=n; j++){
//                if(j <= i){
//                    continue;
//                }
//                if(computers[i][j] ==1){
//                    n--;
//                }
//            }
//        }
//        return n;
//    }

    public static int Solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n]; // 연결 되어있는지 안되어있는지 체크하기 위한 boolean 배열
        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                dfs(computers, check, i); // 해당 dfs알고리즘을 거치면 연결되어있는 모든 computers checks 값이 true 가 된다.
                answer++;
            }
        }
        return answer;
    }

    static void dfs(int[][] computers, boolean[] check, int start) {
        check[start] = true; // 자기 자신은 건너뛰는 처리
        for (int i = 0; i < computers.length; i++) {
            if (computers[start][i] == 1 && !check[i]) { // 체크하는 배열이 연결되어있고 체크하지 않은 상태 일 경우
                dfs(computers, check, i);
            }
        }
    }
}
