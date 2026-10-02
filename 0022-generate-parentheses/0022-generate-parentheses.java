class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        solve(n,0,0,new StringBuilder());
        return ans;
    }

    private void solve(int n , int open , int close , StringBuilder sb){
        if(sb.length() == 2*n) {
            if(open == close) ans.add(sb.toString());
            return;
        }

        if(open < n){
            sb.append('(');
            solve(n,open+1, close, sb);
            sb.deleteCharAt(sb.length()-1);
        }
  
        if(open <= close) return;

        sb.append(')');
        solve(n,open,close+1, sb);
        sb.deleteCharAt(sb.length()-1);
    
    }
}