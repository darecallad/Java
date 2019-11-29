package DataStructures;

public class bigOnSquare {
    public void log(int[] numbers){
        //O(n + n^2)
        //however n^2 is much faster than n so we can simplify it to O(n^2)
        for(int first:numbers)  //O(n)
            System.out.println(first);

        for(int first:numbers) //O(n)
            for(int second:numbers) //O(m)
                System.out.println(first + " " + second);
        /////////////////////////////////////////////////////
        // O(n^3)
        for(int first:numbers) //O(n)
            for(int second:numbers) //O(m)
                for(int third:numbers)
                System.out.println(first + " " + second+ " "+ third);
    }
}
