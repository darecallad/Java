package DataStructures.binarytree;

public class TreeMain {
    public static void main(String[] args){
        binarySearchTree tree = new binarySearchTree();
        tree.insertTree(30);
        tree.insertTree(20);
        tree.insertTree(10);
        tree.insertTree(15);
        tree.insertTree(25);
//        tree.traversePreOrder();
//        System.out.println(tree.height());
//        System.out.println(tree.min());
        binarySearchTree tree2 = new binarySearchTree();
        tree2.insertTree(30);
        tree2.insertTree(20);
        tree2.insertTree(10);
        tree2.insertTree(15);
        tree2.insertTree(25);

        System.out.println(tree.equals(tree2));
    }
}
