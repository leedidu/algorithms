import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<String> routes;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        routes = new ArrayList<>();

        dfs("ICN", "ICN", 0, tickets);
        
        Collections.sort(routes);
        return routes.get(0).split(" ");
    }
    
    private void dfs(String start, String route, int cnt, String[][] tickets){
        if(cnt == tickets.length){
            routes.add(route);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++){
            if(!visited[i] && start.equals(tickets[i][0])){
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], cnt + 1, tickets);
                visited[i] = false;
            }
        }
    }
}