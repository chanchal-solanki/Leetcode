class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        int[] pair = new int[n];

        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(c == '(') {
                st.push(i);
            }else if(c == ')'){
                int j = st.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        int dir = 1,  i =0;

        while(i>=0 && i<n){
            char c = s.charAt(i);
            if( c == '(' || c == ')'){
                i = pair[i];
                dir = -dir;
            }else{
                sb.append(c);
            }
            i += dir;
        }
        return sb.toString();
    }
}