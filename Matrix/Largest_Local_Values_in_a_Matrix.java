package Matrix;
class Solution {
    public int[][] largestLocal(int[][] grid) {
        int result[][]=new int[grid.length-2][grid[0].length-2];
        
        for(int i=0;i<grid.length-2;i++){
            for(int j=0;j<grid[0].length-2;j++){
                int max_num=0;
                for(int k=i;k<i+3;k++){
                    for(int l=j;l<j+3;l++){
                      max_num=Math.max(max_num, grid[k][l]);
                    }
                }
                result[i][j]=max_num;
            }
        }
        return result;
    }
}
public class Largest_Local_Values_in_a_Matrix {
    
}
