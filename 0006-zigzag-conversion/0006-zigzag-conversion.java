class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || s.length() == 1) return s;
        int n = s.length();

        int[] index = new int[n];
        int row = -1;
        boolean down = true;

        for(int i=0; i<n; i++){
            if(down){
                row++;
                if(row == numRows-1) down = false;
            }
            else{
                row--;
                if(row == 0) down = true;
            }
            index[i] = row;
            System.out.println(row);
        }

        StringBuilder ans = new StringBuilder();
        row = 0;

        while(row<numRows){
            for(int i=0; i<n; i++){
                if(row == index[i]) ans.append(s.charAt(i));
            }
            row++;
        }
        return ans.toString();
    }
}