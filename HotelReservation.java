public class HotelReservation extends Reservation{
    private Hotel HotelName;
    private String RoomType;
    private int NumOfNights;
    private int Price;

    public HotelReservation(String Name, Hotel HotelName, String RoomType, int nights){
        super(Name);
        this.HotelName = HotelName;
        this.RoomType = RoomType;
        this.NumOfNights = nights;
        this.Price = this.HotelName.reserveRoom(this.RoomType);
    }

    public int getNumOfNights() {
        return NumOfNights;
    }

    public int getCost(){
        int Cost;
        Cost = this.NumOfNights * this.Price;
        return Cost;
    }

    @Override
    public boolean equals(Object Input) {
        if ((Input instanceof HotelReservation)){
            if(((HotelReservation) Input).HotelName.equals(this.HotelName) && (((HotelReservation) Input).NumOfNights == this.NumOfNights) && (((HotelReservation) Input).Price == this.Price) && ((HotelReservation) Input).RoomType.equalsIgnoreCase(this.RoomType)){
                return true;
            }

        }
        return false;
    }
}
