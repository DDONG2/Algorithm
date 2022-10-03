package HeapHash;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargest { // 1
    public static void main(String[] args) throws IOException {
        int[] arrTest = {3, 2, 1, 5, 6, 4};
//        findKthLargest(arrTest, 2);
//        findKthLargest2(arrTest, 2);
        findKthLargest3(arrTest, 2);

    }


    public static int findKthLargest(int[] nums, int k) { // Array sort 사용 이건아닌거같다..
        Arrays.sort(nums);
        System.out.println(nums[nums.length - k]);
        return nums[nums.length - k];
    }

    public static int findKthLargest2(int[] nums, int k) {
        Integer[] arr = new Integer[nums.length];
        for(int i=0; i<nums.length; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(arr , Collections.reverseOrder());
        System.out.println(arr[k-1]);
        return arr[k-1];
    }

    public static int findKthLargest3(int[] nums, int k) { // 우선순위 큐
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for(int i: nums){
            q.offer(i); // 값 추가

            if(q.size() > k){
                q.poll(); // 첫번째 값을 반환하고 제거 비어있다면 null
            }
        }
        System.out.println(q.peek());

        return q.peek(); // 첫번째 값 참조
    }
}
