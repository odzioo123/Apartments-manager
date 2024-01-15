package Management;

import Objects.Renter;
import java.util.Comparator;

public class SortByName implements Sort {

    @Override
    public void sort(RentalManagementSystem rm)
    {
        rm.getRenters().sort(Comparator.comparing(Renter::getName));
    }
}
