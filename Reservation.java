public abstract class Reservation {
    private String ClientName;

    public Reservation(String Name){
        this.ClientName = Name;
    }

    public final String reservationName(){
        return this.ClientName;
    }

    public abstract int getCost();

    public abstract boolean equals(Object Input);


}
