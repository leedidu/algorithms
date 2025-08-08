import java.util.*;

class Solution {
    public static ArrayList<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        ArrayList<int[]> answer = new ArrayList<>();

        // data = 정렬한 데이터들이 담긴 이차원 정수 리스트
        // 어떤 정보를 기준으로 데이터를 뽑아낼지를 의미하는 문자열 ext
        // 뽑아낼 정보의 기준값을 나타내는 정수 val_ext
        // 정보를 정렬할 기준이 되는 문자열 sort_by

        if (ext.equals("code")) {
            for (int i = 0; i < data.length; i++) {
                if (data[i][0] < val_ext) {
                    answer.add(data[i]);
                }
            }
        } else if (ext.equals("date")) {
            for (int i = 0; i < data.length; i++) {
                if (data[i][1] < val_ext) {
                    answer.add(data[i]);
                }
            }
        } else if (ext.equals("maximum")) {
            for (int i = 0; i < data.length; i++) {
                if (data[i][2] < val_ext) {
                    answer.add(data[i]);
                }
            }
        } else {
            for (int i = 0; i < data.length; i++) {
                if (data[i][3] < val_ext) {
                    answer.add(data[i]);
                }
            }
        }

        if (sort_by.equals("code")) {
            Collections.sort(answer, Comparator.comparingInt(o -> o[0]));
        } else if (sort_by.equals("date")) {
            Collections.sort(answer, Comparator.comparingInt(o -> o[1]));

        } else if (sort_by.equals("maximum")) {
            Collections.sort(answer, Comparator.comparingInt(o -> o[2]));

        } else {
            Collections.sort(answer, Comparator.comparingInt(o -> o[3]));
        }
        return answer;
    }
}