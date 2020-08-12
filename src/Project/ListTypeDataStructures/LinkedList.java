package Project.ListTypeDataStructures;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//functions
//head, size(total number), category1Label(read only), category2Label, category3Label, groupingCategory
//add(value1, value2, value3)  \\ done
//clear();   \\ done
//deleteFirst(); \\ done
//deleteLast();  \\ not yet
//delete(mainIndex, subIndex); \\ not yet
//get(mainIndex, category); \\ not yet
//get(mainIndex, subIndex, category); \\ not yet
//regroup(groupingCategoryNumber);  \\ not yet
//size(); // done
//size(index); // not yet

public class LinkedList<Tier1, Tier2, Tier3>{

    private Node<Tier1, Tier2, Tier3> head;
    // the head of linked lists
    private int size = 0;
    // total number of element in the main and sublists
    private int groupingCategory;
    // category number ---> list
    //private Tier1 category1Label;
    //private Tier2 category2Label;
    //private Tier3 category3Label;
    private String category1Label, category2Label, category3Label;
    // labels for 3 cates

// ------------------------------------------------------------------
    // Constructor
    // This class shall have one no-arg constructor which creates an empty list.
    // This class shall have one constructor which takes an integer parameter,
    // which is the number of the current category upon which you want your list to group.  This constructor should also create an empty list.
    // This class shall have one constructor which takes a File object parameter and an integer parameter.
    // This File is the input file from which a list can be generated and populated.
    // The integer parameter is the current grouping property.
    // See below for the required format of the input file.
    // This constructor should take the File and create a list based on the values in the File.
// ------------------------------------------------------------------

    public LinkedList(){
        this.head = null;
        groupingCategory = 1; // set default
    }

    public LinkedList(int currCategory){
        this.groupingCategory = currCategory;
    }

    public LinkedList(File file, int currCategory)throws FileNotFoundException{
        this.groupingCategory = currCategory;
        //read file
        // ************* unfinished *************
    }

    public void add(Tier1 value1, Tier2 value2, Tier3 value3){
        Node<Tier1,Tier2,Tier3>node = new Node<Tier1, Tier2, Tier3> (value1, value2, value3);
        // test
        // system.out.println(node);

        if( head == null){ // empty list
            head = node;
        }

        else{
            Node<Tier1, Tier2, Tier3> p = head; // from beginnnnnnng
            boolean inserted = false;
            while(!inserted){
                if(
                    // if groupingCategory == 1 and node's category also matches or
                    // if groupingCategory == 2 and node's category also matches or
                    // .......................3..................................
                        (groupingCategory==1 && p.getCategory1().equals(node.getCategory1())) ||     // ??? change static?  fixed
                                (groupingCategory==2 && p.getCategory2().equals(node.getCategory2())) ||	  // node != Node
                                (groupingCategory==3 && p.getCategory3().equals(node.getCategory3())))		  //
                // found the correct one (sublist)
                {	// go down the sublist to end and add
                    while(p.down!= null) // stop at last node of sublist
                    {
                        p = p.down;
                    }
                    p.down = node;
                    inserted = true;
                }
                else{
                    if(p.right != null){   // move to next mainlist
                        p = p.right;
                    }
                    else{
                        p.right = node; // last.left to new node
                        node.left = p;  // node.right = last node (mainlist)
                        inserted = true;
                    }
                }
            }
        }
        size ++;
    }

    // clear list
    // set head -> null;
    // set size -> 0;

    public void clear(){
        head = null;
        size = 0;
    }

    //delete first node

    public void deleteFirst(){
        delete(0,0);
        //  mainlyindex, subindex
    }

    // delete last node
    // unfinished *********************************************
    public void deleteLast(){
        // int mainIndex = 0; // set mainIndex = 0;
        // check p.next -> p.right
        // delete(mainIndex,0);
    }
    // delete unfinished *****************************************
    public void delete(int mainIndex, int subIndex){
        if(mainIndex < 0 || head == null){
            throw new IndexOutOfBoundsException(" the mainly index out of bound " + mainIndex);
        }
        if(subIndex< 0 || head == null){
            throw new IndexOutOfBoundsException(" the sub index out of bound " + subIndex);
        }
        // ------------------------------

    }

    // ------------ delete part not done ---------------------
    //
    // String get // unfinished
    // ************************
    public String get(int mainIndex, int subIndex, int category){
        return null;
        // if(mainIndex < 0 || head == null){
        // throw new IndexOutOfBoundExpception(" out of bound " + mainIndex);
        // }
        // if (other)
        //

    }
    // unfinished *************************
    public void regroup(int groupingCategoryNumber){
        if(groupingCategoryNumber > 3 || groupingCategoryNumber < 0){
            throw new IndexOutOfBoundsException(" Category out of bound: " + groupingCategoryNumber);
        }
        // --------------------
        // unfinished
    }


    // return size
    public int size(){
        return size;
    }

    // int size  ********** not finished
    public int size(int index){
        return 0;
    }


    ///////////////////// main

    public static void main(String arg[]){
        File file = new File("");  // ********************
        Scanner scanner;
        LinkedList<Integer, String, String> list = new LinkedList<Integer, String, String>();
        // empty list
        try{
            scanner = new Scanner(file);
            // read a file
            list.category1Label = scanner.nextLine();
            list.category2Label = scanner.nextLine();
            list.category3Label = scanner.nextLine();

            scanner.nextLine(); // blank line
            Scanner linescanner;

            while(scanner.hasNext()){ 	// read date
                linescanner = new Scanner(scanner.nextLine());
                linescanner.useDelimiter(","); // , separate
                list.add(new Integer(linescanner.nextInt()), linescanner.next(), linescanner.next()); // integer , string , string
                linescanner.close();
            }
            scanner.close();
            //
            // test test
            //
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}

