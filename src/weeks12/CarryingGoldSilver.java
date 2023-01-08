package weeks12;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class CarryingGoldSilver {
    public static void main(String[] args) throws IOException {
        int[] g = {100};
        int[] s = {100};
        int[] w = {7};
        int[] t = {10};

        solution(10, 10, g, s, w, t);
    }


    public static long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = (long) (10e9 * 2 * 10e5 * 2);
        int cityLength = g.length; // 도시의 수
        long start = 0;
        long end = (long) (10e9 * 2 * 10e5 * 2); //  최악의 경우: ((금의 양)+(은의 양) / (한번에 옮길 수 있는 무게)) * (옮기는데 걸리는 시간 * 2)
                                                 //             ((10^9 * 2) / 1) * (10^5 *2)
        while (start <= end) { // start <= end 를 만족하지 않으면 둘은 만나므로 이 때 while 반복문이 종료된다.
            long mid = (start + end) / 2; // 이분 탐색의 중간값(시간)
            int gold = 0; // 운반된 금의 양
            int silver = 0; // 운반된 은의 양
            int add = 0; // 운반된 금과 은의 양

            for (int i = 0; i < cityLength; i++) {
                int nowGold = g[i];
                int nowSilver = s[i];
                int nowWeight = w[i];
                long nowTime = t[i];

                long moveCount = mid / (nowTime * 2); // mid 시간 / 운반소요시간 *2 = 현재 마을에서 옮길 수 있는 총 횟수
                if (mid % (nowTime * 2) >= t[i]) { // 나머지가 nowTime 보다 크다면 1번 편도가 가능하므로 moveCount 에 1을 더한다.
                    moveCount++;
                }

                gold += Math.min(nowGold, moveCount * nowWeight);
                silver += Math.min(nowSilver, moveCount * nowWeight);
                add += Math.min(nowGold + nowSilver, moveCount * nowWeight); // gold, silver, add 에 각각 더하는 값은, 보유량(nowGold, nowSilver)과 왕복으로 옮기는 총량(moveCount * nowWeight) 중 최소값이다.
            } // 이 과정을 모든 순환에 반복하면, 해당시간(mid)에서 모든 마을에서 옮길 수 있는 gold, silver, add(금+은) 총량이 나온다.

            if (a <= gold && b <= silver && a + b <= add) { // 모두 옮길 수 있는 충분한 시간일 경우
                end = mid - 1;
                answer = Math.min(mid, answer);
                continue;
            }

            start = mid + 1; // 만족하지 않다면, 더 많은 시간이 요구되므로 start 값을 (mid + 1) 로 늘려준다.
        }

        return answer;
    }

}
