public class Employee implements Comparable<Employee> {

    private String first;
    private String last;
    private double salary;

    public Employee(String first, String last, double salary){
        this.first = first;
        this.last = last;
        this.salary = salary;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public double getSalary() {
        return salary;
    }

    public int compareTo(Employee emp){
        if(0==first.compareTo(emp.getFirst())){
            if(0==last.compareTo(emp.getLast())){
                return 0;
            }
            else if(0<last.compareTo(emp.getLast())){
                return 1;
            }
            else{
                return -1;
            }
        }
        else if(0>first.compareTo(emp.getFirst())) {
            return -1;
        }
        else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Employee: " +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", salary=" + salary + " ";
    }
}
