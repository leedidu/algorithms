import java.util.*;
class Solution {
    public static int solution(int N, int number) {
        int answer = -1;
        List<HashSet<Integer>> list = new ArrayList<>();

        for(int i = 0; i <= 8; i ++){
            list.add(new HashSet<>());
        }

        // [1] 초기화 = N
        list.get(1).add(N);

        // NN NNN 저장
        for(int i = 2; i <= 8; i++){
            list.get(i).add(Integer.parseInt(Integer.toString(N).repeat(i)));
        }

        for(int i = 1; i <= 8; i++){
            for(int j = 1; j < i; j++){
                for(int k : list.get(j)){
                    for(int l : list.get(i - j)){
                        list.get(i).add(k + l);
                        list.get(i).add(k - l);
                        list.get(i).add(k * l);
                        if(l != 0) {
                            list.get(i).add(k / l);
                        }
                    }
                }
            }
        }

        for(int i = 1; i <= 8; i++){
            if(list.get(i).contains(number)){
                answer = i;
                break;
            }
        }
        return answer;
    }
}