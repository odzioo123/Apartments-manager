package Commands;

import Management.RentalManagementSystem;

import java.time.LocalDate;
import java.util.Date;

public class AddRentContractCommand implements Command {
    private RentalManagementSystem rms;
    private int apartmentId;
    private int renterId;
    private LocalDate startDate;
    private int durationMonths;

    public AddRentContractCommand(RentalManagementSystem rms, int apartmentId, int renterId, LocalDate  startDate, int durationMonths) {
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
