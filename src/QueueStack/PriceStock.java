package QueueStack;

import java.io.IOException;
import java.util.Stack;

public class PriceStock {
    public static void main(String[] args) throws IOException {
        int[] arrTest = {1,2,3,2,3};
        solution(arrTest);
        System.out.println("Hello world!");
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i] += 1;
                if (prices[i] > prices[j])
                    break;
            }
        }
        return answer;
    }

    //스택을 사용한 문제 풀이법
    public int[] solution2(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop(); // 답을 구했기 때문에 stack에서 제거
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) { // 값을 구하지 못한 index == 끝까지 가격이 떨어지지 않은 주식
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }

        return answer;
    }
}
