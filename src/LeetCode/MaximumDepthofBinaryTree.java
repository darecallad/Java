package LeetCode;

public class MaximumDepthofBinaryTree {
    //Given a binary tree, find its maximum depth.
    //
    //The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
    //
    //Note: A leaf is a node with no children.
    //
    //Example:
    //
    //Given binary tree [3,9,20,null,null,15,7],
    //
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //return its depth = 3.
    public int maxDepth(TreeNode root) {
        if(root == null)    return  0;
        else{
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return Math.max(left_height,right_height) + 1;
        }
    }

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
}