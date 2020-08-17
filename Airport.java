public class Airport {
    private int x;
    private int y;
    private int Fees;

    public Airport(int X, int Y, int Fee){
        this.x = X;
        this.y = Y;
        this.Fees = Fee;
    }

    public int getFees(){
        return this.Fees;
    }

    public static int getDistance(Airport a, Airport b){
        int X1 = a.x;
        int X2 = b.x;
        int Y1 = a.y;
        int Y2 = b.y;
        double distance = Math.sqrt(Math.pow((X1-X2),2) + Math.pow((Y1-Y2),2));
        double Remainder = distance / ((int) distance);
        int Distance;
        if (Remainder > 1){
            Distance = 1 + (int)distance;
        }
        else{
            Distance = (int)distance;
        }
        return Distance;
    }




}
