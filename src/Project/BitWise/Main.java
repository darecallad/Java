package Project.BitWise;

import java.io.File;
import java.util.Scanner;


public class Main{

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);


        String fileName;
        File file;
        ImageProcessor obj=null;
        int ch;
        String msg;
        while(true){

            System.out.println("1)OpenFile \n"
                    + "2)Hide Message \n"
                    + "3)Recover Message \n"
                    + "4)Sepia \n"
                    + "5)GrayScale \n"
                    + "6)Negative \n"
                    + "7)Save \n"
                    + "8)Exit");

            ch=sc.nextInt();

            // switch-case // break; default;
            switch(ch){

                case 1:
                    System.out.println("Enter File Name");
                    fileName=sc.next();
                    file= new File(fileName);
                    obj=new ImageProcessor(file);
                    break;

                case 2:
                    if(obj==null){

                        System.out.println("You haven't open any file");
                    }
                    else{

                        System.out.println("Enter Message");
                        msg=sc.nextLine();
                        msg=sc.nextLine();
                        obj.hideMessage(msg);
                    }
                    break;

                case 3:
                    if(obj==null){

                        System.out.println("You haven't open any file.");
                    }
                    else{

                        msg="";
                        msg=obj.recoverMessage();
                        System.out.println("Recovered Message: "+msg);
                    }
                    break;

                case 4:
                    if(obj==null){

                        System.out.println("You haven't open any file.");
                    }
                    else{
                        obj.sepia();
                    }
                    break;

                case 5:
                    if(obj==null){

                        System.out.println("You haven't open any file.");
                    }
                    else{
                        obj.grayscale();
                    }
                    break;

                case 6:
                    if(obj==null){

                        System.out.println("You haven't open any file.");
                    }
                    else{
                        obj.negative();
                    }
                    break;

                case 7:
                    if(obj==null){

                        System.out.println("You haven't open any file.");
                    }
                    else{
                        System.out.println("Enter output file path");
                        String outPath=sc.next();
                        obj.writeImage(outPath);
                    }
                    break;
                case 8:
                    sc.close();
                    System.exit(1);
                    break;

                default:
                    System.out.println("Invalid Option");

            }
        }
    }
}