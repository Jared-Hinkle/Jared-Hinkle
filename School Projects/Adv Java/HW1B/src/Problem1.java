import java.util.Arrays;
import java.util.Random;

public class Problem1 {
    public static void main(String[] args) {
        Square[] squares = new Square[100];

        Random rand = new Random();
        //creates square objects
        for(int i = 0; i < 100; i++){
            squares[i] = new Square(rand.nextInt(49)+1);
        }
        //sorts the array
        Arrays.sort(squares);
        //prints squares
        for(int i = 0; i < 100; i++){
            System.out.println(squares[i].toString());
        }
    }
}
