class Solution {
    public int minAddToMakeValid(String s) {
        // int balance = 0;
        // int res = 0;
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i) ;
            if(c == ')'){
                if(!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                    continue;
                }
                
            }
            st.push(c);
        }
        return st.size();
    }
}