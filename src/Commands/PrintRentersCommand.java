package Commands;

import Management.RentalManagementSystem;

public class PrintRentersCommand implements Command {
    private RentalManagementSystem rms;

    public PrintRentersCommand(RentalManagementSystem rms) {
        this.rms = rms;
    }

    @Override
    public void execute() {
        rms.displayRenters();
    }
}
