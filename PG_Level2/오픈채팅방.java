package PG_Level2;

import java.util.*;

/**
 * 재밌는 구현 문제
 * 
 * 문제가 되는 부분
 * 1. 변경된 닉네임을 어떻게 체크할 것인가?
 * 2. 닉네임 변경 시 이전 기록도 일괄 변경
 * 
 * 접근법
 * 1. HashMap 으로 (id, 닉네임) 저장
 * 2. 모든 기록을 list 에 저장 (id님이 입장/퇴장 했습니다) => 마지막에 닉네임으로 바꾸기 위해
 * 2-1. 변경이 있을 때 마다 HashMap에 덮어쓰기
 * 3. HashMap에서 id로 닉네임 꺼내와서 전부 변경해주기
 */

class 오픈채팅방 {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int size = record.length;

        String[] std;
        for (int i = 0; i < size; i++) {
            std = record[i].split(" ");

            if (std[0].equals("Enter")) {
                map.put(std[1], std[2]);
                list.add(std[1] + "님이 들어왔습니다.");
            } else if (std[0].equals("Leave")) {
                list.add(std[1] + "님이 나갔습니다.");
            } else
                map.put(std[1], std[2]);
        }

        String[] answer = new String[list.size()];
        String id;
        int cnt = 0;
        for (String s : list) {
            id = s.substring(0, s.indexOf("님"));
            answer[cnt++] = s.replace(id, map.get(id));
        }

        return answer;
    }
}