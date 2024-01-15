package Mementos;

import Objects.Apartment;
import Objects.RentContract;
import Objects.Renter;

import java.io.Serializable;
import java.util.List;

public class RentalManagementSystemMemento implements Serializable {
    private List<Apartment> apartments;
    private List<Renter> renters;
    private List<RentContract> contracts;

    public RentalManagementSystemMemento(List<Apartment> apartments, List<Renter> renters, List<RentContract> contracts) {
        this.apartments = apartments;
        this.renters = renters;
        this.contracts = contracts;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public List<Renter> getRenters() {
        return renters;
    }

    public List<RentContract> getContracts() {
        return contracts;
    }
}
