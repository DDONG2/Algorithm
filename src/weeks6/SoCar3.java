package weeks6;

import java.io.IOException;

public class SoCar3 {
    static int count = 0; // 알고있는 사람 수

    public static void main(String[] args) throws IOException {
        int Ouput = Solution(6, 2, 4);
        System.out.println(Ouput);
    }

    public static int Solution(int input, int delay, int forget) {

        dfs(input, delay, forget);

        return count;
    }

    static void dfs(int input, int delay, int forget) {
        for (int day = 1; day < input + 1; day++) {
            if (day > delay) { // 딜레이보다 클때부터 소문이 시작됨
                dfs( input - (day - 1), delay, forget); // 다른사람에게 알려주면 그사람도 소문을낸다. (day -1 은 날짜는 0이 아닌 1일부터 시작하기 때문)
                if (day > forget) { // 잊어먹는처리
                    break;
                }
                count++;
            }
        }
    }
}
