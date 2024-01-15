package Objects;

import Objects.Apartment;
import Objects.Renter;

public class RentContract {
    private int id;
    private Apartment apartment;
    private Renter renter;
    private String startDate;
    private int durationMonths;
    public static int idToAdd = 0;
    public RentContract(Apartment apartment, Renter renter, String startDate, int durationMonths) {
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

    public String calculateEndDate() {
        // Implement logic to calculate end date based on start date and duration
        return "End Date: [Logic not implemented]";
    }

    public void displayDetails() {
        System.out.println("Rent Contract ID: " + id);
        System.out.println("Apartment Details:");
        apartment.displayDetails();
        System.out.println("Tenant Details:");
        renter.displayDetails();
        System.out.println("Start Date: " + startDate);
        System.out.println("Duration: " + durationMonths + " months");
        System.out.println(calculateEndDate());
        System.out.println();
    }
}