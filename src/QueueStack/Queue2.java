package QueueStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// https://www.acmicpc.net/problem/18258 백준 18258
public class Queue2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> queue = new ArrayList<>();
        StringBuilder sb = new StringBuilder();


        int count = Integer.parseInt(bf.readLine());

        for (int i = 0; i < count; i++) {
            String[] order = bf.readLine().split(" ");
            switch (order[0]) {
                case "push":
                    queue.add(Integer.parseInt(order[1]));
                    break;

                case "pop":
                    if (queue.size() == 0) {
                        sb.append(-1);
                    } else {
                        int temp = queue.get(0);
                        queue.remove(queue.get(0));
                        sb.append(temp);
                    }
                    break;

                case "size":
                    sb.append(queue.size());
                    break;

                case "empty":
                    if (queue.size() == 0) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                    break;

                case "front":
                    if (queue.size() == 0) {
                        sb.append(-1);
                    } else {
                        sb.append(queue.get(0));
                    }
                    break;

                case "back":
                    if (queue.size() == 0) {
                        sb.append(-1);
                    } else {
                        sb.append(queue.get(queue.size() - 1));
                    }
                    break;
            }
        }

        System.out.println(sb);
    }
}