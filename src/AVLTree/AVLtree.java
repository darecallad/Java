package AVLTree;


public class AVLtree {
    private class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value){
            this.value = value;
        }
        private TreeNode root;
        public void treeInsert(int value){
            var node = new TreeNode(value);
            if(root == null)    root = node;
            var current = root;
            if(current != null){
                if(current.value > value){
                    if(current.left == null)
                        current.left = node;
                    else
                        current = current.left;
                }
                else{
                    if(current.right == null)
                        current.right = node;
                    else current = current.right;
                }
            }
        }
    }
}
