package Management;

import Mementos2.RentalManagementSystemMemento;
import Objects.Apartment;
import Objects.ApartmentState;
import Objects.RentContract;
import Objects.Renter;

import java.io.*;
import java.time.LocalDate;
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

    public List<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    public List<Renter> getRenters() {
        return renters;
    }

    public void setRenters(List<Renter> renters) {
        this.renters = renters;
    }

    public List<RentContract> getContracts() {
        return contracts;
    }

    public void setContracts(List<RentContract> contracts) {
        this.contracts = contracts;
    }
    public void restoreMemento(RentalManagementSystemMemento memento) {
        this.apartments = memento.getApartments();
        this.renters = memento.getRenters();
        this.contracts = memento.getContracts();
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
//                System.out.println("Can't delete, there is a Contract that includes this renter");
                return;
            }
        }
        renters.removeIf(renter -> renter.getId() == renterId);
    }

    public void addRentContract(int apartmentId, int renterId, LocalDate startDate, int durationMonths) {
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
                rentContract.getApartment().setStatus(ApartmentState.AVAILABLE);
                contracts.remove(rentContract);
                System.out.println("Rent Contact removed successfully.");
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

    public RentalManagementSystemMemento createMemento()
    {
        return new RentalManagementSystemMemento(
                new ArrayList<>(apartments),
                new ArrayList<>(renters),
                new ArrayList<>(contracts)
        );
    }

    public void saveToFile(String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName)))
        {
            RentalManagementSystemMemento memento = createMemento();
            outputStream.writeObject(memento);
            System.out.println("System state saved to file: " + fileName);
        } catch (IOException e) {
            System.out.println("Couldn't save the file");
        }
    }

    public void loadFromFile(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName)))
        {
            RentalManagementSystemMemento memento = (RentalManagementSystemMemento) inputStream.readObject();
            restoreMemento(memento);
            System.out.println("System state loaded from file: " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Couldn't load the file, check if file exists");
//            e.printStackTrace();
        }
    }

    public void setApartmentCost(int apartmentID, double rent) {
        for(var apartment : apartments)
        {
            if(apartment.getId() == apartmentID)
            {
                apartment.setRent(rent);
                return;
            }
        }
        System.out.println("Apartment haven't been found");
    }
}
