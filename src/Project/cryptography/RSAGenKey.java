package Project.cryptography;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;

public class RSAGenKey {

    public static void main(String[] args) {

        int k=0;

        String [] vars = new String[3];

        SecureRandom rnd = new SecureRandom();
        int certainty = 90;
        BigInteger P;
        BigInteger Q;
        BigInteger N;
        BigInteger Totient;
        BigInteger E;
        BigInteger D;

        String path = "/Users/thp/Desktop/";


        if (args.length==1) {

        }else if (args.length==3) {

        }else {

            //Take customer input for bit length to generate key pairs:
            Scanner reader = new Scanner(System.in);
            System.out.println("Enter 1 or 3 numbers ");
            String input= reader.nextLine();
            reader.close();

            // one input scenario
            if (input.contains(" ")==false) {

                k = Integer.parseInt(input);
                System.out.println("key bit="+k);


                //Generate P,Q,E by given k
                P = new BigInteger(k, certainty,rnd );
                Q = new BigInteger(k, certainty,rnd );
                N = P.multiply(Q);
                Totient = BigInteger.valueOf(phi(N.intValue()));

                do {
                    E = new BigInteger(k, certainty,rnd );
                }while (E.gcd(Totient).intValue()!=1);

                D = E.modInverse(Totient);


            }else {
                // three input scenario

                //getting the 3 keys from input string
                int i=0,j=0;
                j = input.indexOf(" ",0);
                vars[0] = input.substring(i, j);
                i=j;
                j = input.indexOf(" ",i+1);
                vars[1] = input.substring(i+1,j);
                i=j;
                j = input.length();
                vars[2] = input.substring(i+1,j);

                for (  String var : vars) {
                    System.out.println(var+".");
                }

                //generate BigInteger based on this
                P = new BigInteger(vars[0]);
                Q = new BigInteger(vars[1]);
                E = new BigInteger(vars[2]);
                N = P.multiply(Q);
                Totient = BigInteger.valueOf(phi(N.intValue()));
                D = E.modInverse(Totient);

            }




            //output to files
            String pubKeyString = "e=".concat(E.toString())
                    .concat(",n=")
                    .concat(N.toString());

            String priKeyString = "d=".concat(D.toString())
                    .concat(",n=")
                    .concat(N.toString());

            System.out.println(pubKeyString);
            System.out.println(priKeyString);

            writeFile(path,"pub_key.txt",pubKeyString);
            writeFile(path,"pri_key.txt",priKeyString);


        }



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

    //totient function calculation
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

}
