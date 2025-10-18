import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int lcm = arr[0];
        for (int i = 1; i < arr.length; i++) {
            lcm = lcm * arr[i] / gcd(lcm, arr[i]);
        }
        return lcm;
    }
    
    private int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }
}