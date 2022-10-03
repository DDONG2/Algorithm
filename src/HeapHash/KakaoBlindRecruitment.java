package HeapHash;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KakaoBlindRecruitment { // 5
    public static void main(String[] args) throws IOException {
        String[] arrTestId = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        solution(arrTestId, report, k);
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, List<String>> map = new HashMap<>(); // 해당 id 몇번 신고당함?
        Map<String, List<String>> mapResult = new HashMap<>(); // id 당 누구누구 신고함?
        Map<String, List<String>> checkId = new HashMap<>(); // 중복 체크용

        for (int i = 0; i < id_list.length; i++) {
            map.put(id_list[i], new ArrayList<>());
            mapResult.put(id_list[i], new ArrayList<>());
        }

        for (int i = 0; i < report.length; i++) {
            if (checkId.get(report[i]) == null) {
                checkId.put(report[i], new ArrayList<>());
                map.get(report[i].split(" ")[1]).add(report[i].split(" ")[0]);
                mapResult.get(report[i].split(" ")[0]).add(report[i].split(" ")[1]);
            }
        }

        int count = 0;

        for (int i = 0; i < id_list.length; i++) {
            for (int z = 0; z < mapResult.get(id_list[i]).size(); z++) {
                if (map.get(mapResult.get(id_list[i]).get(z)).size() >= k) {
                    count++;
                }
            }
            answer[i] = count;
            count = 0;
        }
        return answer;
    }

}
