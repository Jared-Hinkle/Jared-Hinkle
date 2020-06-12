import java.util.ArrayList;
import java.util.Random;

public class Problem2 {
    public static void main(String[] args) {
        //creates a list of integers and doubles
        Integer[] list = new Integer[100];
        Double[] dlist = new Double[100];
        Random rand = new Random();
        //fills list with random numbers
        System.out.println("Original list of Integers: ");
        for(int i = 0; i < 100; i++){
            list[i] = rand.nextInt(10001);
            System.out.print(list[i] + " ");
        }
        //prints max of integers
        System.out.println();
        System.out.println("Max of Integers: ");
        System.out.println(max(list));
        //fills list with random doubles
        System.out.println("Original list of doubles: ");
        for(int i = 0; i < 100; i++){
            dlist[i] = rand.nextDouble();
            System.out.print(dlist[i] + " ");
        }
        //prints max of doubles
        System.out.println();
        System.out.println("Max of doubles: ");
        System.out.println(max(dlist));
    }


    public static <E extends Comparable<E>> E max (E[] list){
        E max = list[0];
        for (int i = 0; i < list.length; i++){
            if(max.compareTo(list[i]) < 0){
                max = list[i];
            }
        }

        return max;
    }

}
