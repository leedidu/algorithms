import java.util.Arrays;
class Solution {
    public static long solution(int[] sequence) {
        // - + - 가 연속해서 나오는 부분 확인 -> 펄스부분을 더하면 될듯?

        long[] sequence1 = new long[sequence.length]; // 1, -1, 1
        long[] sequence2 = new long[sequence.length]; // -1 , 1, -1

        for(int i = 0 ; i < sequence.length; i ++){
            if(i % 2 == 0){
                sequence1[i] = sequence[i];
                sequence2[i] = -sequence[i];
            } else{
                sequence2[i] = sequence[i];
                sequence1[i] = -sequence[i];
            }
        }

        long[] maxSum1 = new long[sequence.length];
        long[] maxSum2 = new long[sequence.length];

        maxSum1[0] = sequence1[0];
        maxSum2[0] = sequence2[0];

        for(int i = 1 ; i < sequence.length; i ++){
            maxSum1[i] = Math.max(maxSum1[i - 1] + sequence1[i], sequence1[i]);
            maxSum2[i] = Math.max(maxSum2[i - 1] + sequence2[i], sequence2[i]);
        }
        Arrays.sort(maxSum1);
        Arrays.sort(maxSum2);
        return Math.max(maxSum1[maxSum1.length - 1], maxSum2[maxSum2.length - 1]);
    }
}