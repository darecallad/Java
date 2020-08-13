package Project.cryptograpy2;

public class SDES {

    public static void main(String args[]) {


        String rawkey = "1000101110";

        String input = "11010111";

        int[] output = decrypt(input, rawkey);

        print(output);

    }





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
        print(key10);


        //get 8 bit key K1 and K2
        int[] K1 = new int[8];
        int[] K2 = new int[8];

        K2 = permutationP8(leftshiftLS1(permutationP10(key10)));
        print(K2);

        K1 = permutationP8(leftshiftLS2(leftshiftLS1(permutationP10(key10))));
        print(K1);


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
        System.out.println("string to int");

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

        System.out.println("permutationP10");
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
        System.out.println("left shift LS-1");
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


        System.out.println("left shift LS-2");

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

        System.out.println("permutationP8");
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

        System.out.println("Initial permutation:");

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

        System.out.println("Inverse Initial permutation");

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

        System.out.println("EXPANSION/PERMUTATION on RH : ");


        // Bit by bit XOR with sub-key
        temp[0] = temp[0] ^ SK[0];
        temp[1] = temp[1] ^ SK[1];
        temp[2] = temp[2] ^ SK[2];
        temp[3] = temp[3] ^ SK[3];
        temp[4] = temp[4] ^ SK[4];
        temp[5] = temp[5] ^ SK[5];
        temp[6] = temp[6] ^ SK[6];
        temp[7] = temp[7] ^ SK[7];

        System.out.println("XOR With Key : ");


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

        System.out.println("S-Box S0: ");


        int d21 = temp[4]; // first bit of second half
        int d24 = temp[7]; // fourth bit of second half
        int row2 = BinaryOp.BinToDec(d21,d24);

        int d22 = temp[5]; // second bit of second half
        int d23 = temp[6]; // third bit of second half
        int col2 = BinaryOp.BinToDec(d22,d23);

        int o2 = S1[row2][col2];

        int[] out2 = BinaryOp.DecToBinArr(o2);

        System.out.println("S-Box S1");


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




}





class BinaryOp
{
    /** Gets binary digits as arguments & returns decimal number
     for example input args [1,0,0] will return 4 **/
    static int BinToDec(int...bits)
    {


        int temp=0;
        int base = 1;
        for(int i=bits.length-1 ; i>=0;i--)
        {
            temp = temp + (bits[i]*base);
            base = base * 2 ;
        }

        return temp;
    }

    /** gets decimal number as argument and returns array of binary bits
     for example input arg [10] will return  [1,0,1,0]**/
    static int[] DecToBinArr(int no)
    {
        // 13 1
        // 6  0
        // 3  1
        // 1  1
        // 0


        if(no==0)
        {
            int[] zero = new int[2];
            zero[0] = 0;
            zero[1] = 0;
            return zero;
        }
        int[] temp = new int[10] ;


        int count = 0 ;
        for(int i= 0 ; no!= 0 ; i++)
        {
            temp[i] = no % 2;
            no = no/2;
            count++;
        }


        int[] temp2 = new int[count];


        for(int i=count-1, j=0;i>=0 && j<count;i--,j++)
        {
            temp2[j] = temp[i];
        }

        //because we requires 2-bits as output .. so for adding leading 0
        if(count<2)
        {
            temp = new int[2];
            temp[0] = 0;
            temp[1] = temp2[0];
            return temp;
        }

        return temp2;
    }
}
