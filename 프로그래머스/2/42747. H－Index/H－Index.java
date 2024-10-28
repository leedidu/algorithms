class Solution {
    public static int solution(int[] citations) {
        int[] cit = countingSort(citations);

        int n = citations.length;
        for(int i = 0; i < n; i++) {
            int h = n - i;
            if(cit[i] >= h) return h;
        }
        return 0;
    }

    public static int[] countingSort(int[] arr) {
        int arrLength = arr.length;
        int[] output = new int[arrLength]; // 정렬된 배열을 저장

        int[] count = new int[10001];

        for(int i = 0; i< arrLength; i++){
            count[arr[i]]++;
        }

        for(int i=1; i<count.length; i++){
            count[i] += count[i-1];
        }

        for(int i=arrLength-1; i>=0; i--){
            output[count[arr[i]]-1] = arr[i];
            count[arr[i]]--;
        }

        return output;
    }
}