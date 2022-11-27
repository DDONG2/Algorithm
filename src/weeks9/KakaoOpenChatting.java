package weeks9;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class KakaoOpenChatting {

    public static void main(String[] args) throws IOException {


        String[] record =
                {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        Solution( record);
    }

    public static String[] Solution(String[] record) {
        Map<String, String> state = new HashMap<>(); // 키 중복저장 불가인 해시맵 사용 (같은 uid 의 닉네임 변경 처리를 위함)
        int changeCount = 0; // 닉네임 변경 카운트

        for(int i = 0; i < record.length; i++){
            String[] input = record[i].split(" ");

            if(input[0].equals("Enter")){ // 채팅방 입장
                state.put(input[1], input[2]);
            } else if(input[0].equals("Leave")){ // 채팅방 나가기
                continue;
            } else { // 닉네임 변경
                state.put(input[1], input[2]);
                changeCount++;
            }
        }

        String[] answer = new String[record.length - changeCount]; // 닉네임 변경은 츨력값이 아니기 때문에 해당 카운트만큼 - 계산
        int idx = 0; // 인덱스를 따로두는 이유는 닉네임 변경 때문

        for(int i = 0; i < record.length; i++){
            String[] input = record[i].split(" ");
            String nickname = state.get(input[1]);

            if(input[0].equals("Enter")){                      // 들어오는 경우
                answer[idx++] = nickname + "님이 들어왔습니다.";
            } else if(input[0].equals("Leave")){               // 나가는 경우
                answer[idx++] = nickname + "님이 나갔습니다.";
            }
        }

        return answer;
    }

}
