class Solution {
    public boolean uniformArray(int[] nums1) {
        int smallest_Odd = Integer.MAX_VALUE ;

        for(int num : nums1){
            if(num%2 != 0) 
                smallest_Odd = Math.min(smallest_Odd,num);
        } 

        if(smallest_Odd ==Integer.MAX_VALUE ) return true;
      
        for(int num : nums1){
            if(num%2 == 0 && num < smallest_Odd )  return false;  
        }

        return true;
    }
}