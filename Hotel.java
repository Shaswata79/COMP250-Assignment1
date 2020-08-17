public class Hotel {
    private Room[] Rooms;
    private String Name;


    public Hotel(String name, Room[] rooms){
        this.Name = name;
        this.Rooms = new Room[rooms.length];
        for(int i = 0; i<rooms.length; i++){
            Room ThisRoom = rooms[i];
            this.Rooms[i] = new Room(ThisRoom);
        }
    }

    public int reserveRoom(String T){
        if(Room.findAvailableRoom(this.Rooms, T) != null){
            int Price = Room.findAvailableRoom(this.Rooms, T).getPrice();
            Room.findAvailableRoom(this.Rooms, T).changeAvailability();
            return Price;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public  boolean cancelRoom(String T){
        return Room.makeRoomAvailable(this.Rooms, T);
    }


}
