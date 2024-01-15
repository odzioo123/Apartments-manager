package Objects;

import java.util.ArrayList;
import java.util.List;

public class Apartment {
    private int id;
    private int size;
    private int rooms;
    private double rent;
    private ApartmentState status;
    public static int idToAdd = 0;

    public Apartment(int size, int rooms, double rent) {
        this.id = idToAdd;
        idToAdd++;
        this.size = size;
        this.rooms = rooms;
        this.rent = rent;
        this.status = ApartmentState.AVAILABLE;
    }
    public ApartmentState getStatus() {
        return status;
    }
    public void setStatus(ApartmentState status) {
        this.status = status;
    }
    public int getId() {
        return id;
    }

    public void displayDetails() {
        System.out.println("Apartment ID: " + id);
        System.out.println("Size: " + size + " m2");
        System.out.println("Number of rooms: " + rooms);
        System.out.println("Monthly rent: " + rent + " $");
        System.out.println("Status: " + status);
        System.out.println();
    }
}



