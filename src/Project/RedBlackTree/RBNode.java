package Project.RedBlackTree;

import java.awt.Color;

public class RBNode<T extends Comparable<T>>{
    // Colors with boolean value F = RED  T = BLACK
    // I changed it to boolean because its easy to set color in RBTree
    public static boolean RED = false;
    public static boolean BLACK = true;
    //
    //

    private boolean color = RED;
    private RBNode<T> left;
    private RBNode<T> right;
    private RBNode<T> parent;
    private T data;


    //////////////////////////////////////////////////////////
    ///////////////         Constructor      /////////////////
    //////////////////////////////////////////////////////////

    public RBNode(){

    }
    // constructor
    public RBNode(T data){
        this.data = data;
    }
    // set Date
    public void setData(T data){
        this.data = data;
    }
    // get Data
    public T getData(){
        return data;
    }
    // get left
    public RBNode<T> getLeft(){
        return left;
    }
    // get right
    public RBNode<T> getRight(){
        return right;
    }

    // has left
    public boolean hasLeft(){
        return left != null;
    }

    // has right
    public boolean hasRight(){
        return right != null;
    }
    //////////////////////////////////////////////////////////
    ////////////           Functions       ///////////////////
    //////////////////////////////////////////////////////////


    // set left
    public void setLeft(RBNode<T> child) {

        // Re-arranging the parents
        if(getLeft() != null){
            getLeft().setParent(null);
        }

        if(child != null){
            child.removeFromParent();
            child.setParent(this);
        }

        this.left = child;
    }

    // set right
    public void setRight(RBNode<T> child) {

        // Re-arranging the parents
        if(getRight() != null){
            getRight().setParent(null);
        }

        if(child != null){
            child.removeFromParent();
            child.setParent(this);
        }

        this.right = child;
    }
    // (Remove current node from parent)
    public void removeFromParent(){
        if(getParent() == null){   //none parent
            return;
        }

        // Remove current node's from the parent
        if(parent.getLeft() == this){
            parent.setLeft(null);
        }
        else if(parent.getRight() == this){
            parent.setRight(null);
        }

        this.parent = null;
    }
    //////////////////////////////////////////////////////////

    // ?´æŽ¥ç¹¼æ‰¿ ?–è? ?“æŽ¥ ç¹¼æ‰¿ <?> ä¹Ÿå°±?¯æ?è¬‚ç?æ³›è? ?ƒæ•¸
    // ä¹Ÿå°±?¯Object ?„é?è¡Œè???
    // extend data
    public static RBNode<?> getLeft(RBNode<?> node){
        return node == null ? null : node.getLeft();
    }

    public static RBNode<?> getRight(RBNode<?> node){
        return node == null ? null : node.getRight();
    }


    @Override
    public String toString(){
        return data.toString();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static int compare(RBNode<?> node, Comparable<?> b){
        return ((Comparable) node.getData()).compareTo(b);
    }

    // Functions for RED BLACK nodes
    // Detected RED || BLACK

    public boolean isRed(){
        return getColor() == RED;
    }

    public boolean isBlack(){
        return !isRed();
    }

    public static boolean isRed(RBNode<?> node){
        return getColor(node) == RED;
    }

    public static boolean isBlack(RBNode<?> node){
        return !isRed(node);
    }
    // set color
    public void setColor(boolean color){
        this.color = color;
    }

    public static void setColor(RBNode<?> node, boolean color){
        if(node == null){
            return;
        }
        node.setColor(color);
    }
    // get color
    public boolean getColor(){
        return color;
    }

    public static boolean getColor(RBNode<?> node){
        // nil node is considered to be black
        return node == null ? BLACK : node.getColor();
    }

    public Color getActualColor(){
        if(isRed()){
            return new Color(250, 70, 70);
        }
        else{
            return new Color(70, 70, 70);
        }

    }

    public void toggleColor(){
        color = !color;
    }

    public static void toggleColor(RBNode<?> node){
        if (node == null){
            return;
        }

        node.setColor(!node.getColor());
    }
    // set parent
    // get parent

    public void setParent(RBNode<T> parent){
        this.parent = parent;
    }

    public RBNode<T> getParent(){
        return parent;
    }

    public static RBNode<?> getParent(RBNode<?> node){
        return (node == null) ? null : node.getParent();
    }

    public RBNode<T> getGrandparent(){
        RBNode<T> parent = getParent();
        return (parent == null) ? null : parent.getParent();
    }

    public static RBNode<?> getGrandparent(RBNode<?> node){
        return (node == null) ? null : node.getGrandparent();
    }
    // check sibling

    public RBNode<T> getSibling(){
        RBNode<T> parent = getParent();
        if (parent != null){ // No sibling of root node
            if (this == parent.getRight()){
                return (RBNode<T>) parent.getLeft();
            }
            else{
                return (RBNode<T>) parent.getRight();
            }
        }
        return null;
    }

    public static RBNode<?> getSibling(RBNode<?> node){
        return (node == null) ? null : node.getSibling();
    }
    // check UNcle
    // public RBNode getuncle
    public RBNode<T> getUncle(){
        RBNode<T> parent = getParent();
        if (parent != null){ // No uncle of root
            return parent.getSibling();
        }
        return null;
    }
    // public static RBNode getUncle
    public static RBNode<?> getUncle(RBNode<?> node){
        return (node == null) ? null : node.getUncle();
    }

}