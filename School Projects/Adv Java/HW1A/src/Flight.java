import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class Flight {
    private String flightNo;
    private Calendar departureTime;
    private Calendar arrivalTime;
    //constructor
    public Flight(String flightNo, Calendar departureTime, Calendar arrivalTime){
        this.flightNo = flightNo;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }
    //calculates flight time
    public int getFlightTime(){
        long hours = ChronoUnit.HOURS.between(departureTime.toInstant(), arrivalTime.toInstant());
        long mins = ChronoUnit.MINUTES.between(departureTime.toInstant(), arrivalTime.toInstant());

        hours = hours/60;
        int total = (int)hours + (int)mins;

        return total;
    }
    //returns departure time for a flight
    public Calendar getDepartureTime(){
        return departureTime;
    }
    //returns arrival time for a flight
    public Calendar getArrivalTime(){
        return arrivalTime;
    }
    //changes departure time
    public void setDepartureTime(Calendar departureTime){
        this.departureTime = departureTime;
    }

}
