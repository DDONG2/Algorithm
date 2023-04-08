package kakao;

import java.io.IOException;
import java.util.*;


public class JewelryShopping {
    public static void main(String[] args) throws IOException {
        String[] test =
                {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        solution(test);
    }

    public static int[] solution(String[] gems) {
        Map<String, Integer> gemCounter = new HashMap<>(); //  HashMap으로 보석의 이름을 key로 가지고 value는 보석의 갯수를 가짐
        Queue<String> selectedGems = new LinkedList<>(); //  어피치가  선택한 보석 리스트
        Set<String> gemSet = new HashSet<>(Arrays.asList(gems)); // 보석 종류를 저장한 변수다.  중복을 허용하지 않는 set

        int start = 0; // 선택한 보석 리스트의 시작 지점
        int end = Integer.MAX_VALUE; //  선택한 보석 리스트의 끝 지점 (초기값은 max_value)
        int startPoint = 0;

        for (String gem : gems) {
            gemCounter.put(gem, gemCounter.getOrDefault(gem, 0) + 1);  // getOrDefault : 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환
            selectedGems.add(gem); // 선택한 보석 리스트에 추가

            while (true) {
                String targetGem = selectedGems.peek(); // Queue의 맨 앞 값 확인

                if (gemCounter.get(targetGem) <= 1) { // 1개 이하인 경우는 해당 gem은 필수적으로 리스트에 포함되어야 하는 것이므로 while문을 종료
                    break;
                }

                selectedGems.poll(); // Queue의 맨 앞에 있는 값 반환 후 삭제
                start++;
                gemCounter.put(targetGem, gemCounter.get(targetGem) - 1);
            }

            if (gemCounter.size() == gemSet.size() && end > selectedGems.size()) { //  gemCounter의 사이즈와 gemSet의 사이즈가 동일하고(gemCounter가 모든 종류의 보석을 다 가지고 있다는 것을 의미)
                startPoint = start;
                end = selectedGems.size();
            }
        }

        return new int[] {startPoint + 1, startPoint + end};
    }
}
