class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int i = s.length() -1;
        System.out.print(i);
        while(i>=0 && s.charAt(i) != ' ') i--;
        return s.length()-i-1;
    }
}