class Solution
{
    public static int solution(String s) {
        for(int end = s.length(); end > 1; end--) {
            for(int start = 0; end + start <= s.length(); start++) {
                if(check(s, start, start + end - 1)){
                    return end;
                }
            }
        }
        return 1;
    }


    public static boolean check(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}