class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        int n = s.length();

        StringBuilder sb = new StringBuilder();
        int i  = n-1 , j = n-1;

        while(i>=0){
            while(i>=0 && s.charAt(i) != ' ') i--;
            sb.append(s.substring(i+1,j+1)).append(" ");
            while(i>=0 && s.charAt(i) == ' ') i--;
            j=i;
        }
        return sb.toString().trim();
    }
}