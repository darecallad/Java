package Project.Recursion;

import java.util.Set;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.util.HashMap;
import java.util.HashSet;
//import java.util.Map;
import java.util.Set;

import javax.swing.JFileChooser;

public class Hexmain {
    static Hexa[] tiles = new Hexa[7];
    static Set<String> solution = new HashSet<String>();
    // Use set to store solution
    // duplicate (av)

    // Stores original position/index in the text file
    //********************** still cannot display white number on hexagon *******************//
    //  static Map<String, String> originalPosInFile = new HashMap<String, String>();
    // **********************************************************************************//
    // public static void main(String[] args){
    // for GUI change to start function
    public static void start(){
        Hexa[] hexagons = new Hexa[7];

        JFileChooser jfchooser = new JFileChooser();
        jfchooser.showOpenDialog(null);
        // select file
        File file = jfchooser.getSelectedFile();

        if(file != null){
            try{
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String input = null;
                int index = 0;

                while((input = br.readLine()) != null && index < 7 ){ // read from file
                    String[] value = input.split(" ");
                    hexagons[index++] = new Hexa(value[1]); //str
                    // construct object from input data
                }
                br.close();
                // problem: catch IO exception   *solved
                // catch (FileNotFoundException e){e.printStackTrace();}
                // catch (IOException e){}
                // catch (Exception e){}
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        findmatch(hexagons, 0);
        // call function to place hexagon
        if(solution.isEmpty()){
            System.out.println(" No Soultions.");
        }
        else{
            int i = 0;
            for(String str: solution){
                System.out.println("Solution " + ++i +"\n" + str);
            }
        }

    }
    //////////////////////////////////////////////////////////////////////////////////////////
    // function
    // place tiles for hexagon
    // input hexagon and tiles position
    // use boolean to check y/n
    public static void findmatch(Hexa[] hexagons, int startposition){
        //base
        if (startposition < hexagons.length){
            for(int i = 0; i < hexagons.length; i++){
                if(hexagons[i].position == -1){ // find unused
                    tiles[startposition] = hexagons[i]; // set in position
                    hexagons[i].position = startposition; // save

                    if(checkPosition()){ // check right positions
                        findmatch(hexagons, startposition +1); // next hexagon
                    }
                    for(int j = 0; j <5 ; j++){
                        hexagons[i].rotate(); // rotate the object one (current)
                        if(checkPosition()){
                            findmatch(hexagons, startposition +1);
                        }
                    }
                    hexagons[i].rotate(); // reset initial position
                    tiles[startposition] = null; // rest -> 0; remove hexagon
                    hexagons[i].position = -1;
                }
            }
        }
        else {
            if (checkPosition()){
                // check final result boolean
                StringBuilder str = new StringBuilder();
                for(Hexa hex: tiles){
                    str.append(hex.toString() + "\n");
                }
                solution.add(str.toString());
                // ->Set
            }
        }
    }

    /////////////
    // function check

    public static boolean checkPosition(){

        for(int i =0; i <=5 ; i ++){
            if(tiles[i+1] != null && tiles[0].character[i] != tiles[i+1].character[(i+3)%6]){
                return false;
                // 1->4 , 2->5 , 3->6 compare with middel one
                // center
            }
            if (tiles[i+1] != null && tiles[((i+1)%6)+1] != null
                    && tiles[i+1].character[(i+2)%6] != tiles[((i+1) % 6 ) +1].character[(i+5) % 6]){
                return false;
                // compare outside hexagons with others outside hexagons
            }
        }
        return true;
    }
    //	public static void start() {
    //		// TODO Auto-generated method stub
    //		Hexa[] hexagons = new Hexa[7];
    //		JFileChooser jFileChooser = new JFileChooser();
    //		jFileChooser.showOpenDialog(null);
    //		File file = jFileChooser.getSelectedFile();

    //	}
}

