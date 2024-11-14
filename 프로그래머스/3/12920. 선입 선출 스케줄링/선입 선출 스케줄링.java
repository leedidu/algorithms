import java.util.*;

class Solution {
    public int solution(int n, int[] cores) {
        // 범위 설정
        int left = 1;
        int right = Arrays.stream(cores).max().getAsInt() * n;
        int mid;
        
        // 최소시간찾기
        while (left < right) {
            mid = (left + right) / 2;
            
            // 현재시간동안 각 코어가 처리할 수 있는 총작업수 계산
            int total = cores.length;
            for (int core : cores) {
                total += mid / core;
            }
            
            if (total >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        int total = cores.length; 
        for (int core : cores) {
            total += (left - 1) / core;
        }
        
        // 남은 작업 수 계산
        int remaining = n - total;
        
        for (int i = 0; i < cores.length; i++) {
            if (left % cores[i] == 0) {
                remaining--;
                if (remaining == 0) {
                    return i + 1; 
                }
            }
        }
        
        return -1; 
    }
}
