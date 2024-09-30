import java.util.Arrays;
class Solution {
    public static int solution(int[] a) {
        int answer = 0;
        /*
        * 인접한 풍선 중 번호가 더 작은 것을 터뜨리는 행위 : 한번 -> 이후에는 무조건 큰 번호만
        -> 왼쪽이나 오른쪽 중에서 최소값이 되어야지 ㅇ남을 수있음
        
        * 하나만 남기는 것이 가능한 모든 경우의 수
        
        남아있는 풍선들 중 최소값이 될 가능성이 있는 것
        = 풍선이 양쪽에서 최소값이 될 가능성이 있는지 확인
        * */
        
        int[] left = new int[a.length];
        int[] right = new int[a.length];

        left[0] = a[0];
        right[a.length - 1] = a[a.length - 1];
        for(int lMin = 1; lMin < a.length; lMin++) {
            left[lMin] = Math.min(a[lMin], left[lMin - 1]);
        }

        for(int rMin = a.length - 2; rMin > 0; rMin--) {
            right[rMin] = Math.min(a[rMin], right[rMin + 1]);
        }

        for(int i = 0; i< a.length; i++) {
            if(a[i] <= left[i] || a[i] <= right[i]) {
                answer++;
            }
        }
        return answer;
    }
}