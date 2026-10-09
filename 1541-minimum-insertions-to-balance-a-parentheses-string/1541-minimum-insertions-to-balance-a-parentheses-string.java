class Solution {
    public int minInsertions(String s) {
        int n= s.length();
        int res =0;
        int count = 0;
        int i =0;
       while(i<n){
            char c = s.charAt(i);
            if(c == '(') count++ ;
            else{
                if(count > 0)   count--;
                else res += 1;
                
                if(i<n-1 && s.charAt(i+1) == ')') i++;   
                else  res += 1; 
            }
            i++;   
        } 
        
        return res + count*2;   
    }
}