public class Room {
    private String type;
    private int price;
    private boolean isAvailable;

    public Room(String T){
        if(T.equalsIgnoreCase("double")){
            this.type = T;
            this.price = 90*100;
            this.isAvailable = true;
        }
        else if (T.equalsIgnoreCase("queen")){
            this.type = T;
            this.price = 110*100;
            this.isAvailable = true;
        }
        else if (T.equalsIgnoreCase("king")){
            this.type = T;
            this.price = 150*100;
            this.isAvailable = true;
        }
        else{
            throw new IllegalArgumentException("No room of such type can be created");
        }

    }

    public Room(Room ThisRoom){
        this.type = ThisRoom.type;
        this.price = ThisRoom.price;
        this.isAvailable = ThisRoom.isAvailable;
    }

    public String getType() {
        return this.type;
    }

    public int getPrice() {
        return this.price;
    }

    public void changeAvailability(){
        this.isAvailable = !this.isAvailable;
    }

    public static Room findAvailableRoom(Room[] Rooms, String T){
        int Len = Rooms.length;
        boolean Found = false;
        int i = 0;
        while(i < Len){
            if ((Rooms[i].isAvailable == true) && (Rooms[i].type.equalsIgnoreCase(T))){
                return Rooms[i];
            }
            i++;
        }
        return null;
    }

    public static boolean makeRoomAvailable(Room[] Rooms, String T){
        int Len = Rooms.length;
        int i = 0;
        while(i < Len){
            if ((!Rooms[i].isAvailable) && (Rooms[i].type.equalsIgnoreCase(T))){
                Rooms[i].isAvailable = true;
                return true;
            }
            i++;
        }
        return false;
    }
}
