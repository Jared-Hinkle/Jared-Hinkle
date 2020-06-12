public class Square extends GeometricObject implements Comparable<Square>{
    private int sideLength = 0;
    //constructor
    public Square(int sideLength){
        this.sideLength = sideLength;
    }
    //prints Area
    public double getArea(){
        return sideLength * sideLength;
    }
    //prints Perimeter
    public double getPerimeter(){
        return sideLength * 4;
    }
    //Overrides toString Method
    @Override
    public String toString(){
        return "A square with side length " + sideLength;
    }
    //implements compareTo Method
    public int compareTo(Square sqr){
        if ((sideLength * sideLength)  == sqr.getArea()){
            return 0;
        }
        else if ((sideLength * sideLength)  > sqr.getArea()){
            return 1;
        }
        else{
            return -1;
        }
    }
}
