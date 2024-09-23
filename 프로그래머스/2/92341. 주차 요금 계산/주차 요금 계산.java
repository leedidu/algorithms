import java.util.*;

class Solution {
    public static ArrayList<Integer> solution(int[] fees, String[] records) {
        ArrayList<Integer> answer = new ArrayList<>();
        Map<String, Integer> parkingRecords = new HashMap<>();
        Map<String, String> inTime = new HashMap<>();

        // 입차, 출차 시간 기록
        for (String record : records) {
            String[] info = record.split(" ");
            String time = info[0];
            String carNum = info[1];
            String action = info[2];

            if (action.equals("IN")) {
                inTime.put(carNum, time);  // 입차 시간 기록
            } else { // 출차 시
                int parkedTime = calculateTime(inTime.get(carNum), time); // 입차 시간과 출차 시간 계산
                parkingRecords.put(carNum, parkingRecords.getOrDefault(carNum, 0) + parkedTime);
                inTime.remove(carNum); // 출차 후 입차 기록 삭제
            }
        }

        // 출차 기록이 없는 차량은 23:59에 출차된 것으로 간주
        for (String carNum : inTime.keySet()) {
            int parkedTime = calculateTime(inTime.get(carNum), "23:59");
            parkingRecords.put(carNum, parkingRecords.getOrDefault(carNum, 0) + parkedTime);
        }

        // 차량 번호 순으로 정렬
        List<String> sortedCars = new ArrayList<>(parkingRecords.keySet());
        Collections.sort(sortedCars);

        // 요금 계산
        for (String carNum : sortedCars) {
            int totalTime = parkingRecords.get(carNum);
            int totalFee = calculateFee(fees, totalTime);
            answer.add(totalFee);
        }

        return answer;
    }

    // 시간을 분 단위로 계산하는 함수
    private static int calculateTime(String inTime, String outTime) {
        String[] in = inTime.split(":");
        String[] out = outTime.split(":");
        int inMinutes = Integer.parseInt(in[0]) * 60 + Integer.parseInt(in[1]);
        int outMinutes = Integer.parseInt(out[0]) * 60 + Integer.parseInt(out[1]);
        return outMinutes - inMinutes;
    }

    // 요금을 계산하는 함수
    private static int calculateFee(int[] fees, int totalTime) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        if (totalTime <= baseTime) {
            return baseFee;
        } else {
            return baseFee + (int) Math.ceil((double) (totalTime - baseTime) / unitTime) * unitFee;
        }
    }
}