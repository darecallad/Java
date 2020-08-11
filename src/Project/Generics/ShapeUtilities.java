package Project.Generics;
import java.util.ArrayList;
import java.util.Iterator;
// https://www.tutorialspoint.com/java/java_using_iterator.htm

public class ShapeUtilities {
    // recursiveSort()
    // This method takes an ArrayList of Bounded Generic type and
    // sorts it based on the volumes of the objects using the following algorithm.
    // The bound should only allow any Shape object and subclasses.
    public static <T extends Shape> ArrayList<T> recursiveSort(ArrayList<T> list){

        if(list != null && list.size() <= 1){
            return list; // if the list size <= 1
            //return list
        }
        else{			 // else select a middle element from the list and remove it
            int mid = list.size()/2;
            double midVolume = list.get(mid).getVolume();

            // creat 2 lists leftlist and rightlist
            ArrayList<T> leftList = new ArrayList<>();
            ArrayList<T> rightList = new ArrayList<>();

            Iterator<T> iterator = list.iterator();

            int i = 0;
            // if element is less than the middle element then add element to the right
            // else add to left
            while(iterator.hasNext()){ // object next() return next element
                T current = iterator.next();
                if (i != mid) {
                    if (current.getVolume() < midVolume){
                        rightList.add(current);
                    }
                    else{
                        leftList.add(current);
                    }
                }
                i++; // till string end;
            }

            leftList = recursiveSort(leftList);
            rightList = recursiveSort(rightList);

            ArrayList<T> result = new ArrayList<>();
            result.add(list.get(mid));

            if(leftList.size()>0){ // add result to leftlist
                leftList.addAll(result);
                result = leftList;
            }
            else if(rightList.size()>0){ // else do add on rightlist
                result.addAll(rightList);
            }

            return result; // return the combination of recursiveSort
        }

    }
    // min();
    // This method takes an ArrayList of Bounded Generic Type which only allows Shape objects and its subclasses.
    // The method should return the object with the maximum volume from the list of objects.
    public static <T extends Shape> T min(ArrayList<T> list){

        if(list != null && list.size() != 0){

            Iterator<T> iterator = list.iterator();
            //T minVolumeShape = list.get(0);
            T minVolumeShape = null;

            if(iterator.hasNext()){
                minVolumeShape = iterator.next();
            }
            while(iterator.hasNext()){
                T currentShape = iterator.next();

                if(currentShape.getVolume() < minVolumeShape.getVolume()){
                    minVolumeShape = currentShape;
                }
            }
            // return the minimum volume from the list of obj
            return minVolumeShape;
        }
        else return null;
    }//

    // max();
    // This method takes an ArrayList of Bounded Generic Type which only allows Shape objects and its subclasses.
    // The method should return the object with the minimum volume from the list of objects.
    public static <T extends Shape> T max(ArrayList<T> list){

        if (list != null && list.size() != 0) {

            Iterator<T> iterator = list.iterator();
            ///T maxVolumeShape = list.get(0);
            T maxVolumeShape = null;

            if(iterator.hasNext()){
                maxVolumeShape = iterator.next();
            }
            while (iterator.hasNext()) {

                T currentShape = iterator.next();

                if (currentShape.getVolume() > maxVolumeShape.getVolume()) {
                    maxVolumeShape = currentShape;
                }
            }
            // return the maximum volume from the list of obj
            return maxVolumeShape;
        }
        else return null;
    }// same as min


}