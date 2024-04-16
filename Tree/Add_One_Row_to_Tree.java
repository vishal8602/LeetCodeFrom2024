package Tree;

import java.util.LinkedList;
import java.util.List;

class Solution_Add_One_Row_to_Tree {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        if(root==null) return root;
        if(depth==1) {
            TreeNode temp_root=new TreeNode(val);
            temp_root.left=root;
            return temp_root;
        }
        int level=0;
        List<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            level++;
           
            int n=queue.size();
            for(int i=0;i<n;i--){
                TreeNode top=queue.getFirst();
                queue.removeFirst();
                if(top.left!=null) queue.addLast(top.left);
                if(top.right!=null) queue.addLast(top.right);

                if(level==depth-1){
                    TreeNode left=new TreeNode(val);
                    left.left=top.left;

                    TreeNode right=new TreeNode(val);
                    right.right=top.right;

                    top.left=left;
                    top.right=right;

                }
            }
            if(level==depth-1) return root;

        }
        
        return null;
    }
}

public class Add_One_Row_to_Tree {
    public static void main(String[] args) {
        new Solution_Add_One_Row_to_Tree().addOneRow(new TreeNode(1), 12, 1);
    }
}
