class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                st.push(c);
            }else{
                if(st.isEmpty()) return false;

                char peek =st.pop();
                if((peek == '(' && c != ')') || (peek == '{' && c != '}') || (peek == '[' && c != ']')) return false;
            }
        }
        return st.isEmpty();
    }
}