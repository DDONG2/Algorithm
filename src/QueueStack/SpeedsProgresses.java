package QueueStack;

import java.io.IOException;

// https://school.programmers.co.kr/learn/courses/30/lessons/42586 프로그래머스 기능개발
public class SpeedsProgresses {
    public static void main(String[] args) throws IOException {
        int[] progresses = {93, 30, 50};
        int[] speeds = {1, 30, 5};

        int[] answer = new int[progresses.length];
        Double day = 0.0;

        for (int i = 0; i < progresses.length; i++) {
            if (i != 0) {
                if ((100 - progresses[i]) / speeds[i] <= day) {
                    answer[i - 1] += 1;
                    continue;
                } else {
                    day = Math.ceil(((100 - progresses[i]) / speeds[i]));
                    answer[i - 1] += 1;
                }
            } else {
                day = Math.ceil(((100 - progresses[i]) / speeds[i]));
            }
        }
    }
}
