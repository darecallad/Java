package CodingBat.question;

//Given a string, return a string made of the first 2 chars (if present),
// however include first char only if it is 'o' and include the second only if it is 'z', so "ozymandias" yields "oz".
//
//
//        startOz("ozymandias") → "oz"
//        startOz("bzoo") → "z"
//        startOz("oxx") → "o"
public class startOz {
    public static void main(String[] args){
        System.out.println(startOz("ozymandias"));
        System.out.println(startOz("bzoo"));
        System.out.println(startOz("oxx"));
    }
    public static String startOz(String str) {
        if(str.length()<1)
            return "";
        String first = str.substring(0,1);
        boolean isFirst = first.equals("o");
        if(str.length()<2&&isFirst){

            return first;
        }

        String second = str.substring(1,2);
        boolean isSecond = second.equals("z");
        if(isFirst&&isSecond)
            return first + second;
        else if(isFirst)
            return first;
        else if(isSecond)
            return second;
        else return "";

    }
    // should use str.chatAt(index); to solve this problem

}
//
//    public String startOz(String str) {
//        String result = "";
//
//        if (str.length() >= 1 && str.charAt(0)=='o') {
//            result = result + str.charAt(0);
//        }
//
//        if (str.length() >= 2 && str.charAt(1)=='z') {
//            result = result + str.charAt(1);
//        }
//
//        return result;
//    }