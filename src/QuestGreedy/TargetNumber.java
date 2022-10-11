package QuestGreedy;

import java.io.IOException;

public class TargetNumber {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        int[] arrTest = {4,1,2,1};
        int target = 2;
        solution(arrTest, target);
    }
    public static int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(numbers, 0, target, 0);
        answer = count;

        return answer;

    }
    public static void dfs(int[] numbers, int depth, int target, int result){
        if (depth == numbers.length){
            if (target == result){
                count++;
            }
            return;
        }

        int add = result + numbers[depth];
        int sub = result - numbers[depth];

        dfs(numbers, depth+1, target, add);
        dfs(numbers, depth+1, target, sub);

    }
}
