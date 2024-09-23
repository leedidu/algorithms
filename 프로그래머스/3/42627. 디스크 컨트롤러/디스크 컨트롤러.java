import java.util.*;

class Solution {
    public static int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (o1, o2) -> Integer.compare(o1[0], o2[0])); // 정렬

        // 시간기준으로 오름차순 정렬되도록 큐 생성
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));

        int index = 0, time = jobs[0][0]; // 인덱스와 처음 대기 시간

        while(index < jobs.length || !q.isEmpty()) { // 길이보다 덜 돌고 큐가 비지않았을 경우 -> 모든 작업이 처리될때까지
            while(index < jobs.length && jobs[index][0] <= time) { // 현재까지 도착한 작업을 큐에 넣은 후 처리시간이 가장 짧은 작업부터
                q.offer(jobs[index++]);
            }
            if(q.isEmpty()){ // 큐가 비어있다면 -> 아직 처리할 작업이 X => 요청시간 갱신 및 작업 추가
                time=jobs[index][0];
                q.offer(jobs[index++]);
            }
            int[] work = q.poll(); // 소요시간이 가장 짧은 작업을 꺼내서 처리
            time += work[1];
            answer+= time-work[0];
        }
        return answer/jobs.length;
    }
}