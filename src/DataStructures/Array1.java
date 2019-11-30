package DataStructures;

public class Array1 {
    private int count = 0 ;
    private int[] items;
    public Array1(int length) {
        items = new int[length];
    }

    public void print() {
        for(int i=0; i < count; i ++)
            System.out.println(items[i]);
    }

    public void insert(int item) {
        if(items.length == count){
           int[] newItem = new int[count*2];
           for(int i =0; i < count; i ++)
               newItem[i] = items[i];
           items = newItem;
        }
        items[count++] = item;
    }

    public void removeAt(int index) {
        if(index <0 || index >= count)
            throw new IllegalArgumentException();
        for(int i =index; i < count ; i ++)
            items[i] = items[i+1];
        count--;
    }

    public int indexOf(int item) {
        for(int i =0; i < count; i ++){
            if(items[i] == item)
                return i;
        }
        return -1;

    }

    public int max() {
        int result=0;
        for(int i =0; i < count; i ++){
            if(items[i] > items[i+1])
                result = items[i];
            else result = items[i+1];
        }
        return result;
    }

    public void reverse() {
        for(int i = count-1 ; i >= 0; i--){
            System.out.println(items[i]);
        }
    }

    public void insertAt(int item, int index) {
        if(items.length == count) {
            int[] newItem = new int[count * 2];
            for (int i = 0; i < count; i++)
                newItem[i] = items[i];
            items = newItem;
        }
        for(int i= count; i>=index; i--){
            items[i] = items[i-1];
        }
        items[index] = item;
        count++;
    }
}
