class Solution {
    public static int solution(int[] wallet, int[] bill) {
        int answer = 0;

        while (true) {
            int bigBill = Math.max(bill[0], bill[1]);
            int smallBill = Math.min(bill[0], bill[1]);
            int bigWallet = Math.max(wallet[0], wallet[1]);
            int smallWallet = Math.min(wallet[0], wallet[1]);

            if (smallBill <= smallWallet && bigBill <= bigWallet) {
                break;
            }

            if (bill[0] > bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            answer++;
        }

        return answer;
    }
}