class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        ArrayList<Integer> ans = new ArrayList<>();

        int sum = 0;
        int carry = 1;

        for(int i=n-1; i>=0; i--){
            sum = digits[i] + carry;
            carry = sum/10;
            ans.add(sum%10);
        }
        
        if(carry != 0) ans.add(carry);

        n = ans.size();
        int[] res = new int[n];

        for(int i=0; i<n; i++){
            res[i] = ans.get(n-i-1);
        } 

        return res;  
    }
}