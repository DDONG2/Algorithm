package QuestGreedy;

import java.io.IOException;
import java.util.*;

public class Carpet {
    public static void main(String[] args) throws IOException {
        int brown = 10;
        int yellow = 2;
        solution(brown, yellow);
    }
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;

        for (int i = 3; i < sum; i++) { // i가 3인 이유는 최소 사이즈이기때문
            int j = sum / i;

            if (sum % i == 0 && j >= 3) {
                int col = Math.max(i, j);
                int row = Math.min(i, j);
                int center = (col - 2) * (row - 2);

                if (center == yellow) {
                    answer[0] = col;
                    answer[1] = row;
                    return answer;
                }
            }
        }
        return answer;

    }
}
