package Project.Generics;


import java.io.File;
import java.io.NotSerializableException;
import java.util.ArrayList;
import java.util.Iterator;

// Test all of your classes in the Main class.  You must demonstrate that everything works correctly.
// Use your ObjectSaver class to read each input file and create three ArrayLists, one per file.
// Display all of the objects in each ArrayList.
// Display the mininum and maximum objects of each ArrayList using the methods in your ShapeUtilities class.
// Sort each ArrayList using the sorting method from your ShapeUtilities class.
// Write the sorted ArrayLists to three output files using your ObjectSaver class.
// Use these output files as input files to create three new ArrayLists and then display these ArrayLists.

public class Main {

    public static void main(String arg[]){
        Shape cone = new Cone(20,10);
        Shape ellipsoid = new Ellipsoid(5,10,15);
        Shape sphere = new Sphere(30);

        ObjectSaver<Shape> coneFile = new ObjectSaver<>( new File("cones.dat")); // should accpet any data file? .txt
        ObjectSaver<Shape> ellipsoidFile = new ObjectSaver<>( new File("ellipsoids.dat"));
        ObjectSaver<Shape> sphereFile = new ObjectSaver<>( new File("spheres.dat"));

        System.out.println( " .................write file test.............. ");

        try{
            // cone
            System.out.println("Cone ->" + cone);
            if(coneFile.writeOneObject(cone, false)) {
                System.out.println("written to file.");
            }
            // ellipsoid
            System.out.println("Ellipsoid ->" + ellipsoid);
            if(ellipsoidFile.writeOneObject(ellipsoid, false)){
                System.out.println("written to file.");
            }
            // sphere
            System.out.println("Sphere ->" + sphere);
            if(sphereFile.writeOneObject(sphere, false)){   // here was an error
                System.out.println("written to file.");
            }

        }catch(NotSerializableException e){
            e.printStackTrace();
        }

        // some bug... not solved yet
        System.out.println( " ................read file test.............. ");

        //cone
        ArrayList<Shape> listFromFile = coneFile.readAllObjects();
        Iterator<Shape> iterator = listFromFile.iterator();

        System.out.println(" cone file: ");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //ellipsoid
        // problem
        listFromFile = ellipsoidFile.readAllObjects();
        iterator = listFromFile.iterator();

        System.out.println(" elliposid file: ");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //sphere
        // problem
        listFromFile = sphereFile.readAllObjects();
        iterator = listFromFile.iterator();

        System.out.println(" sphere file: ");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


        ArrayList<Shape> listOfShapes = new ArrayList<>();
        // add
        listOfShapes.add(cone);
        listOfShapes.add(ellipsoid);
        listOfShapes.add(sphere);
        System.out.println(" -------------------     MAX and MIN output test ------------------------\n");
        System.out.println(" Min V is: " + ShapeUtilities.min(listOfShapes));
        System.out.println(" Max V is: " + ShapeUtilities.max(listOfShapes)+ "\n");

        iterator = listOfShapes.iterator();

        System.out.println("---------------- SORTED OUTPUT TEST -----------------------------\n");
        System.out.println("Sorted list is: ");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
