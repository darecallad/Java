package Project.cryptography;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class RSAEncript {


    static BigInteger P ;
    static BigInteger Q;
    static BigInteger N ;
    static BigInteger To ;
    static BigInteger E ;
    static BigInteger D ;

    static String path = "/Users/thp/Desktop/";
    static String pub_key = "pub_key.txt";
    static String pri_key = "pri_key.txt";
    static String fullText = "text.txt";


    public static void main(String[] args) {

        if(true) {


            //Take customer input for
//			Scanner reader = new Scanner(System.in);
//			System.out.println("Enter 1 or 3 numbers ");
//			String input= reader.nextLine();
//			reader.close();



            String text="";

            try {

                File file =
                        new File(path+pub_key);
                Scanner sc = new Scanner(file);

                while (sc.hasNextLine()) {
                    text += sc.nextLine();
                }

            }
            catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println(text);

            String ee = text.substring(text.indexOf("=")+1, text.indexOf(","));
            String nn = text.substring(text.indexOf(",")+3, text.length());


            E = new BigInteger(ee);
            N = new BigInteger(nn);
            D = new BigInteger("547097");



            // read full plain text
            String full="";

            try {

                File file =
                        new File(path+fullText);
                Scanner sc = new Scanner(file);

                while (sc.hasNextLine()) {
                    full += sc.nextLine();
                }

            }
            catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println(full);

            int length=0;


            // create cypher text
            String cypherText="";

            for (int i=0;i<full.length();i++) {
                char ch = full.charAt(i);

                int pt = ch;

                Integer ct = Encript(pt);    //encription

                String ctString = ct.toString();



                cypherText += ctString+" ";

            }

            System.out.println(cypherText);


            writeFile(path,"test.enc",cypherText);








        }

    }








    public static int Encript(int plain) {

        BigInteger Pt = BigInteger.valueOf(plain);

        BigInteger Ct = Pt.modPow(E, N);


        return Ct.intValue();
    }

    public static int Decript(int cypher) {

        BigInteger Ct  = BigInteger.valueOf(cypher);

        BigInteger Pt = Ct.modPow(D, N);

        return Pt.intValue();
    }




    static int phi(int n)
    {
        // Initialize result as n
        int result = n;

        // Consider all prime factors
        // of n and subtract their
        // multiples from result
        for (int p = 2; p * p <= n; ++p)
        {

            // Check if p is
            // a prime factor.
            if (n % p == 0)
            {

                // If yes, then update
                // n and result
                while (n % p == 0)
                    n /= p;
                result -= result / p;
            }
        }

        // If n has a prime factor
        // greater than sqrt(n)
        // (There can be at-most
        // one such prime factor)
        if (n > 1)
            result -= result / n;
        return result;
    }


    public static void writeFile (String path, String fileName, String text) {

        String filePath = path+fileName;

        try {
            FileOutputStream outputStream = new FileOutputStream(filePath);
            byte[] buffer = new byte[1000];

            buffer = text.getBytes();
            outputStream.write(buffer);
            outputStream.close();
            System.out.println("wrote out: "+fileName);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

