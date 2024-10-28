import java.util.*;
class Solution {
    public static String solution(int[] numbers) {
        String[] strs = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            strs[i] = String.valueOf(numbers[i]);
        }
        
        // 문자열 배열을 퀵 정렬
        quickSort(strs, 0, strs.length - 1);
        
        // 정렬된 문자열 배열을 이어붙여 결과 문자열 생성
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str);
        }
        
        String answer = sb.toString();
        return answer.startsWith("0") ? "0" : answer;
    }
    
    private static void quickSort(String[] arr, int start, int end){
        if(start >= end) return;

        // 피벗을 기준으로 두부분으로 배열 분할
        int pivot = partition(arr, start, end);

        // 피벗을 제외한 왼쪽 부분 배열 정렬 -> 피벗보다 작거나 같은 요소
        quickSort(arr, start, pivot - 1);

        // 피벗을 제외한 오른쪽 부분 배열 정렬 -> 피벗보다 큰 요소
        quickSort(arr, pivot + 1, end);
    }
    
        // 배열을 피벗 기준으로 분할 / 피벗의 최종 위치 반환하는 메서드
    private static int partition(String[] arr, int start, int end) {
        String pivot = arr[end];
        int i = start - 1;
        
        for(int j = start; j < end; j++){
            // 두 문자열을 이어붙였을 때 더 큰 숫자를 만드는 조건 확인
            // 앞에 붙였을 때, 뒤에 붙였을 때 비교
            if((arr[j] + pivot).compareTo(pivot + arr[j]) > 0){
                i++;
                
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        // 피벗 위치 변경
        String temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;

        return i + 1;
    }
}