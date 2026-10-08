class Solution {
    public String removeOuterParentheses(String s) {
        int i = 0;
        int balance = 0;
        StringBuilder sb = new StringBuilder();

        for(int j=0; j<s.length(); j++){
            char c = s.charAt(j);
            if(c == '(') balance ++;
            else balance--;

            if(balance == 0) {
                sb.append(s.substring(i+1,j));
                i = j+1;
            }
        }
        return sb.toString();
    }
}