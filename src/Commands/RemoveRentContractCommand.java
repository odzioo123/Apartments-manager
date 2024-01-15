package Commands;

import Management.RentalManagementSystem;

public class RemoveRentContractCommand implements Command{
    private RentalManagementSystem rms;
    private int rentContactId;

    public RemoveRentContractCommand(RentalManagementSystem rms, int rentContactId) {
        this.rms = rms;
        this.rentContactId = rentContactId;
    }

    @Override
    public void execute() {
        rms.removeRentContract(rentContactId);
    }
}
