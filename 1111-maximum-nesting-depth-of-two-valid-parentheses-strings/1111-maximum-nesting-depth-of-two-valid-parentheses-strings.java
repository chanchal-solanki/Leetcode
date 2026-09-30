class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for(int i =0; i<n; i++){
            char c = seq.charAt(i);
            if(c == '(') {
                if(st.isEmpty()) st.push(0);
                else {
                    if(st.peek() == 0) st.push(1);
                    else st.push(0);
                }
            }
            ans[i] = st.peek();
            if(c == ')') st.pop();
        } 
        return ans;
    }
}