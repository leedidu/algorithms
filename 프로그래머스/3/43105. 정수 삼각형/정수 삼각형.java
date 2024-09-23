import java.util.Arrays;

class Solution {
    public static int solution(int[][] triangle) {
        int answer = 0;
        int[][] ans = triangle.clone();

        ans[0][0] = triangle[0][0]; // 첫번째 값 넣어주기

        for(int i = 1; i <= triangle.length - 1; i++) {
            ans[i][0] = ans[i - 1][0] + triangle[i][0]; // 각 열의 가장 앞 요소와 마지막 요소는 그 줄의 합과 동일
            ans[i][ans[i].length - 1] = ans[i - 1][ans[i - 1].length - 1] + triangle[i][triangle[i].length - 1];

            for(int j = 1; j <= triangle[i].length - 2; j++) { // 중간 요소
                ans[i][j] = Math.max(ans[i - 1][j - 1], ans[i - 1][j]) + triangle[i][j];
            }
        }

        int[] ansArr = ans[ans.length - 1];
        Arrays.sort(ansArr);
        answer = ansArr[ansArr.length - 1];
        return answer;
    }
}
