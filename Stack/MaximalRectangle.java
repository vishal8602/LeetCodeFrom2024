package Stack;

import java.util.Stack;
class Solution {
    public int[] nextSmallerToRight(int[] a) {
        int []result=new int[a.length];
        Stack<Integer> s = new Stack<>();
        for (int i = a.length-1; i >= 0; i--) {
            while (!s.empty() && a[s.peek()] >= a[i]) {
                s.pop();
            }
            result[i] = (s.isEmpty()) ? a.length : s.peek();
            s.push(i);
        }
        return result;
    }

    public int[] nextSmallerToleft(int[] a) {
        int []result=new int[a.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            while (!s.empty() && a[s.peek()] >= a[i]) {
                s.pop();
            }
            result[i] = (s.isEmpty()) ? -1 : s.peek();
            s.push(i);
        }
        return result;
    }

    public int maximumRectangleAtEachRowLevel(int[] a) {
        int ans=0;
        int [] leftMin=nextSmallerToleft(a);
        int [] rightMin=nextSmallerToRight(a);
        for(int i=0;i<a.length;i++){
                ans=Math.max(ans,a[i]*(rightMin[i]-leftMin[i]-1));
        }
        return ans;
    }

    public int maximalRectangle(char[][] matrix) {
        int ans=0;
        int [][]modifyMatrix=new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            
            for (int j = 0; j < matrix[0].length; j++) {
        
            modifyMatrix[i][j]=(matrix[i][j]=='1') ?1:0;
        }
    }
        for (int i = 0; i < matrix.length; i++) {
            
            for (int j = 0; j < matrix[0].length; j++) {
    
                if(matrix[i][j]=='1'){
                    modifyMatrix[i][j]+= (i-1>=0)?modifyMatrix[i-1][j]:0;
                }
                else{
                    modifyMatrix[i][j]=0;
                }
            }
            // for(int x:modifyMatrix[i]) System.out.print(x+" ");
            // System.out.println();
            ans=Math.max(maximumRectangleAtEachRowLevel(modifyMatrix[i]), ans);
        }

        return ans;
    }
}
public class MaximalRectangle {
   public static void main(String[] args) {
    char [][] matrix=new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
    int result=new Solution().maximalRectangle(matrix);
    System.out.print(result);
   }
}
