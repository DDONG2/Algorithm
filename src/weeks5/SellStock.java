package weeks5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SellStock {

    public static void main(String[] args) throws IOException {
        int[] arrTest = {7,6,4,3,223,475,220,901,158,209,500,33,662,34,644,470,408,29,743,70,277,810,910,416,830,878,766,619,1};
        maxProfit2(arrTest);
    }

//    public static int maxProfit(int[] prices) {
//        int answer = 0;
//        int temp = 0;
//        List<Integer> result = new ArrayList<>();
//
//        for (int i = 0; i < prices.length; i++) {
//            temp = prices[i];
//            for(int j = i+1; j < prices.length; j++){
//                if(temp < prices[j]){
//                    result.add(prices[j] - temp);
//                }
//            }
//        }
//        Collections.sort(result, Collections.reverseOrder());
//        if(result.isEmpty()){
//            answer = 0;
//        } else{
//            answer = result.get(0);
//        }
//        return answer;
//    }

    public static int maxProfit2(int[] prices) {
        int answer = 0;
        int temp = prices[0];
        int length = prices.length;
        int result = 0;

        for (int i = 0; i < length; i++) {
            if (prices[i] < temp) {
                temp = prices[i];
            }else {
                result = prices[i] - temp;
                if (result > answer){
                    answer = result;
                }
            }
        }
        return answer;
    }
}
