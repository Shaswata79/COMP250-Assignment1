public class FlightReservation extends Reservation{
    private Airport Departure;
    private Airport Arrival;

    public FlightReservation(String Name, Airport Source, Airport Destination){
        super(Name);
        if (!Source.equals(Destination)){
            this.Departure = Source;
            this.Arrival = Destination;
        }

    }

    @Override
    public int getCost() {
        double cost;
        int Distance = Airport.getDistance(this.Departure, this.Arrival);
        cost = 5375 + ((Distance / 167.52) * 124) + this.Arrival.getFees() + this.Departure.getFees();
        double Remainder = cost / ((int) cost);
        int Cost;
        if (Remainder > 1){
            Cost = 1 + (int)cost;
        }
        else{
            Cost = (int)cost;
        }
        return Cost;
    }

    @Override
    public boolean equals(Object Input) {
        if (Input instanceof FlightReservation){
            if ((((FlightReservation) Input).Departure.equals(this.Departure)) && (((FlightReservation) Input).Arrival.equals(this.Arrival))){
                return true;
            }
        }
        return false;
    }


}
