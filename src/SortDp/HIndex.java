package SortDp;

import java.io.IOException;
import java.util.Arrays;

public class HIndex {

    public static void main(String[] args) throws IOException {
        int[] arrTest = {3, 0, 6, 1, 5};
        solution(arrTest);

    }

    public static int solution(int[] citations) {
        //오름차순 정렬 0 1 3 5 6
        Arrays.sort(citations);
        int hIndex = 0;
        int answer = 0;

        for(int i = 0 ; i < citations.length ; i++){
//            이상의 H-Index 계산 5 4 3 2 1
            hIndex = citations.length - i;

            if(citations[i]>=hIndex){
                answer = hIndex;
                break;
            }
        }
        return answer;


    }
}
