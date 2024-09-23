class Solution {
    public static int solution(int n, int[] stations, int w) {
        int answer = 0;

        /*
        * 5g 기지국의 전달범위 < 4g 기지국의 전달범위
        * 5g를 최소로 설치하면서 모든 아파트에 전달
        * 아파트의 수 n
        * 현재 기지국이 설치된 아파트의 번호가 담긴 배열 stations
        * 전파의 도달거리 w
        * */

        // 기지국 설치된건 지운다음 -> 나머지를 쪼개야함

        int index = 1; // 현재 파악 중인 위치
        int station = 0; // 기지국 위치

        while(index <= n) { // n개까지
            // 기지국이 범위에 포함되지 않는 경우
            if(station >= stations.length || stations[station] - w > index) {
                index = index +  (2 * w) + 1;
                answer++;
            } else{
                // 기지국이 범위에 포함되는 경우 혹은 배열의 크기를 넘어간 경우
                index = stations[station] + w + 1;  // 현재 위치를 범위 밖으로 이동
                station++;
            }
        }
        return answer;
    }
}