package weeks6;

import java.io.IOException;

public class IntegerTriangle {

    public static void main(String[] args) throws IOException {
        int[][] test =
                {{7}, {3,8}, {8, 1, 1}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        Solution(test);
    }

    public static int Solution(int[][] triangle) {
        int[][] temp = new int[triangle.length][triangle.length];
        temp[0][0] = triangle[0][0]; // 피라미드 가장 위부분 입력 7

        for (int i = 1; i < triangle.length; i++) { // 가장윗부분 스킵(0이아닌 1부터 시작)
            // 맨 왼쪽 숫자 입력
            temp[i][0] = temp[i - 1][0] + triangle[i][0];
            // 가운데 숫자 입력
            for (int j = 1; j <= i; j++) {
                temp[i][j] = Math.max(temp[i - 1][j], temp[i - 1][j - 1]) + triangle[i][j];

            }

            // 맨 오른쪽 숫자 입력
            temp[i][i] = temp[i - 1][i - 1] + triangle[i][i];
            System.out.println(temp[i][i]);
        }

        int answer = 0;

        for (int i = 0; i < triangle.length; i++) {
            answer = Math.max(answer, temp[triangle.length - 1][i]);
        }

        return answer;
    }

}
