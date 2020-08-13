package Project.cryptography;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class RSADecript {


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
    static String cypherTextFile = "test.enc";


    public static void main(String[] args) {


        if(true) {

            // read private keys
            String keys="";

            try {

                File file =
                        new File(path + pri_key);
                Scanner sc = new Scanner(file);

                while (sc.hasNextLine()) {
                    keys += sc.nextLine();
                }

            }
            catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println(keys);

            String dd = keys.substring(keys.indexOf("=")+1, keys.indexOf(","));
            String nn = keys.substring(keys.indexOf(",")+3, keys.length());


            D = new BigInteger(dd);
            N = new BigInteger(nn);

            System.out.println("D="+D);
            System.out.println("N="+N);




            //read cypher text

            String ctext="";

            try {

                File file =
                        new File(path+cypherTextFile);
                Scanner sc = new Scanner(file);

                while (sc.hasNextLine()) {
                    ctext += sc.nextLine();
                }

            }
            catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println(ctext);


            Character len = ctext.charAt(ctext.indexOf(".")+1);
            int length = Character.getNumericValue(len);

            // convert cypherText  and decription
            String cypherText = ctext;
            System.out.println(cypherText);

            String plainText="";

            int i=-1, j=0;
            j = cypherText.indexOf(" ",0);

            while (j!=-1) {

                String ctString = cypherText.substring(i+1, j);
                i=j;
                j= cypherText.indexOf(" ", j+1);

                int ct = Integer.parseInt(ctString);

                int pt = Decript(ct);		//decryption

                char ch = (char)pt;		//individual character

                plainText += ch;
                System.out.println(plainText);
            }

            System.out.println(plainText);

            writeFile(path,"test.dec",plainText);


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

