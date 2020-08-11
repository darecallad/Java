package Project.Recursion;

public class Hexa {
    char[] character;
    int position = -1;

    public Hexa(String colorString){
        // constructor
        character = colorString.toCharArray();
    }

    // test rotate
    // function
    // chatch first char to temp then move +1
    // store temp to last position
    public void rotate(){
        char temp = character[0];
        for(int i=1; i < character.length; i ++){
            character[i-1] = character[i];
        }
        character[character.length -1] = temp;
    }

    @Override
    public String toString(){
        return "Position " + (position +1) + ": " + new String(character);
    }
}
