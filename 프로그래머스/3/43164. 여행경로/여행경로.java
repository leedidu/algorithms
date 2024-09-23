import java.util.*;
class Solution {
    static boolean[] visited;
    static ArrayList<String> allRoute;

    public static String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        allRoute = new ArrayList<String>();

        dfs("ICN", "ICN", 0, tickets);

        Collections.sort(allRoute);
        return allRoute.get(0).split(" ");
    }

    public static void dfs(String start, String route, int cnt, String[][] tickets){
        if(cnt == tickets.length){
            allRoute.add(route);
            return;
        }
        for(int i = 0; i < tickets.length; i++){
            if(start.equals(tickets[i][0]) && !visited[i]){
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], cnt + 1, tickets);
                visited[i] = false;
            }
        }
    }
}