public class Customer {
    private String Name;
    private int Balance;
    private Basket CustomerReservations;

    public Customer(String Name, int Balance){
        this.Name = Name;
        this.Balance = Balance;
        this.CustomerReservations = new Basket();

    }

    public String getName() {
        return this.Name;
    }

    public int getBalance() {
        return this.Balance;
    }

    public Basket getBasket() {
        return CustomerReservations;
    }

    public int addFunds(int Amount){
        if (Amount >= 0){
            this.Balance = this.Balance + Amount;
            return this.Balance;
        }
        else{
            throw new IllegalArgumentException("Amount of money cannot be negative");
        }
    }

    public int addToBasket(Reservation NewReservation){
        if (this.Name.equalsIgnoreCase(NewReservation.reservationName())){
            this.CustomerReservations.add(NewReservation);
            return this.CustomerReservations.getNumOfReservations();
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public int addToBasket(Hotel HotelName, String RoomType, int NumNights, boolean breakfast){
        Reservation ThisReservation = null;
        if(breakfast == true){
            ThisReservation = new BnBReservation(this.Name,HotelName, RoomType, NumNights);
        }
        else{
            ThisReservation = new HotelReservation(this.Name,HotelName, RoomType, NumNights);
        }
        this.CustomerReservations.add(ThisReservation);
        return this.CustomerReservations.getNumOfReservations();
    }

    public int addToBasket(Airport A1, Airport A2){
        Reservation ThisReservation = new FlightReservation(this.Name, A1, A2);
        this.CustomerReservations.add(ThisReservation);
        return this.CustomerReservations.getNumOfReservations();
    }

    public boolean removeFromBasket(Reservation ThisReservation){
        boolean Success = this.CustomerReservations.remove(ThisReservation);
        return Success;
    }

    public int checkOut(){
        if (this.Balance < this.CustomerReservations.getTotalCost()){
            throw new IllegalStateException("Not enough balance");
        }
        else{
            this.Balance = this.Balance - this.CustomerReservations.getTotalCost();
            this.CustomerReservations.clear();
            return this.Balance;
        }

    }
}
