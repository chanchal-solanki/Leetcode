class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int open = 0 ,close = 0 , res = 0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') open++;
            if(c == ')') close++;
            if(close>open) {
                open = 0;
                close = 0;
            }
            if(open == close)res = Math.max(res,close+open);
        }
        open = 0;
        close = 0;

        for(int i=n-1; i>=0; i--){
            char c = s.charAt(i);
            if(c == '(') open++;
            if(c == ')') close++;
            if(close < open) {
                open = 0;
                close = 0;
            }
            if(open == close) res = Math.max(res,close+open);
        }
        return res;
    }
}