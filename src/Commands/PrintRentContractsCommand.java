package Commands;

import Management.RentalManagementSystem;

public class PrintRentContractsCommand implements Command {
    private RentalManagementSystem rms;

    public PrintRentContractsCommand(RentalManagementSystem rms) {
        this.rms = rms;
    }

    @Override
    public void execute() {
        rms.displayContracts();
    }
}
