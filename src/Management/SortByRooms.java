package Management;

import Objects.Apartment;

import java.util.Comparator;

public class SortByRooms implements Sort {

    @Override
    public void sort(RentalManagementSystem rm)
    {
        rm.getApartments().sort(Comparator.comparing(Apartment::getRooms));
    }

}
