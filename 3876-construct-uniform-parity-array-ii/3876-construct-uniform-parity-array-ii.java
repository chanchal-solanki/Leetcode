class Solution {
    public boolean uniformArray(int[] nums1) {
        boolean isOdd = true;
        boolean isEven = true;
        int smallest_Odd = Integer.MAX_VALUE ;

        for(int num : nums1){
            if(num%2 == 0) isOdd = false;
            if(num%2 != 0) {
                isEven = false;
                smallest_Odd = Math.min(smallest_Odd,num);
            }
        } 

        if(isOdd || isEven) return true;
      
        for(int num : nums1){
            if(num%2 == 0) {
                if(num -smallest_Odd < 0 ) return false;
            }
        }

        return true;
    }
}