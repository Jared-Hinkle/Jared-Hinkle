import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Bin> bins = new ArrayList<Bin>();
        bins.add(new Bin());
        //prompts user to enter the number of objects and the objects themselves
        System.out.println("Enter the number of objects: ");
        int length = input.nextInt();
        double[] arr = new double[length];
        System.out.println("Enter the weights of the objects: ");
        for (int i = 0; i < length; i++){
            arr[i] = input.nextDouble();
        }
        //sorts the array of objects
        Arrays.sort(arr);
        System.out.println("Sorted Array: ");
        for(int i = 0; i < length; i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        //adds the objects to the appropriate bin
        for(int i = length - 1; i > - 1; i--){
            int j = 0;
            while(j < bins.size()){
                if(bins.get(j).addItem(arr[i])) {
                    arr[i] = 0;
                    j = bins.size();
                }
                else
                    j++;
            }
            if (arr[i] != 0){
                bins.add(new Bin());
                bins.get(bins.size()-1).addItem(arr[i]);
            }
        }
        //outputs the number of bins and their contents
        for(int i = 0; i < bins.size(); i ++){
            System.out.println("Container " + i + " " + bins.get(i).toString());
        }

    }

}


