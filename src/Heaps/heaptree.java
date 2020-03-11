package Heaps;

public class heaptree {
    // heap property every parent are greater than children
    // binary tree
    // calculate child -> left : parent *2 +1
    //                    right: parent *2 +2

    private int[] items = new int[10];
    private int size;

    public void insert(int value){
        if(isFull())
            throw new IllegalArgumentException();

        items[size++] = value;
        bubbleup();

        // new item > parent
    }
    public boolean isFull(){
        return size == items.length;
    }
    private void bubbleup(){
        var index = size -1;

        while(index > 0 && items[index] > items[parent(index)]){
            swqp(index, parent(index));
            index = parent(index);
        }

    }
    private int parent(int index){
        return (index-1)/2;
    }
    private void swqp(int first, int second){
        int temp;
        temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }

    public void remove(){
        if(isEmpty())
            throw new IllegalArgumentException();

        items[0] = items[--size];
        // item (root) < children
        var index = 0;
        while(!isVAlidParent(index)){
        var largerChildIndex = largerChildIndex(index);
            swqp(index,largerChildIndex);
            index = largerChildIndex;


        }
    }
    public boolean isEmpty(){
       return size == 0;
    }
    private int largerChildIndex(int index){
        if(!hasLeftChild(index))    return index;
        if(!hasRightChild(index))   return  leftChildIndex(index);

        return (leftChild(index) > rightChild(index)) ?
                    leftChildIndex(index) : rightChildIndex(index);

    }
    private boolean hasLeftChild(int index){
        return leftChildIndex(index) <= size;
    }
    private boolean hasRightChild(int index){
        return rightChildIndex(index) <=size;
    }
    private boolean isVAlidParent(int index){
        if(!hasLeftChild(index))    return true;
        if(!hasRightChild(index))   return items[index] >= leftChild(index);
        return items[index] >= leftChild(index) && items[index] >= rightChild(index);
    }
    private int rightChild(int index){
        return items[rightChildIndex(index)];
    }
    private int leftChild(int index){
        return items[leftChildIndex(index)];
    }
    private int leftChildIndex(int index){
        return index *2 +1;
    }
    private int rightChildIndex(int index){
        return index * 2 +2;
    }
}
