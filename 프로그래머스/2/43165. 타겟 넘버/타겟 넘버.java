class Solution {
    static int[] num;
    static int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        num = new int[numbers.length];
        
        dfs(0, 0, target, numbers);
        
        return answer;
    }
    
    private void dfs(int index, int sum, int target, int[] numbers){
        if(index == numbers.length){
            if(sum == target){
                answer++;
            }
            return;
        }
        
        dfs(index + 1, sum + numbers[index], target, numbers);
        dfs(index + 1, sum - numbers[index], target, numbers);
    }
}