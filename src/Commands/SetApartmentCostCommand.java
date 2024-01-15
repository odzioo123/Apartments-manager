package Commands;

import Management.RentalManagementSystem;
public class SetApartmentCostCommand implements Command{
    private RentalManagementSystem rms;
    private int apartmentID;
    private double rent;

    public SetApartmentCostCommand(RentalManagementSystem rms, int apartmentID, double rent) {
        this.rms = rms;
        this.apartmentID = apartmentID;
        this.rent = rent;
    }

    @Override
    public void execute() {
        rms.setApartmentCost(apartmentID, rent);
    }
}
