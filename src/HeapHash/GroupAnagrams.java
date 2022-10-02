package HeapHash;

import java.io.IOException;
import java.util.*;

public class GroupAnagrams {


    public static void main(String[] args) throws IOException {
        String[] arrTest = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(arrTest);
    }

    public static List<List<String>> groupAnagrams(String[] arrTest) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> retult = new ArrayList<>();

        for(String str : arrTest){
            char[] temp = str.toCharArray(); // 받아온 글자를 케릭터 배열에 넣어준다.
            Arrays.sort(temp); // 해당 배열을 정렬한다.
            String key = new String(temp); // 정렬된 값을 키값으로 정의한다. (원소 구성이 같은 알파벳이면 Key 값은 모두 같다.)

            if(map.get(key) == null)
                map.put(key, new ArrayList<>());  // 해당 키값이 선언되어있지 않을때만 새로운 ArrayList를 만든다.

            map.get(key).add(str); // 해당 키값에 데이터를 넣어준다.
        }

        for(String key : map.keySet())
            retult.add(map.get(key)); // 맵의 해당하는 키 ArrayList를 결과에 담는다.

        return retult;

    }

}
