import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[]{1, gems.length};
        Set<String> total = new HashSet();
        for(String gem :gems){
            total.add(gem);
        }
        int sum = total.size(); // 보석 개수
        int len = gems.length;
        
        int start = 0;
        int end = 0;
        HashMap<String, Integer> map = new HashMap();
        while (end < gems.length ) {
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
            end++;
            while(map.size() == sum){
                if(len > end - start){
                    len = end - start;
                    answer[0] = start + 1;
                    answer[1] = end;
                }

                int cnt = map.get(gems[start]) - 1;
                if(cnt == 0) {
                    map.remove(gems[start]);
                } else {
                    map.put(gems[start], cnt);
                }
                start++;
            }

        }


        return answer;
    }
}