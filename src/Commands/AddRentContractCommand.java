package Commands;

import Management.RentalManagementSystem;

public class AddRentContractCommand implements Command {
    private RentalManagementSystem rms;
    private int apartmentId;
    private int renterId;
    private String startDate;
    private int durationMonths;

    public AddRentContractCommand(RentalManagementSystem rms, int apartmentId, int renterId, String startDate, int durationMonths) {
        this.rms = rms;
        this.apartmentId = apartmentId;
        this.renterId = renterId;
        this.startDate = startDate;
        this.durationMonths = durationMonths;
    }

    @Override
    public void execute() {
        rms.addRentContract(apartmentId, renterId, startDate, durationMonths);
    }
}
