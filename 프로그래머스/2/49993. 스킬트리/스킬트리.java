import java.util.Arrays;
import java.util.List;

class Solution {
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;  // 정답을 찾았을 때 카운트할 변수
        List<String> trees = Arrays.asList(skill_trees);

        // 각 skill_tree마다 필터링된 스킬 순서를 확인
        for(String st : trees) {
            StringBuilder sb = new StringBuilder();

            // 스킬트리에서 skill에 해당하는 문자만 필터링
            for (int i = 0; i < st.length(); i++) {
                if (skill.contains(String.valueOf(st.charAt(i)))) {
                    sb.append(st.charAt(i));  // 스킬트리에서 유효한 스킬만 추가
                }
            }

            // 필터링한 스킬 순서가 주어진 스킬 순서와 일치하는지 확인
            String filteredSkills = sb.toString();
            if (skill.startsWith(filteredSkills)) {
                answer++;  // 올바른 스킬 순서를 따르는 경우 증가
            }
        }

        return answer;  // 일치하는 스킬트리 개수 반환
    }
}