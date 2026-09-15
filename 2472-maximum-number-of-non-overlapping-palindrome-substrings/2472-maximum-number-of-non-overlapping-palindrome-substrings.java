class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        if(n == 1 && k ==1) return 1;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return count(0,dp,Palindrome(s),n,k);

    }
    public int count(int i, int[] dp,boolean [][] p,int n,int k){
        if(i == n) return 0;
        if(dp[i] != -1) return dp[i];
        int notTake = count(i+1,dp,p,n,k);

        int take = 0;
        for(int j=i+k-1; j<n; j++){
            if(p[i][j]) take =  Math.max(take,1+count(j+1,dp,p,n,k));
        }
        return dp[i] = Math.max(notTake,take);
    }
    
    public boolean[][] Palindrome(String s){
        int n = s.length(); 
        boolean[][] p  = new boolean[n][n];

        for(int len = 1; len<=n; len++){
            for(int i=0; len+i-1<n; i++){
                int j = i+len-1;

                if(i == j) p[i][j] = true;
                else if(i+1 == j) p[i][j] = (s.charAt(i) == s.charAt(j));
                else p[i][j] = (s.charAt(i)==s.charAt(j) && p[i+1][j-1]);
            }
        }
        return p;
    }

}