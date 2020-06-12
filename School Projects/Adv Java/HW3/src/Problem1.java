import java.util.ArrayList;
import java.util.Random;

public class Problem1 {
    public static void main(String[] args) {
        //create list for intergers and characters
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Character> clist = new ArrayList<>();
        Random rand = new Random();
        //creates a random list of integers
        System.out.println("Original List or Integers: ");
        for(int i = 0; i < 100; i++){
            list.add(rand.nextInt(10));
            System.out.print(list.get(i) + " ");
        }
        //removes duplicates
        System.out.println();
        System.out.println("This is the new list on Integers: ");
        list = removeDuplicates(list);
        //prints new list
        for(int i = 0; i < list.size();i++){
            System.out.print(list.get(i) + " ");
        }
        //creates random list of characters
        System.out.println();
        System.out.println("Original List or Characters: ");
        for(int i = 0; i < 100; i++){
            clist.add((char)(rand.nextInt(10) + 'a'));
            System.out.print(clist.get(i) + " ");
        }
        //removes duplicates
        System.out.println();
        System.out.println("This is the new list on Characters: ");
        clist = removeDuplicates(clist);
        //prints new list
        for(int i = 0; i < list.size();i++){
            System.out.print(clist.get(i) + " ");
        }
    }

    //method to remove duplicates using generics
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){

        ArrayList<E> list2 = new ArrayList<E>();

        for(int i = 0; i < list.size();i++){
            if(!list2.contains(list.get(i))){
                list2.add(list.get(i));
            }
        }
        return list2;
    }
}
