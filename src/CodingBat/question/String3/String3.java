package CodingBat.question.String3;

public class String3 {
//    Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count, but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
    public  int countYZ(String str){
        int count =0;
        char ch;
        str = str.toLowerCase();
        ch = str.charAt(0);

        for( int i = 1; i <= str.length() -1 ; i ++){
            if(ch == 'y' || ch == 'z'){
                ch = str.charAt(i);
                if(!Character.isLetter(ch))
                    count++;
            }
            else
                ch = str.charAt(i);
        }
        if(ch == 'y' || ch == 'z')
            count ++;
        return count;
    }
}
