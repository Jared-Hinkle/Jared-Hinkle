import java.util.ArrayList;

public class Bin {
    private ArrayList<Double> objects = new ArrayList<Double>();
    private double maxWeight;
    private double totalWeight;
    //constructor
    public Bin(){
        maxWeight = 10;
        totalWeight = 0;
    }
    //constructor
    public Bin(double maxWeight){
        this.maxWeight = maxWeight;
        totalWeight = 0;
    }
    //adds an item if it will fit in the bin
    public Boolean addItem(double weight){
        if (totalWeight + weight <= 10){
            objects.add(weight);
            totalWeight += weight;
            return true;
        }
        else{
            return false;
        }
    }
    //returns the number of objects in the arraylist
    public int getNumberOfObjects(){
        return objects.size();
    }
    //overrides toString method
    @Override
    public String toString(){
        String string =  ("Contains " + getNumberOfObjects() + " objects with weight " );
        for(int i = 0; i < objects.size(); i++){
            string = string + objects.get(i).toString() + " ";
        }
        return string;
    }
}
