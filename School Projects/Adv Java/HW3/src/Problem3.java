import java.util.*;

public class Problem3 {
    public static void main(String[] args) {
        Integer[] ints = new Integer[100];
        String[] strings = new String[100];
        Employee[] employees = new Employee[100];
        Scanner in = new Scanner(System.in);
        int searchint;

        Random rand = new Random();

        //create array of ints
        for(int i = 0; i < 99; i++){
            ints[i] = (rand.nextInt(99));
        }
        //sort display and call binarySearch for ints
        Arrays.sort(ints,0,99);
        for(int i = 0; i < 99; i++){
            System.out.print(ints[i]+ " ");
        }
        System.out.println();
        System.out.println("Enter an int to search the array for: ");
        searchint = in.nextInt();
        int location = binarySearch(ints, searchint);
        //displays if the int is in the array or not
        if (location < 0){
            System.out.println(searchint + " is not in the array");
        }
        else{
            System.out.println(searchint + " is at position: " + location);
        }

        //creates array of strings
        for (int i = 0; i < 100; i++) {
            int randlength = rand.nextInt(10) + 1;
            for(int j = 0; j < randlength; j++) {
                if (strings[i] == null) {
                    char randchar = ((char) (rand.nextInt(10) + 'a'));
                    strings[i] = Character.toString(randchar);
                } else {
                    strings[i] = strings[i] + ((char) (rand.nextInt(10) + 'a'));
                }
            }
        }

        //sort display and call binarySearch for strings
        Arrays.sort(strings,0,99);
        for(int i = 0; i < 99; i++){
            System.out.print(strings[i]+ " ");
        }
        System.out.println();
        System.out.println("Enter an string to search the array for: ");
        String searchstring = in.nextLine();
        location = binarySearch(strings, searchstring);
        //displays if the int is in the array or not
        if (location < 0){
            System.out.println(searchstring + " is not in the array");
        }
        else{
            System.out.println(searchstring + " is at position: " + location);
        }

        //creates employees array
        for (int i = 0; i < 99; i++) {
            String first = null;
            String last = null;
            int salary = 0;
            for(int j = 0; j < 10; j++) {
                if (first == null) {
                    char randchar = ((char) (rand.nextInt(10) + 'a'));
                    first = Character.toString(randchar);
                } else {
                    first = first + ((char) (rand.nextInt(10) + 'a'));
                }
                if (last == null) {
                    char randchar = ((char) (rand.nextInt(10) + 'a'));
                    last = Character.toString(randchar);
                } else {
                    last = last + ((char) (rand.nextInt(10) + 'a'));
                }
            }
            employees[i] = new Employee(first, last, rand.nextInt(1000000));
        }

        //sort display and call binarySearch for employees
        Arrays.sort(employees,0,99);
        for(int i = 0; i < 99; i++){
            System.out.print(employees[i]+ " ");
        }
        System.out.println();
        System.out.println("Enter an first, last, and salary of an employee to search the array for: ");
        String first = in.nextLine();
        String last = in.nextLine();
        int salary = in.nextInt();
        Employee searchEmployee = new Employee(first, last, salary);
        location = binarySearch(employees, searchEmployee);
        //displays if the employee is in the array or not
        if (location < 0){
            System.out.println(searchEmployee + " is not in the array");
        }
        else{
            System.out.println(searchEmployee + " is at position: " + location);
        }
    }
    //binarySearch Method with generics
    public static <E extends Comparable<E>> int binarySearch(E[] list, E key){
        int low = 0;
        int high = list.length - 1;

        while (high >= low) {
            int mid = (low + high) / 2;
            if (key.compareTo(list[mid])<0)
                high = mid - 1;
            else if (key.compareTo(list[mid])==0)
                return mid;
            else
                low = mid + 1;
        }
        return -low - 1; // Now high < low
    }
}
