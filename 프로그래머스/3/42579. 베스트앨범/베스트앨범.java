import java.util.*;

class Solution {
    public static ArrayList<Integer> solution(String[] genres, int[] plays) {

        ArrayList<Integer> answer = new ArrayList<>();

        // 장르 > 노래 > 고유번호


        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < genres.length; i++) { // 장르별 재생수 저장
            Integer num = map.getOrDefault(genres[i], 0);
            map.put(genres[i], num + plays[i]);
        }

        ArrayList<String> songs = new ArrayList<>();
        songs.addAll(map.keySet());
        songs.sort((o1, o2) -> map.get(o2) - map.get(o1)); // 장르별 재생수 총합으로 내림차순 정렬

        Map<String, ArrayList<Integer>> songMap = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            ArrayList<Integer> values = songMap.getOrDefault(genres[i], new ArrayList<>());
            values.add(i);
            songMap.put(genres[i], values);
        }

        for (Map.Entry<String, ArrayList<Integer>> entry : songMap.entrySet()) {
            ArrayList<Integer> indices = entry.getValue();

            // 인덱스를 plays 배열의 값에 따라 정렬
            indices.sort((a, b) -> Integer.compare(plays[b], plays[a]));
        }

        for (String genre : songs) { // 장르별로 두곡씩
            ArrayList<Integer> indices = songMap.get(genre); // 해당 장르의 곡 리스트
            for (int i = 0; i < Math.min(2, indices.size()); i++) { // 최대 2곡만 추가
                answer.add(indices.get(i));
            }
        }
        return answer;
    }
}