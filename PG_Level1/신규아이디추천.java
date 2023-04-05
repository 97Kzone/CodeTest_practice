package PG_Level1;

/*
* 접근법
* 1. 문제가 제시하는대로 따라가자
*/
class Solution {

    public String solution(String new_id) {
        // step 1 : 소문자로 변경
        new_id = new_id.toLowerCase();

        // step 2 : 소문자, 숫자, -, _, . 제외 모든 문자 제거
        new_id = new_id.replaceAll("[^a-z0-9._-]", "");

        // step 3 : 마침표 2번 이상 연속 => 하나의 마침표로 치환
        new_id = new_id.replaceAll("[.]+", ".");

        // step 4 : 마침표가 처음 or 끝에 위치 => 제거
        if (new_id.startsWith("."))
            new_id = new_id.substring(1);
        if (new_id.endsWith("."))
            new_id = new_id.substring(0, new_id.length() - 1);

        // step 5 : new_id 가 빈문자열? "a 대입 + step 7 처리
        if (new_id.isEmpty())
            return "aaa";

        // step 6 : 길이 16자 이상 => 15자로 만들기 + 마지막 . 제거
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if (new_id.endsWith("."))
                new_id = new_id.substring(0, 14);
        }

        // step 7 : 길이 2자 이하라면 마지막 문자 더해주기..
        if (new_id.length() <= 2) {
            char tmp = new_id.charAt(new_id.length() - 1);
            while (new_id.length() < 3) {
                new_id += tmp;
            }
        }

        return new_id;
    }
}