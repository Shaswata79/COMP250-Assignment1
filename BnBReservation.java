public class BnBReservation extends HotelReservation {

    public BnBReservation(String Name, Hotel HotelName, String RoomType, int NumOfNights){
        super(Name,HotelName,RoomType,NumOfNights);
    }

    public int getCost(){
        int Price = super.getCost()/this.getNumOfNights();
        Price = Price + 1000;
        int Cost = Price * this.getNumOfNights();
        return Cost;
    }


}
