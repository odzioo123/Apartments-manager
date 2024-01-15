package Commands;

import Management.RentalManagementSystem;

public class PrintApartmentsCommand implements Command {
    private RentalManagementSystem rms;

    public PrintApartmentsCommand(RentalManagementSystem rms) {
        this.rms = rms;
    }

    @Override
    public void execute() {
        rms.displayApartments();
    }
}
