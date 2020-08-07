package LeetCode;
//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000


public class IntegertoRoman {
    int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] symbols= {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public String intToRoman(int num){
        // first use stringbuilder
        StringBuilder stb = new StringBuilder();

        // check each values
        for(int i =0; i < values.length && num >= 0 ; i ++){
            while(values[i] <= num){
                num -= values[i];
                stb.append(symbols[i]);
            }
        }
        return stb.toString();
    }

    public static void main (String[] args){

        IntegertoRoman It = new IntegertoRoman();
        System.out.println(It.intToRoman(540));
    }
}
