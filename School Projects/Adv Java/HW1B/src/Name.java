public class Name implements Comparable<Name>{
    private String first;
    private String last;
    //constructor
    public Name(String first, String last){
        this.first = first;
        this.last = last;
    }
    //prints first name
    public String getFirst(){
        return first;
    }
    //prints last name
    public String getLast(){
        return last;
    }
    //overrides the to string method
    @Override
    public String toString(){
        return first + " " + last;
    }
    //implements the compareTo method by first then last name
    public int compareTo(Name name){
        if(0==first.compareTo(name.getFirst())){
            if(0==last.compareTo(name.getLast())){
                return 0;
            }
            else if(0<last.compareTo(name.getLast())){
                return 1;
            }
            else{
                return -1;
            }
        }
        else if(0>first.compareTo(name.getFirst())) {
            return -1;
        }
        else {
            return 1;
        }

    }
}
