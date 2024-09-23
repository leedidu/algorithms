class Solution {
    public static int solution(int[] stones, int k) {

        // 친구 수
        int min = 1; // 최소
        int max = 200000000; // 최대

        while(min <= max) {
            int avg = (min + max) / 2;
            if(whetherCan(stones, k, avg)) {
                min = avg + 1; // 더많은 인원이 가능한지
            } else{
                max = avg - 1;
            }
        }

        return max;
    }

    // stones 배열에서 각각 돌에대해 사람이 지날수있는지 확인하는 메서드
    public static boolean whetherCan(int[] stones, int k, int friends) {
        int impossible = 0;

        // 사람이 지나가면 해당 돌에서 남은 횟수 = stones[i] - friends
        // stone - friends 가 0 이하가 되면 해당 돌들이 k개 연속인지 확인
        for(int i = 0; i < stones.length; i++) {
            if(stones[i] - friends  < 0) {
                impossible++;
            } else{
                impossible = 0;
            }
            if(impossible >= k) return false; // k개 연속인지 확인
        }
        return true;
    }
}