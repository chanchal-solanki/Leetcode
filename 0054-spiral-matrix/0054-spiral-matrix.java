class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> spiral = new ArrayList<>();

        int firstRow  = 0 , firstCol = 0 , lastRow = m-1 , lastCol = n-1;

        while(firstRow <= lastRow && firstCol <= lastCol){
           
            for(int j=firstCol; j<=lastCol; j++){
                spiral.add(matrix[firstRow][j]);
            }
            firstRow++;
            
            for(int i=firstRow; i<=lastRow; i++){
                spiral.add(matrix[i][lastCol] ); 
            }
            lastCol--;
           
            if(firstRow <= lastRow) {
                for(int j = lastCol; j>=firstCol; j--){
                    System.out.print(matrix[lastRow][j] +" ");
                    spiral.add(matrix[lastRow][j]);
                }
                lastRow--;
             }
           
            if(firstCol <= lastCol) { 
                for(int i = lastRow; i>=firstRow; i--){
                    System.out.print(matrix[i][firstCol] +" ");
                    spiral.add(matrix[i][firstCol]);   
                }
                firstCol++;
            }    
        }

        return spiral;
    }
}