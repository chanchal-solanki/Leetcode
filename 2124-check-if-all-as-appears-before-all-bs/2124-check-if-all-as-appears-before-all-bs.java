class Solution {
    public boolean checkString(String s) {
        int countB = 0;

        for(char c : s.toCharArray()){
            if(c == 'a' && countB != 0) return false;
            if(c == 'b') countB++;
        }
        return true;
    }
}