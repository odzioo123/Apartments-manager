package Sorts;

import Management.RentalManagementSystem;
import Objects.Apartment;

import java.util.Comparator;

public class SortByStatus implements Sort {

    @Override
    public void sort(RentalManagementSystem rm)
    {
        rm.getApartments().sort(Comparator.comparing(Apartment::getStatus));
    }
}
