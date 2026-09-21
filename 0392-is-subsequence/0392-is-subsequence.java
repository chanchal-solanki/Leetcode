class Solution {
    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();

        if(m == 0) return true;

        if(m>n) return false;

        int i =0;
        for(int j=0; j<n; j++){
            if(s.charAt(i) == t.charAt(j)) i++;
            if(i == m) return true;
        }
        return false;
    }
}