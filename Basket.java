public class Basket {
    private Reservation[] ReservationList;

    public Basket(){
        this.ReservationList = new Reservation[0];
    }

    public Reservation[] getProducts(){
        Reservation[] NewArray = new Reservation[this.ReservationList.length];
        NewArray = this.ReservationList;
        return NewArray;
    }

    public int add(Reservation NewReservation){
        Reservation[] OldArray = getProducts();
        this.ReservationList = new Reservation[OldArray.length + 1];
        for (int i = 0; i < (OldArray.length); i++){
            this.ReservationList[i] = OldArray[i];
        }
        this.ReservationList[this.ReservationList.length - 1] = NewReservation;
        return this.ReservationList.length;
    }

    public boolean remove(Reservation ThisReservation){
        for (int i = 0; i < this.ReservationList.length; i++){
            if (this.ReservationList[i].equals(ThisReservation)){
                this.ReservationList[i] = null;
                for(int j = i - 1; j >= 0; j--){
                    this.ReservationList[j+1] = this.ReservationList[j];
                }
                this.ReservationList[0]= null;
                Reservation[] temp = this.ReservationList;
                this.ReservationList = new Reservation[this.ReservationList.length-1];
                for(int k = 0; k<this.ReservationList.length; k++){
                    this.ReservationList[k] = temp[k+1];
                }
                return true;
            }
        }
        return false;
    }

    public void clear(){
        this.ReservationList = new Reservation[]{};
    }

    public int getNumOfReservations(){
        int n = 0;
        for(int i = 0; i < this.ReservationList.length; i++){
            if(this.ReservationList[i] != null){
                n++;
            }
        }
        return n;
    }

    public int getTotalCost(){
        int TotalCost = 0;
        for(int i = 0; i < this.ReservationList.length; i++){
            if(this.ReservationList[i] != null){
                TotalCost = TotalCost + this.ReservationList[i].getCost();
            }
        }
        return TotalCost;
    }


}
