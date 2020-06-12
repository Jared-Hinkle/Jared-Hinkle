import java.util.Arrays;

public class Problem2 {
    public static void main(String[] args) {
        Name[] names = new Name[7];
        //creates names objects
        names[0] = new Name("Jared", "Hinkle");
        names[1] = new Name("Debbie", "Hinkle");
        names[2] = new Name("Julia", "Hinkle");
        names[3] = new Name("Christie", "VanMeter");
        names[4] = new Name("John", "Sanders");
        names[5] = new Name("Ryan", "Bailey");
        names[6] = new Name("Betty", "VanMeter");
        //sorts names array
        Arrays.sort(names);
        //prints sorted array of names 
        for (int i = 0; i < 7; i++){
            System.out.println(names[i].toString());
        }
    }
}
