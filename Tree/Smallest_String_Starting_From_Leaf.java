
package Tree;

class Solution {
    private String ans = "{";

    public void backTrack(TreeNode root, String result) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            String temp=String.valueOf((char) ('a' + root.val)) + result;
            ans=ans.compareTo(temp)>0?temp:ans;
        }
        backTrack(root.left,result+(char) ('a' + root.val));
        backTrack(root.right,result+ (char) ('a' + root.val));

    }

    public String smallestFromLeaf(TreeNode root) {
        backTrack(root, "");
        return ans;
    }
}

public class Smallest_String_Starting_From_Leaf {

}
