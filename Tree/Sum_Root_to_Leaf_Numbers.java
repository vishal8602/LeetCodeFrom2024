package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class NodeWithDepth {
    int node;
    int depth;

    public NodeWithDepth(int node, int depth) {
        this.node = node;
        this.depth = depth;
    }

}

class Solution {

    public List<NodeWithDepth> dfs(TreeNode node) {
        if (node == null) {
            return new ArrayList<NodeWithDepth>();
        }
        if (node.left == null && node.right == null) {
            return new ArrayList<>(Arrays.asList(new NodeWithDepth(node.val, 1)));
        }
        List<NodeWithDepth> left = dfs(node.left);
        List<NodeWithDepth> right = dfs(node.right);
        List<NodeWithDepth> result = new ArrayList<>();
        for (NodeWithDepth i : left) {
            result.add(new NodeWithDepth((int) (node.val * Math.pow(10, i.depth)) + i.node, i.depth + 1));
        }
        for (NodeWithDepth i : right) {
            result.add(new NodeWithDepth((int) (node.val * Math.pow(10, i.depth)) + i.node, i.depth + 1));
        }
        return result;
    }

    public int sumNumbers(TreeNode root) {
        List<NodeWithDepth> result = dfs(root);
        int sum = 0;
        for (NodeWithDepth i : result) {
            sum += i.node;
        }
        return sum;
    }
}

public class Sum_Root_to_Leaf_Numbers {

}
