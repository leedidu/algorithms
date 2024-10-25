import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        // 배열에 입력받은 수 저장
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        bubbleSort(nums);
        for (int i = 0; i < n; i++) {
            System.out.println(nums[i]);
        }
    }

    // 버블정렬
    public static void bubbleSort(int[] nums) {
        int n = nums.length;

        // 전체 배열 순회
        for(int i = 0; i < n - 1; i++){
            // 정렬되지 않은 부분 순회
            for(int j = 0; j < n - i - 1; j++){
                // 현재 원소 > 다음 원소 >> 두 원소 위치 교환(오름차순)
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
}
