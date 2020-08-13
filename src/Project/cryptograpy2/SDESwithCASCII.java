package Project.cryptograpy2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;

public class SDESwithCASCII {

    // correct key
    static String REALrawkey = "1011110100";

    public static void main(String args[]) {


        String path = "/Users/thp/Desktop/";
        String result = "SIDEwithCASCII_Result.txt";

        String cypherText = "1011011001111001001011101111110000111110100000000001110111010001111011111101101100010011000000101101011010101000101111100011101011010111100011101001010111101100101110000010010101110001110111011111010101010100001100011000011010101111011111010011110111001001011100101101001000011011111011000010010001011101100011011110000000110010111111010000011100011111111000010111010100001100001010011001010101010000110101101111111010010110001001000001111000000011110000011110110010010101010100001000011010000100011010101100000010111000000010101110100001000111010010010101110111010010111100011111010101111011101111000101001010001101100101100111001110111001100101100011111001100000110100001001100010000100011100000000001001010011101011100101000111011100010001111101011111100000010111110101010000000100110110111111000000111110111010100110000010110000111010001111000101011111101011101101010010100010111100011100000001010101110111111101101100101010011100111011110101011011";

        ArrayList<String> rawkeys = generateKey(10);   //generate all 10 bit keys

        String writeText="";

        //brute-force to find crack the cypher text
        for (int i = 0 ; i < rawkeys.size() ; i++ )  {
            String rawkey = rawkeys.get(i);

            String plainText=decryptAndConvert(cypherText,rawkey);		//decrypt and convert


            writeText += rawkey+"\n"+plainText+"\n\n";

        }

        // write result out to find out which key is correct easily
        writeFile(path,result,writeText);


        //after finding out the correct key


        //demo using correct key
        System.out.println(REALrawkey+"\n"+decryptAndConvert(cypherText,REALrawkey));





    }




    // main operation here
    public static String decryptAndConvert(String cypherText, String rawkey) {
        String code="";
        String plainText="";

        //decrypt the cypherText into codes
        for (int i =0; i<cypherText.length()-(cypherText.length()%8) ; i=i+8) {

            String substring = cypherText.substring(i, i+8);

            int[] output = decrypt(substring, rawkey);   //decription

            code += intToString(output);
        }

        // convert the code (5 in a block) to CASCII text
        for (int i=0;i<code.length()-(code.length()%5);i+=5) {

            String subCode = code.substring(i, i+5);

            byte[] bytecode = stringToByte(subCode);

            CASCII CascII = new CASCII();
            String plain = CascII.toString(bytecode);

            plainText+=plain;

        }

        return plainText;
    }



    // n bit key  generator
    static ArrayList<String> generateKey(int n)
    {
        // base case
        if (n <= 0)
            return null;

        // 'arr' will store all generated codes
        ArrayList<String> arr = new ArrayList<String> ();

        // start with one-bit pattern
        arr.add("0");
        arr.add("1");

        // Every iteration of this loop generates 2*i codes from previously
        // generated i codes.
        int i, j;
        for (i = 2; i < (1<<n); i = i<<1)
        {
            // Enter the prviously generated codes again in arr[] in reverse
            // order. Nor arr[] has double number of codes.
            for (j = i-1 ; j >= 0 ; j--)
                arr.add(arr.get(j));

            // append 0 to the first half
            for (j = 0 ; j < i ; j++)
                arr.set(j, "0" + arr.get(j));

            // append 1 to the second half
            for (j = i ; j < 2*i ; j++)
                arr.set(j, "1" + arr.get(j));
        }

//	    // print contents of arr[]
//	    for (i = 0 ; i < arr.size() ; i++ )
//	        System.out.println(arr.get(i));

        return arr;
    }





    public static String intToString (int[] array) {
        String text="";

        for (int i=0;i<array.length;i++) {
            text += array[i];
        }

        return text;
    }

    public static byte[] stringToByte (String input) {
        byte[] output = new byte[input.length()];

        for (int i=0 ; i<input.length(); i++) {
            Character a = input.charAt(i);
            output[i] = Byte.parseByte(a.toString());
        }

        return output;
    }





//	public static byte[] intToByte (int[] input) {
//
//		byte[] text = new byte[input.length];
//
//		for (int i=0; i<input.length;i++) {
//			text[i] = (byte) input[i];
//		}
//
//		return text;
//	}



    public static int[] encrypt(String plaintext, String key )
    {

        int[] cyphertext = new int[8];
        int[] key10 = new int[10];

        key10 = stringToInt(key);
        print(key10);


        //get 8 bit key K1 and K2
        int[] K1 = new int[8];
        int[] K2 = new int[8];


        // reverse the K1 and K2 in the decryption process~~
        K1 = permutationP8(leftshiftLS1(permutationP10(key10)));
        print(K1);

        K2 = permutationP8(leftshiftLS2(leftshiftLS1(permutationP10(key10))));

        //K2 = permutationP8(leftshiftLS2(permutationP10(key10)));
        print(K2);


        //perform initial permutation (IP)
        int[] pt = new int[8];

        pt = stringToInt(plaintext);
        print(pt);
        pt = InitialPermutation(pt);



        //saperate left half & right half from 8-bit pt
        int[] LH = new int[4];
        int[] RH = new int[4];
        LH[0] = pt[0];
        LH[1] = pt[1];
        LH[2] = pt[2];
        LH[3] = pt[3];


        RH[0] = pt[4];
        RH[1] = pt[5];
        RH[2] = pt[6];
        RH[3] = pt[7];


        System.out.println("First Round LH : ");
        print(LH);

        System.out.println("First Round RH: ");
        print(RH);


        //first round with sub-key K1
        int[] r1 = new int[8];
        r1 = functionFk(LH,RH,K1);

        System.out.println("After First Round : ");
        print(r1);

        //Switch the left half & right half of about output
        int[] pt2 = new int[8];
        pt2 = switchSW(r1);

        System.out.println("After Switch Function : ");
        print(pt2);

        //  saperate left half & right half for second round
        LH[0] = pt2[0];
        LH[1] = pt2[1];
        LH[2] = pt2[2];
        LH[3] = pt2[3];

        RH[0] = pt2[4];
        RH[1] = pt2[5];
        RH[2] = pt2[6];
        RH[3] = pt2[7];


        System.out.println("Second Round LH : ");
        print(LH);

        System.out.println("Second Round RH: ");
        print(RH);

        //second round with sub-key K2
        int[] r2 = new int[8];
        r2 = functionFk(LH,RH,K2);

        System.out.println("After Second Round : ");
        print (r2);

        // perform IP^-1
        cyphertext = InverseInitialPermutation(r2);

        System.out.println("After Inverse IP  : ");
        print(cyphertext);

        return cyphertext;




    }


    //decryption is almost same except K1 and K2 is used in inversed order
    public static int[] decrypt(String plaintext, String key )
    {

        int[] cyphertext = new int[8];
        int[] key10 = new int[10];

        key10 = stringToInt(key);
//		print(key10);


        //get 8 bit key K1 and K2
        int[] K1 = new int[8];
        int[] K2 = new int[8];

        K2 = permutationP8(leftshiftLS1(permutationP10(key10)));
//		print(K2);

        K1 = permutationP8(leftshiftLS2(leftshiftLS1(permutationP10(key10))));
//		print(K1);


        //perform initial permutation (IP)
        int[] pt = new int[8];

        pt = stringToInt(plaintext);
//		print(pt);
        pt = InitialPermutation(pt);



        //saperate left half & right half from 8-bit pt
        int[] LH = new int[4];
        int[] RH = new int[4];
        LH[0] = pt[0];
        LH[1] = pt[1];
        LH[2] = pt[2];
        LH[3] = pt[3];


        RH[0] = pt[4];
        RH[1] = pt[5];
        RH[2] = pt[6];
        RH[3] = pt[7];


//		 System.out.println("First Round LH : ");
//		 print(LH);

//		 System.out.println("First Round RH: ");
//		 print(RH);


        //first round with sub-key K1
        int[] r1 = new int[8];
        r1 = functionFk(LH,RH,K1);

//		System.out.println("After First Round : ");
//		print(r1);

        //Switch the left half & right half of about output
        int[] pt2 = new int[8];
        pt2 = switchSW(r1);

//		System.out.println("After Switch Function : ");
//		print(pt2);

        //  saperate left half & right half for second round
        LH[0] = pt2[0];
        LH[1] = pt2[1];
        LH[2] = pt2[2];
        LH[3] = pt2[3];

        RH[0] = pt2[4];
        RH[1] = pt2[5];
        RH[2] = pt2[6];
        RH[3] = pt2[7];


//		 System.out.println("Second Round LH : ");
//		 print(LH);

//		 System.out.println("Second Round RH: ");
//		 print(RH);

        //second round with sub-key K2
        int[] r2 = new int[8];
        r2 = functionFk(LH,RH,K2);

//		System.out.println("After Second Round : ");
//	    print (r2);

        // perform IP^-1
        cyphertext = InverseInitialPermutation(r2);

//		 System.out.println("After Inverse IP  : ");
//	     print(cyphertext);

        return cyphertext;




    }



    // Change input from String to array of integers
    public static int[] stringToInt (String plaintext) {

        int length = plaintext.length();

        char ch;
        String ts;
        int[] key = new int[length];

        for(int i=0;i<length;i++)
        {
            ch = plaintext.charAt(i);
            ts = Character.toString(ch);
            key[i] = Integer.parseInt(ts);

            if(key[i] !=0 && key[i]!=1)
            {
                System.out.println("\n .. Invalid Key/plaintext ..");

            }
        }
//		System.out.println("string to int");

        return key;
    }

    /** fK(L, R, SK) = (L (XOR) mappingF(R, SK), R) .. returns 8-bit output**/
    public static int[] functionFk(int[] L, int[] R,int[] SK)
    {
        int[] temp = new int[4];
        int[] out = new int[8];


        temp = mappingF(R,SK);


        //XOR left half with output of mappingF
        out[0] = L[0] ^ temp[0];
        out[1] = L[1] ^ temp[1];
        out[2] = L[2] ^ temp[2];
        out[3] = L[3] ^ temp[3];

        out[4] = R[0];
        out[5] = R[1];
        out[6] = R[2];
        out[7] = R[3];


        return out;


    }




    //print out the integer
    public static void print(int[] input) {
        for (int i=0;i<input.length;i++) {
            System.out.print(input[i]);
        }
        System.out.println();
    }


    /** Perform permutation P10 on 10-bit key
     P10(k1, k2, k3, k4, k5, k6, k7, k8, k9, k10) = (k3, k5, k2, k7, k4, k10, k1, k9, k8, k6)
     **/
    public static int[] permutationP10(int[] key)
    {
        int[] temp = new int[10];

        temp[0] = key[2];
        temp[1] = key[4];
        temp[2] = key[1];
        temp[3] = key[6];
        temp[4] = key[3];
        temp[5] = key[9];
        temp[6] = key[0];
        temp[7] = key[8];
        temp[8] = key[7];
        temp[9] = key[5];

        key = temp;

//	    System.out.println("permutationP10");
        return key;
    }

    /** Performs a circular left shift (LS-1) , or rotation, separately on the first
     five bits and the second five bits.
     **/
    public static int[] leftshiftLS1(int[] key)
    {
        int[] temp = new int[10];

        temp[0] = key[1];
        temp[1] = key[2];
        temp[2] = key[3];
        temp[3] = key[4];
        temp[4] = key[0];

        temp[5] = key[6];
        temp[6] = key[7];
        temp[7] = key[8];
        temp[8] = key[9];
        temp[9] = key[5];


        //LS-2
//	      System.out.println("left shift LS-1");
        return temp;
    }

    public static int[] leftshiftLS2(int[] key)
    {
        int[] temp = new int[10];

        temp[0] = key[2];
        temp[1] = key[3];
        temp[2] = key[4];
        temp[3] = key[0];
        temp[4] = key[1];

        temp[5] = key[7];
        temp[6] = key[8];
        temp[7] = key[9];
        temp[8] = key[5];
        temp[9] = key[6];


        //       System.out.println("left shift LS-2");

        return temp;
    }


    /** apply Permutaion P8. picks out and permutes 8 of the 10 bits according to the following
     rule: P8[ 6 3 7 4 8 5 10 9 ] , 8-bit subkey is returned **/
    public static int[] permutationP8(int[] key)
    {
        int[] temp = new int[8];

        temp[0] = key[5];
        temp[1] = key[2];
        temp[2] = key[6];
        temp[3] = key[3];
        temp[4] = key[7];
        temp[5] = key[4];
        temp[6] = key[9];
        temp[7] = key[8];

//	      System.out.println("permutationP8");
        return temp;
    }


    /** perform Initial Permutation in following manner [2 6 3 1 4 8 5 7] **/
    public static int[] InitialPermutation( int[] plaintext)
    {
        int[] temp = new int[8];

        temp[0] = plaintext[1];
        temp[1] = plaintext[5];
        temp[2] = plaintext[2];
        temp[3] = plaintext[0];
        temp[4] = plaintext[3];
        temp[5] = plaintext[7];
        temp[6] = plaintext[4];
        temp[7] = plaintext[6];

        plaintext = temp;

//	      System.out.println("Initial permutation:");

        return plaintext;

    }

    public static int[] InverseInitialPermutation(int[] plaintext)
    {
        int[] temp = new int[8];

        temp[0] = plaintext[3];
        temp[1] = plaintext[0];
        temp[2] = plaintext[2];
        temp[3] = plaintext[4];
        temp[4] = plaintext[6];
        temp[5] = plaintext[1];
        temp[6] = plaintext[7];
        temp[7] = plaintext[5];

        plaintext = temp;

//	      System.out.println("Inverse Initial permutation");

        return plaintext;

    }




    /** mappingF . arguments 4-bit right-half of plaintext & 8-bit subkey **/
    public static int[] mappingF(int[] R, int[] SK)
    {
        int[] temp = new int[8];

        // EXPANSION/PERMUTATION [4 1 2 3 2 3 4 1]
        temp[0]  = R[3];
        temp[1]  = R[0];
        temp[2]  = R[1];
        temp[3]  = R[2];
        temp[4]  = R[1];
        temp[5]  = R[2];
        temp[6]  = R[3];
        temp[7]  = R[0];

//	  	 System.out.println("EXPANSION/PERMUTATION on RH : ");


        // Bit by bit XOR with sub-key
        temp[0] = temp[0] ^ SK[0];
        temp[1] = temp[1] ^ SK[1];
        temp[2] = temp[2] ^ SK[2];
        temp[3] = temp[3] ^ SK[3];
        temp[4] = temp[4] ^ SK[4];
        temp[5] = temp[5] ^ SK[5];
        temp[6] = temp[6] ^ SK[6];
        temp[7] = temp[7] ^ SK[7];

//	      System.out.println("XOR With Key : ");


        // S-Boxes
        final int[][] S0 = { {1,0,3,2} , {3,2,1,0} , {0,2,1,3} , {3,1,3,2} } ;
        final int[][] S1 = { {0,1,2,3},  {2,0,1,3}, {3,0,1,0}, {2,1,0,3}} ;


        int d11 = temp[0]; // first bit of first half
        int d14 = temp[3]; // fourth bit of first half

        int row1 = BinaryOp.BinToDec(d11,d14); // for input in s-box S0


        int d12 = temp[1]; // second bit of first half
        int d13 = temp[2]; // third bit of first half
        int col1 = BinaryOp.BinToDec(d12,d13); // for input in s-box S0


        int o1 = S0[row1][col1];

        int[] out1 = BinaryOp.DecToBinArr(o1);

//	  	 System.out.println("S-Box S0: ");


        int d21 = temp[4]; // first bit of second half
        int d24 = temp[7]; // fourth bit of second half
        int row2 = BinaryOp.BinToDec(d21,d24);

        int d22 = temp[5]; // second bit of second half
        int d23 = temp[6]; // third bit of second half
        int col2 = BinaryOp.BinToDec(d22,d23);

        int o2 = S1[row2][col2];

        int[] out2 = BinaryOp.DecToBinArr(o2);

//	  	 System.out.println("S-Box S1");


        //4 output bits from 2 s-boxes
        int[] out = new int[4];
        out[0] = out1[0];
        out[1] = out1[1];
        out[2] = out2[0];
        out[3] = out2[1];

        //permutation P4 [2 4 3 1]

        int [] O_Per = new int[4];
        O_Per[0] = out[1];
        O_Per[1] = out[3];
        O_Per[2] = out[2];
        O_Per[3] = out[0];

        return O_Per;
    }



    //switch function
    public static int[] switchSW(int[] in)
    {

        int[] temp = new int[8];

        temp[0] = in[4];
        temp[1] = in[5];
        temp[2] = in[6];
        temp[3] = in[7];

        temp[4] = in[0];
        temp[5] = in[1];
        temp[6] = in[2];
        temp[7] = in[3];

        return temp;
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
