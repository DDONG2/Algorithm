package HeapHash;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargest {
    public static void main(String[] args) throws IOException {
        int[] arrTest = {1, 2, 3, 4, 5};
        findKthLargest(arrTest, 5);
        findKthLargest2(arrTest, 3);

    }


    public static int findKthLargest(int[] nums, int k) { // Array sort 사용 이건아닌거같다..
        Arrays.sort(nums);
//        Integer[] arr = new Integer[nums.length];
//        for(int i=0;i<nums.length;i++) {
//            arr[i] = nums[i];
//        }
//        Arrays.sort(arr , Collections.reverseOrder());
        return nums[nums.length - k];
    }

    public static int findKthLargest2(int[] nums, int k) { // 우선순위 큐
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for(int i: nums){
            q.offer(i);

            if(q.size()>k){
                q.poll();
            }
        }

        return q.peek();
    }
}
