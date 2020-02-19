package LeetCode;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII {
    //Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
    //
    //For example:
    //Given binary tree [3,9,20,null,null,15,7],
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //return its bottom-up level order traversal as:
    //[
    //  [15,7],
    //  [9,20],
    //  [3]
    //]
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if(root==null){
                return res;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while(!queue.isEmpty()){
                int size = queue.size();

                List<Integer> list = new ArrayList<>();

                for(int i=0; i<size; i++){
                    TreeNode cur = queue.poll();

                    list.add(cur.val);

                    if(cur.left!=null){
                        queue.offer(cur.left);
                    }

                    if(cur.right != null){
                        queue.offer(cur.right);
                    }
                }

                res.add(list);

            }

            // the result is from top to bottom(which is the anwser of leetcode 102)
            // reverse the list, so the final result is from bottom to top
            Collections.reverse(res);

            return res;
        
    }
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x){
            x = val;
        }
    }
}
