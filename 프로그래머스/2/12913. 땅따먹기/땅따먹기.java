class Solution {
    public static int solution(int[][] land) {
        for(int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(Math.max(land[i - 1][3], land[i - 1][1]), land[i - 1][2]);
            land[i][1] += Math.max(Math.max(land[i - 1][0], land[i - 1][3]), land[i - 1][2]);
            land[i][2] += Math.max(Math.max(land[i - 1][0], land[i - 1][1]), land[i - 1][3]);
            land[i][3] += Math.max(Math.max(land[i - 1][0], land[i - 1][1]), land[i - 1][2]);
        }

        int max = Integer.MIN_VALUE;
        for(int a : land[land.length - 1]) {
            if(max < a) max = a;
        }
        return max;
    }
}