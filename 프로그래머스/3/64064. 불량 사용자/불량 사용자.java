import java.util.*;

class Solution {
    public static int solution(String[] user_id, String[] banned_id) {
        // 중복 방지 해야 하므로 set
        Set<String> combination = new HashSet<>();
        findCombinations(0, user_id, banned_id, new ArrayList<>(), combination, new boolean[user_id.length]);
        return combination.size();
    }

    public static void findCombinations(int index, String[] userId, String[] bannedId, List<String> cur, Set<String> combination, boolean[] visited){
        if(index == bannedId.length){ // 모든 경우에 대해 처리한 경우
            List<String> sorted = new ArrayList<>(cur);
            Collections.sort(sorted);
            combination.add(String.join(" ", sorted));
            return;
        }

        for (int i = 0; i < userId.length; i++) {
            if (visited[i]) {  // 이미 방문한 사용자라면 건너뜀
                continue;
            }

            if (userId[i].length() == bannedId[index].length()) {  // 길이가 같을 때만 비교
                boolean isMatch = true;
                for (int j = 0; j < userId[i].length(); j++) {
                    // 와일드카드가 아닌경우는 완벽히 일치해야함 -> 아니면 false로 변경
                    if (bannedId[index].charAt(j) != '*' && userId[i].charAt(j) != bannedId[index].charAt(j)) {
                        isMatch = false;
                        break;
                    }
                }

                if (isMatch) {  // 패턴이 일치하면 재귀 호출
                    cur.add(userId[i]);
                    visited[i] = true;  // 방문 표시
                    // "*frodo" 가 두번있는경우 -> frodo, crodo 선택해야하므로 frodo는 방문으로 표시하여 두번 포함되지 않도록함
                    findCombinations(index + 1, userId, bannedId, cur, combination, visited);
                    visited[i] = false;  // frodo를 다른 경우에서 다시 선택하기 위해 false로 변경
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }
}