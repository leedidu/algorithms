import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int len = begin.length();
        
        boolean[] visited = new boolean[words.length];
        
        Queue<String[]> queue = new LinkedList<>();
        queue.offer(new String[]{begin, "0"});
        
        while(!queue.isEmpty()){
            String[] a = queue.poll();
            String n = a[0];

            String[] now = n.split("");
            
            if (n.equals(target)) {
                return Integer.parseInt(a[1]);
            }
            
            for(int i = 0; i < words.length; i++){
                if(!visited[i]){
                    int num = 0;
                    String[] al = words[i].split("");
                    for(int j = 0; j < len; j++){
                        if(!now[j].equals(al[j])){
                            num++;
                        }
                    }
                
                    if(num == 1){
                        visited[i] = true;
                        queue.offer(new String[]{words[i], String.valueOf(Integer.parseInt(a[1]) + 1)});
                    }                    
                }

            }
        }
        return 0;
    }
}