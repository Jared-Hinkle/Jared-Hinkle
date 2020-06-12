import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Itinerary {
    private List<Flight> flights = new ArrayList<>();
    //constructor
    public Itinerary(List<Flight> flights){
        this.flights.addAll(flights);
    }
    //calculates the total travel time
    public int getTotalTravelTime(){
        int total = 0;
        Calendar departureTime = flights.get(0).getDepartureTime();
        Calendar arrivalTime = flights.get(flights.size()-1).getArrivalTime();

        long hours = ChronoUnit.HOURS.between(departureTime.toInstant(), arrivalTime.toInstant());
        long mins = ChronoUnit.MINUTES.between(departureTime.toInstant(), arrivalTime.toInstant());

        hours = hours/60;
        total = (int)hours + (int)mins;

        return total;
    }
    //calculates the total flight time
    public int getTotalFlightTime(){
        int total = 0;
        for(int i = 0; i < flights.size(); i++){
            total = total + flights.get(i).getFlightTime();
        }
        return total;
    }
}
