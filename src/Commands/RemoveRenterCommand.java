package Commands;

import Management.RentalManagementSystem;

public class RemoveRenterCommand implements Command {
    private RentalManagementSystem rms;
    private int renterId;

    public RemoveRenterCommand(RentalManagementSystem rms, int renterId) {
        this.rms = rms;
        this.renterId = renterId;
    }

    @Override
    public void execute() {
        rms.removeRenter(renterId);
    }
}
