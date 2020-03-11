package Heaps;

public class MaxHeap {
    public static void heapify(int[] array){
        for(int i = 0; i < array.length; i ++){
            heapify(array,i);
        }
    }
    private static void heapify(int[] array, int index){
        var largetindex = index;

        var leftIndex = index * 2 +1;
        if(leftIndex < array.length && array[leftIndex] > array[largetindex])
            largetindex = leftIndex;

        var rightIndex = index * 2 + 2;
        if(rightIndex < array.length && array[rightIndex] > array[largetindex])
            largetindex = rightIndex;

        if(index == largetindex)    return;
        swap(array, index, largetindex);
        heapify(array,largetindex);

    }
    private  static void swap(int[] array, int first, int second){
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
