package Commands;

import Management.RentalManagementSystem;

public class SetApartmentRenovationCommand implements Command{
    private RentalManagementSystem rms;
    private int apartmentID;

    public SetApartmentRenovationCommand(RentalManagementSystem rms, int apartmentID) {
        this.rms = rms;
        this.apartmentID = apartmentID;
    }

    @Override
    public void execute() {
        rms.setApartmentRenovation(apartmentID);
    }
}
