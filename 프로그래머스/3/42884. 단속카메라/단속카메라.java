import java.util.Arrays;

class Solution {
    public static int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        int end = routes[0][1];
        for(int i = 1; i < routes.length; i++) {
            // 만약 첫번째차의 출발점보다 크면 다음으로 넘어가야됨
            // 현재 차량의 진입 시점이 이전 차량의 진출시점보다 클때만 새로운 카메라 설치
            if(routes[i][0] > end) {
                answer++;
                end = routes[i][1];
            }
        }
        return answer;
    }
}