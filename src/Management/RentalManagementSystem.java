package Management;

import Objects.Apartment;
import Objects.ApartmentState;
import Objects.RentContract;
import Objects.Renter;

import java.util.ArrayList;
import java.util.List;

public class RentalManagementSystem {
    private List<Apartment> apartments;
    private List<Renter> renters;
    private List<RentContract> contracts;

    public RentalManagementSystem() {
        this.apartments = new ArrayList<>();
        this.renters = new ArrayList<>();
        this.contracts = new ArrayList<>();
    }

    public void addApartment(int size, int rooms, double rent) {
        Apartment apartment = new Apartment(size, rooms, rent);
        apartments.add(apartment);
    }

    public void removeApartment(int apartmentId) {
        for(var contract : contracts)
        {
            if(contract.getApartment().getId() == apartmentId)
            {
                System.out.println("Can't delete, there is a Contract that includes this apartement");
                return;
            }
        }
        apartments.removeIf(apartment -> apartment.getId() == apartmentId);
    }

    public void addRenter(String name, String surname, String contactInfo) {
        Renter renter = new Renter(name, surname, contactInfo);
        renters.add(renter);
    }

    public void removeRenter(int renterId) {
        for(var contract : contracts)
        {
            if(contract.getRenter().getId() == renterId)
            {
                System.out.println("Can't delete, there is a Contract that includes this renter");
                return;
            }
        }
        renters.removeIf(renter -> renter.getId() == renterId);
    }

    public void addRentContract(int apartmentId, int renterId, String startDate, int durationMonths) {
        Apartment apartment = findApartmentById(apartmentId);
        Renter renter = findRenterById(renterId);


        if (apartment != null && renter != null && apartment.getStatus() == ApartmentState.AVAILABLE) {
            RentContract contract = new RentContract(apartment, renter, startDate, durationMonths);
            contracts.add(contract);
            apartment.setStatus(ApartmentState.OCCUPIED);
//            System.out.println("Rent contract created successfully.");
        }
        else
        {
            if (apartment == null) {
                System.out.println("Error: Apartment with ID " + apartmentId + " not found.");
            }

            if (renter == null) {
                System.out.println("Error: Renter with ID " + renterId + " not found.");
            }
        }
    }

    public void removeRentContract(int rentContractID)
    {
        for(var rentContract : contracts)
        {
            if(rentContract.getId() == rentContractID)
            {
                contracts.remove(rentContract);
                rentContract.getApartment().setStatus(ApartmentState.AVAILABLE);
//                System.out.println("Rent Contact removed successfully.");
                return;
            }
        }
        System.out.println("Error: Lease contract with ID " + rentContractID + " not found.");
    }


    public void displayApartments() {
        System.out.println("List of Apartments:");
        for (Apartment apartment : apartments)
        {
            apartment.displayDetails();
        }
    }

    public void displayRenters() {
        System.out.println("List of Renters:");
        for (Renter renter : renters) {
            renter.displayDetails();
        }
    }

    public void displayContracts() {
        System.out.println("List of Rent Contracts:");
        for (RentContract contract : contracts) {
            contract.displayDetails();
        }
    }

    public Apartment findApartmentById(int targetId) {
        for (Apartment apartment : apartments) {
            if (apartment.getId() == targetId) {
                return apartment;
            }
        }
        return null;
    }

    public Renter findRenterById(int targetId) {
        for (Renter renter : renters) {
            if (renter.getId() == targetId) {
                return renter;
            }
        }
        return null;
    }

    public void setApartmentRenovation(int apartementID) {
        for (var apartment : apartments)
        {
            if(apartment.getId() == apartementID && apartment.getStatus() != ApartmentState.OCCUPIED)
            {
                apartment.setStatus(ApartmentState.RENOVATION);
                return;
            }
        }
    }

    public void setApartmentAvailable(int apartmentID) {
        for (var apartment : apartments)
        {
            if(apartment.getId() == apartmentID)
            {
                apartment.setStatus(ApartmentState.AVAILABLE);
                return;
            }
        }
    }
}
