package weeks10;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class truck {
    public static void main(String[] args) throws IOException {
        int[][] test =
                {{7}, {3,8}, {8, 1, 1}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        Solution(test);
    }

    public static int Solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0; // 현재 무개
        int time = 0; // 걸린 시간

        for(int i = 0; i < truck_weights.length; i++) {
            int truck = truck_weights[i];

            while(true) {
                // 큐에 아무것도 없는 경우 = 다리위에 트럭 존재 X
                if(queue.isEmpty()) {
                    queue.add(truck);
                    sum += truck;
                    time++; // 다리에 오를 때만 시간 추가
                    break;
                } else if(queue.size() == bridge_length) { // 큐에 다리 길이만큼 트럭이 다 찬 경우
                    sum -= queue.poll();
                } else  { // 다리 길이만큼 큐가 차지않았음
                    // weight 값을 넘지 않는 선에서 새로운 트럭을 다리에 올려줌
                    if(sum + truck <= weight) {
                        queue.add(truck);
                        sum += truck;
                        time++;
                        break;
                    } else {
                        // 넘는다면 0을 넣어 이미 큐에 있는 트럭이 다리를 건너게 만듬
                        queue.add(0);
                        time++;
                    }
                }
            }
        }

        // 마지막 트럭에서 반복문이 끝나는데, 마지막 역시 다리 길이만큼 지나가야하기에 + 다리 길이
        return time + bridge_length;
    }

}
