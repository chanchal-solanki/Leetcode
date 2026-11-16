class Solution {
    public String digitSum(String s, int k) {
        
        while(s.length() > k){
            StringBuilder next = new StringBuilder();
            int sum = 0;

            for(int i = 0; i<s.length(); i++){
                if(i!=0 && i%k == 0) {
                    next.append(sum);
                    sum = 0;
                }
                sum += s.charAt(i)-'0';
            }
            next.append(sum);
            s = next.toString();
        }
        return s;
    }
}