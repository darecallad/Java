package Heaps;

public class heapmain {
    public static  void main(String[] args){
        var heap = new heaptree();
        heap.insert(10);
        heap.insert(20);
        heap.insert(30);
        int[] numbers = {5,3,8,4,2,1};
        MaxHeap.heapify(numbers);
    }
}
