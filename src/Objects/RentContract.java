package Objects;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
public class RentContract implements Serializable {
    private int id;
    private Apartment apartment;
    private Renter renter;
    private LocalDate startDate;
    private int durationMonths;
    public static int idToAdd = 0;
    public RentContract(Apartment apartment, Renter renter, LocalDate  startDate, int durationMonths) {
        this.id = idToAdd;
        idToAdd++;
        this.apartment = apartment;
        this.renter = renter;
        this.startDate = startDate;
        this.durationMonths = durationMonths;
    }
    public int getId() {
        return id;
    }

    public Renter getRenter() {
        return renter;
    }
    public Apartment getApartment() {
        return apartment;
    }

    public LocalDate calculateEndDate() {
        return startDate.plusMonths(durationMonths);
    }

    public void displayDetails() {
        System.out.println("Rent Contract ID: " + id);
        System.out.println("Apartment ID: " + apartment.getId());
        System.out.println("Apartment rent: " + apartment.getRent());
        System.out.println("Renter: " + renter.getfullName());
        System.out.println("Renter ID: " + renter.getId());
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + calculateEndDate());
        System.out.println();
    }
}