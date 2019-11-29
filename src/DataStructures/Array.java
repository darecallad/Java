package DataStructures;

public class Array {


    private int[] items;
    private int count = 0;
    // to track the array size


    public Array(int length){
        items = new int[length];
    }

    public void print(){
        for(int i = 0; i< count ; i ++)
            System.out.println(items[i]);
    }

    public void insert(int item){
        //if array is full-> resize
        //add the new item at the of array
        if(items.length == count){
            //create new array and copy it
            int[] newItems = new int[count*2];
            for(int i = 0; i<count ; i ++)
                newItems[i] = items[i];
            // set old array to new array
            items = newItems;
        }
        items[count++] = item;
        // count is increasing after add item

    }
    public void removeAt(int index){
        //Validata the index
        if(index < 0 || index >= count)
            throw new IllegalArgumentException("wrong index");
        // shift the items to the left
        //[10,20,30]
        //[index:1
        //[10,30]
        for(int i = index; i < count; i ++)
            items[i] = items[i+1];
        count--;
    }

    public int indexOf(int item){
        // if we find it, return index
        // otherwise return -1
        //O(1)
        //worst O(n)
        for(int i = 0; i < count; i ++)
            if(items[i] == item)
                return i;
        return -1;
    }
}
