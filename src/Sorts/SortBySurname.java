package Sorts;

import Management.RentalManagementSystem;
import Objects.Renter;
import java.util.Comparator;

public class SortBySurname implements Sort {

    @Override
    public void sort(RentalManagementSystem rm)
    {
        rm.getRenters().sort(Comparator.comparing(Renter::getSurname));
    }
}
