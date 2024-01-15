package Commands;

import Management.RentalManagementSystem;

public class RemoveApartmentCommand implements Command {
    private RentalManagementSystem rms;
    private int apartmentId;

    public RemoveApartmentCommand(RentalManagementSystem rms, int apartmentId) {
        this.rms = rms;
        this.apartmentId = apartmentId;
    }

    @Override
    public void execute() {
        rms.removeApartment(apartmentId);
    }
}
