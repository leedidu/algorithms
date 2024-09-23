class Solution {
    public static int solution(int sticker[]) {
        int answer = 0;

        int[] a = new int[sticker.length];
        int[] b = new int[sticker.length];

        if(sticker.length == 1) {
            return sticker[0];
        }

        // 첫번째 시작
        a[0] = sticker[0];
        a[1] = sticker[0]; // 뗄 수 없으므로

        for(int i = 2; i < sticker.length - 1; i++) {
            a[i] = Math.max(a[i - 1], a[i - 2] + sticker[i]); // 최대를 넣어줘야함
            // i번째 인덱스에서 2번째 전의 값에서 i번째의 값을 더한 것과 직전의 값과 비교를 하며 추가
        }
        // 두번째 시작
        b[0] = 0;
        b[1] = sticker[1];

        for(int i = 2; i < sticker.length; i++) {
            b[i] = Math.max(b[i - 1], b[i - 2] + sticker[i]);
        }

        answer = Math.max(a[sticker.length - 2], b[sticker.length - 1]);
        return answer;
    }
}