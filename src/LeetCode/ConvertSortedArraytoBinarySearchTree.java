package LeetCode;

public class ConvertSortedArraytoBinarySearchTree {
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = null;
        for(int num : nums){
            TreeNode current = root;
            if( current == null)
                current.val = num;
            
        }
    }
}
