package Project.Generics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ObjectSaver<T> {

    private File file;

    public ObjectSaver(File file){
        this.file = file;
    }
    // readOneObject
    // this method should also throw an IOException if the parameter is outside the range of possible object positions in the file.
    public T readOneObject(int index) throws IOException{
        ArrayList<T> result = readAllObjects();
        // find object index and return back to function
        if((result == null) || (result.size() >= index)){ // if cannot read one, then return outside range
            throw new IOException("parameter is outside the range");
        }

        else return result.get(index);
    }

    // readAllObjects
    // returns an ArrayList of Generic Type which holds all the objects read from the file.
    @SuppressWarnings("unchecked")
    public ArrayList<T> readAllObjects(){
        ArrayList<T> result;

        FileInputStream fileInputStream = null;  // declare to null
        ObjectInputStream objectInputStream = null;

        try{
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);

            result = (ArrayList<T>) objectInputStream.readObject();

            return result; //
            // catch (FileNotFoundException e){e.printStackTrace();}
            // catch (IOException e){}
            // catch (Exception e){}
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }finally{ // finally block use to exit try block
            // https://docs.oracle.com/javase/tutorial/essential/exceptions/finally.html

            if(fileInputStream != null){ // inputsteam -> close
                try{
                    fileInputStream.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            else if(objectInputStream != null){
                try{
                    objectInputStream.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    // writeOneObject
    // takes a generic class type as a parameter.
    // takes a boolean value as a parameter.
    // if the value is true append to the end of the file, if false, overwrite the old contents of the file.
    // writes the object to the File.
    // this method should also throw a NotSerializableException.

    public boolean writeOneObject(T object, boolean append) throws NotSerializableException{

        ArrayList<T> fileContentWritten;
        if(append){
            fileContentWritten = readAllObjects();
        }
        else{
            fileContentWritten = new ArrayList<T>();
        }

        fileContentWritten.add(object);

        writeAllObjects(fileContentWritten, append);

        return true;

    }

    // writeAllObjects
    // takes an ArrayList of any type as a parameter.
    // takes a boolean value as a parameter.
    // if the value is true append to the end of the file, if false, overwrite the old contents of the file.
    // writes all the objects in the ArrayList to the File specified in the constructor.
    // this method should also throw a NotSerializableException.

    public boolean writeAllObjects(ArrayList<T> objectWritten, boolean append) throws NotSerializableException{

        FileOutputStream fileOutputStream = null; //// declare to null
        ObjectOutputStream objectOutputStream = null;

        try{
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(objectWritten);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally{ // finally block use to exit try block
            // https://docs.oracle.com/javase/tutorial/essential/exceptions/finally.html

            if(fileOutputStream != null){ // inputsteam -> close
                try{
                    fileOutputStream.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            else if(objectOutputStream != null){
                try{
                    objectOutputStream.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        } // readallObjects & writeAllObjects // input & output

        return true;
    }

}