package HeapHash;

import java.io.IOException;

public class SmallestElement {
    public static void main(String[] args) throws IOException {
        int[][] arrTest = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}};
        smallBinarySearch(arrTest, 5);
    }


    public static int smallBinarySearch(int[][] matrix, int k) {
        int min = matrix[0][0];
        int max = matrix[matrix.length - 1][matrix.length - 1]; // 행의 갯수 -1

        while (min <= max) {
            int mid = (max - min) / 2 + min;
            int count = 0;

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][0] > mid)
                        break;
                    if (matrix[i][i] <= mid)
                        count++;
                }
            }

            if (count < k) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }


        return min;
    }
}
