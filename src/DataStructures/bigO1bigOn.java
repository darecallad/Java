package DataStructures;

public class bigO1bigOn {

    public void log(int[] numbers){
        //O(1)
        System.out.println(numbers[0]);
        //O(2)
        System.out.println(numbers[0]);

        //O(n)
        for(int i = 0 ; i < numbers.length; i ++){
            System.out.println(numbers[i]);
        }
        //O(2+n) -> we draw constant O(n)
        System.out.println(); //O(1)
        for(int number:numbers) //O(n)
            System.out.println(number);
        System.out.println(); //O(1)
        //////////////////////////////////
        //O(2n)
        for(int number:numbers) //O(n)
            System.out.println(number);
        for(int number:numbers) //O(n)
            System.out.println(number);
    }
    public void logg(int[] numberss, String[] names){
        //O(n+m) can simplify to O(n)
        for(int number:numberss) //O(n)
            System.out.println(number);
        for(String name:names)  //O(m)
            System.out.println(name);
    }

    public void greet(String[] names){
        //O(1)  space
        for(int i=0; i<names.length;i++){
            System.out.println("Hi " + names[i]);
        }
        //O(n)  space
        String[] copy = new String[names.length];
    }

}
