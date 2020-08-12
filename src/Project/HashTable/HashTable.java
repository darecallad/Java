package Project.HashTable;

import java.util.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;


public class HashTable {

    //variable

    ArrayList<String> numbers = new ArrayList<> ();

    //constructor
    public HashTable(ArrayList<String> numbers){
        this.numbers = numbers;
    }

    public SimpleList generateSimpleList(){
        SimpleList obj = new SimpleList();
        for(int i = 0; i < numbers.size(); i++){
            // add number
            obj.add(new Entry(numbers.get(i)));
        }
        return obj;
    }

    private SimpleList generateHashTable(){
        SimpleList obj = new SimpleList();
        for(int i =0; i< numbers.size(); i++){
            // add number
            Entry entry = new Entry(numbers.get(i));
            // get hash code
            int hash = entry.hashCode(numbers.get(i), 1);

            if(obj.getEntry(hash)!= null){ // get hash code success
                obj.entries[hash] = entry;
            }
            else{
                hash = entry.hashCode(numbers.get(i),2);
                obj.entries[hash] = entry;
            }
        }
        return obj;

    }

// main function

    public static void main(String args[]) throws IOException{
        // read file
        JFrame frame = new JFrame();
        JFileChooser jfchooser = new JFileChooser();
        ArrayList<String> list = new ArrayList<>();
        // jfchooser.showOpenDialog(null);
        jfchooser.showOpenDialog(frame);
        File selFile = jfchooser.getSelectedFile();
        FileReader reader= new FileReader(selFile);
        int num = 1;

        while (num != -1){

            num = reader.read();
            list.add(String.valueOf(num));
            //System.out.println(list);
        }

        /**
         int result = jfchooser.showOpenDialog();
         if( result == JFileChooser.APPROVE_OPTION){
         try{
         //FileReader fr = new FileReader()
         FileReader fr = null;
         JOptionPane.showMessageDialog(null, "Select File");
         File file = jfchooser.getSelectedFile();
         fr = new FileReader(file);
         int num = 1;
         while (num != -1) {
         num = fr.read();
         list.add(String.valueOf(num));
         }
         }catch(FileNotFoundException e){
         e.printStackTrace();
         }catch(IOException e){
         e.printStackTrace();
         }
         }
         **/
        // creating object
        HashTable obj = new HashTable(list);
        obj.generateSimpleList();
        obj.generateHashTable();
    }
}
