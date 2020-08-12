package Project.RedBlackTree;

import java.util.Stack;

public class RedBlackTree<T extends Comparable<T>>{
    // root, default size root is always black
    // root is always black //
    // root is always black //
    protected RBNode<T> root;
    protected int size = 0;

    // get root
    public RBNode<T> getRoot(){
        return this.root;
    }

    // function insert
    // check empty then insert then increase size

    public void insert(T keyvalue){
        if(this.isEmpty()){
            this.root = new RBNode<T>(keyvalue);
        }
        else{
            this.insert(this.root, keyvalue);
        }
        this.root.setColor(RBNode.BLACK);
        ++this.size;
    }

    // insert node with keyvalue
    private void insert(RBNode<T> node, T keyvalue){
        if(this.contains(keyvalue)){ // already had
            return;
        }
        // if enter value greater put the insert node to curr.left.left
        if(node.getData().compareTo(keyvalue) > 0){
            if(node.hasLeft()){
                this.insert(node.getLeft(), keyvalue);
            }
            // insert the node and check balance
            else{
                RBNode<T> inserted = new RBNode<T>(keyvalue);
                node.setLeft(inserted);
                this.balanceAfterInsert(inserted);
            }
        }
        // else right
        else if(node.hasRight()){
            this.insert(node.getRight(), keyvalue);
        }
        // inser right then check balance
        else{
            RBNode<T> inserted = new RBNode<T>(keyvalue);
            node.setRight(inserted);
            this.balanceAfterInsert(inserted);
        }
    }
/////////////////////////////////////////////////////////////////

    // remove (delete node)
    public void remove(T data){
        if(!this.contains(data)){ // not exist jus return
            return;
        }

        // check exist first
        RBNode<T> node = this.find(data);
        // case 3 BST
        if(node.getLeft() != null && node.getRight() != null){
            RBNode<T> successor = this.getSuccessor(node);
            node.setData(successor.getData());
            node = successor;
        }

        RBNode<T> pullUp = node.getLeft() == null ? node.getRight() : node.getLeft();
        if(pullUp != null){
            if(node == this.root){
                node.removeFromParent();
                this.root = node;
            }
            else if(RBNode.getLeft(node.getParent()) == node){
                node.getParent().setLeft(pullUp);
            }
            else{
                node.getParent().setRight(pullUp);
            }
            if(RBNode.isBlack(node)){
                this.balanceAfterDelete(pullUp);
            }
        }
        else if(node == this.root){
            this.root = null;
        }
        else{
            if(RBNode.isBlack(node)){
                this.balanceAfterDelete(node);
            }
            node.removeFromParent();
        }
    }
    ///////////////////////////////////////////////////////
    // easy function isempty
    public boolean isEmpty(){
        if(this.root == null){
            return true;
        }
        return false;
    }

    // function clear
    public void clear(){
        this.root = null;
    }

    // function get tree size
    public int getSize() {
        return this.size;
    }

/////////////////////////////////////////////////////////////////////
/////////////////////// Traversal part  ////////////////////////////

    public void inOrder() {
        this.inOrder(this.root);
    }

    // @SuppressWarnings({ "rawtypes", "unchecked" })
    @SuppressWarnings("rawtypes")
    private void inOrder(RBNode<T> node){

        if( node != null){
            Stack<RBNode> stack = new Stack<RBNode>();
            RBNode<?> node1 = node;
            while(node != null){
                stack.push(node1);
                node1 = node1.getLeft();
            }
            while(stack.size()>0){
                // visit the top node
                node1 = stack.pop();

                // System.out.println(node.element + " " + c + " "); // this always print the first node
                System.out.println(node1 + " ");
                if(node1.getRight() != null){
                    node1 = node1.getRight();
                    //visit the next left node
                    while(node1 != null){
                        stack.push(node1);
                        node1 = node1.getLeft();
                    }
                }
            }
        }
    }
    //inorder(n.left);
    //char c = 'B';
    //if(n.color == 0){
    //	c = 'R';

    // if (n != nil)
    // --------------- adjust later -----------------
    //System.out.println(n.element + " " + c + " ");
    //inorder(n.right);

    //private void inOrder(RBNode<T> node) {
    //  if (node != null) {
    //    this.inOrder(node.getLeft());
    //  System.out.print(node + " ");
    //this.inOrder(node.getRight());
    // }
    //}

    public void preOrder(){
        this.preOrder(this.root);
    }

    @SuppressWarnings("rawtypes")
    private void preOrder(RBNode<T> node){
        //if( n != nil){
        //char c = 'B';
        //if( n.color == 0){
        //	c = 'R';
        //}
        //System.out.println(n.element + " " + c + " ");
        //preorder(n.right);
        //}

        Stack<RBNode> stack2 = new Stack<RBNode>();
        stack2.push(node);
        while(!stack2.isEmpty()){
            // RBNode node = nodes.pop();
            RBNode<?> node1 = stack2.pop();
            System.out.println(node1 + " ");
            // if(current.right != nil)
            if(node1.getRight() != null){
                stack2.push(node1.getRight()); //pushing current instead of the node which is current
            }
            // if (current.left != nil)
            if(node1.getLeft() != null){
                stack2.push(node1.getLeft()); // should pushing current not the node current
            }
        }
    }
    ///////////// POSTORDER

    public void postOrder(){
        this.postOrder(this.root);
    }
    @SuppressWarnings("rawtypes")
    private void postOrder(RBNode<T> node){
        //if( n != nil){
        //postorder(n.left);
        //postorder(n.right);
        //char c = 'B';
        //if(n.color == 0){
        //	c = 'R';
        //}
        //System.out.println(n.element + " " + c + " ");
        //}
        RBNode<?> current = node;
        RBNode<?> previous = node;
        Stack<RBNode> stack3 = new Stack <RBNode>();
        if( node != null){
            stack3.push(node);
            while(!stack3.isEmpty()){
                current = stack3.peek();
                if(current == previous || current == previous.getRight()){
                    // traversing bottom
                    if(current.getLeft() != null){
                        stack3.push(current.getLeft());
                    }
                    else if(current.getRight() != null){
                        stack3.push(current.getRight());
                    }
                    if(current.getLeft() == null && current.getRight() == null){
                        stack3.pop();
                        System.out.println(node + " ");
                    }
                }
                else if(previous == current.getLeft()){
                    //traversing up from left side
                    if(current.getRight() != null){
                        stack3.push(current.getRight());
                    }
                    else if(current.getRight() == null){
                        RBNode<?> node1 = stack3.pop();
                        System.out.println(node1 + " ");
                    }
                }
                else if(previous == current.getRight()){
                    // traversing up from right side
                    RBNode<?> node1 = stack3.pop();
                    System.out.println(node1 + " ");
                }
                previous = current;
            }
        }
    }

//////////////////////////////////////////////////////////////////////////


    public boolean contains(T data){
        return this.contains(this.root, data);
    }

    private boolean contains(RBNode<T> root, T data){
        if(root == null){
            return false;
        }
        if(root.getData().compareTo(data) > 0){
            return this.contains(root.getLeft(), data);
        }
        if(root.getData().compareTo(data) < 0){
            return this.contains(root.getRight(), data);
        }
        return true;
    }
    // search function

    public RBNode<T> find(T data){
        return this.find(this.root, data);
    }

    private RBNode<T> find(RBNode<T> root, T data){
        if(root == null){
            return null;
        }
        if(root.getData().compareTo(data) > 0){
            return this.find(root.getLeft(), data);
        }
        if(root.getData().compareTo(data) < 0){
            return this.find(root.getRight(), data);
        }
        return root;
    }

    public int getDepth(){
        return this.getDepth(this.root);
    }

    private int getDepth(RBNode<T> node){
        if(node != null){
            int right_depth;
            int left_depth = this.getDepth(node.getLeft());
            return left_depth > (right_depth = this.getDepth(node.getRight())) ? left_depth + 1 : right_depth + 1;
        }
        return 0;
    }

    // check
    private RBNode<T> getSuccessor(RBNode<T> root){
        RBNode<T> leftTree = root.getLeft();
        if(leftTree != null){
            while (leftTree.getRight() != null){
                leftTree = leftTree.getRight();
            }
        }
        return leftTree;
    }
    // check balance after insert element
    // check from root to bottom
    // check keyvalue && color order
    // BST insert power point

    private void balanceAfterInsert(RBNode<T> node){
        if(node == null || node == this.root || RBNode.isBlack(node.getParent())){
            return;
        }
        if(RBNode.isRed(node.getUncle())){

            RBNode.toggleColor(node.getParent());
            RBNode.toggleColor(node.getUncle());
            RBNode.toggleColor(node.getGrandparent());
            this.balanceAfterInsert(node.getGrandparent());
        }
        else if(this.hasLeftParent(node)){

            if(this.isRightChild(node)){

                node = node.getParent();
                this.rotateLeft(node);
            }
            RBNode.setColor(node.getParent(), RBNode.BLACK);
            RBNode.setColor(node.getGrandparent(), RBNode.RED);
            this.rotateRight(node.getGrandparent());
        }
        else if(this.hasRightParent(node)){

            if(this.isLeftChild(node)){
                node = node.getParent();
                this.rotateRight(node);
            }
            RBNode.setColor(node.getParent(), RBNode.BLACK);
            RBNode.setColor(node.getGrandparent(), RBNode.RED);
            this.rotateLeft(node.getGrandparent());
        }
    }

    // check balance after delete node
    // same as after insert checking

    @SuppressWarnings("unchecked")
    private void balanceAfterDelete(RBNode<T> node){

        while(node != this.root && node.isBlack()){
            RBNode<T> sibling = node.getSibling();
            if(node == RBNode.getLeft(node.getParent())){

                if(RBNode.isRed(sibling)){

                    RBNode.setColor(sibling, RBNode.BLACK);
                    RBNode.setColor(node.getParent(), RBNode.RED);
                    this.rotateLeft(node.getParent());
                    sibling = (RBNode<T>) RBNode.getRight(node.getParent());
                }

                if(RBNode.isBlack(RBNode.getLeft(sibling)) && RBNode.isBlack(RBNode.getRight(sibling))){
                    RBNode.setColor(sibling, RBNode.RED);
                    node = node.getParent();
                    continue;
                }

                if(RBNode.isBlack(RBNode.getRight(sibling))){
                    RBNode.setColor(RBNode.getLeft(sibling), RBNode.BLACK);
                    RBNode.setColor(sibling, RBNode.RED);
                    this.rotateRight(sibling);
                    sibling = (RBNode<T>) RBNode.getRight(node.getParent());
                }

                RBNode.setColor(sibling, RBNode.getColor(node.getParent()));
                RBNode.setColor(node.getParent(), RBNode.BLACK);
                RBNode.setColor(RBNode.getRight(sibling), RBNode.BLACK);
                this.rotateLeft(node.getParent());
                node = this.root;
                continue;
            }
            if(RBNode.isRed(sibling)){
                RBNode.setColor(sibling, RBNode.BLACK);
                RBNode.setColor(node.getParent(), RBNode.RED);
                this.rotateRight(node.getParent());
                sibling = (RBNode<T>) RBNode.getLeft(node.getParent());
            }
            if(RBNode.isBlack(RBNode.getLeft(sibling)) && RBNode.isBlack(RBNode.getRight(sibling))){
                RBNode.setColor(sibling, RBNode.RED);
                node = node.getParent();
                continue;
            }
            if(RBNode.isBlack(RBNode.getLeft(sibling))){
                RBNode.setColor(RBNode.getRight(sibling), RBNode.BLACK);
                RBNode.setColor(sibling, RBNode.RED);
                this.rotateLeft(sibling);
                sibling = (RBNode<T>) RBNode.getLeft(node.getParent());
            }
            RBNode.setColor(sibling, RBNode.getColor(node.getParent()));
            RBNode.setColor(node.getParent(), RBNode.BLACK);
            RBNode.setColor(RBNode.getLeft(sibling), RBNode.BLACK);
            this.rotateRight(node.getParent());
            node = this.root;
        }
        RBNode.setColor(node, RBNode.BLACK);
    }

    // Rotate right // Rotate left
    private void rotateRight(RBNode<T> node){
        if(node.getLeft() == null){
            return;
        }
        RBNode<T> leftTree = node.getLeft();
        node.setLeft(leftTree.getRight());
        if(node.getParent() == null){
            this.root = leftTree;
        }
        else if(node.getParent().getLeft() == node){
            node.getParent().setLeft(leftTree);
        }
        else{
            node.getParent().setRight(leftTree);
        }
        leftTree.setRight(node);
    }

    private void rotateLeft(RBNode<T> node){
        if(node.getRight() == null){
            return;
        }
        RBNode<T> rightTree = node.getRight();
        node.setRight(rightTree.getLeft());
        if(node.getParent() == null){
            this.root = rightTree;
        }
        else if(node.getParent().getLeft() == node){
            node.getParent().setLeft(rightTree);
        }
        else{
            node.getParent().setRight(rightTree);
        }
        rightTree.setLeft(node);
    }

    /////////////////////
    // parent checking
    private boolean hasRightParent(RBNode<T> node){
        if(RBNode.getRight(node.getGrandparent()) == node.getParent()){
            return true;
        }
        return false;
    }

    private boolean hasLeftParent(RBNode<T> node){

        if (RBNode.getLeft(node.getGrandparent()) == node.getParent()){
            return true;
        }
        return false;
    }

    /////////////////////
    //children checking
    private boolean isRightChild(RBNode<T> node){
        if(RBNode.getRight(node.getParent()) == node){
            return true;
        }
        return false;
    }

    private boolean isLeftChild(RBNode<T> node){
        if(RBNode.getLeft(node.getParent()) == node){
            return true;
        }
        return false;
    }
}