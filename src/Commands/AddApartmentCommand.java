package Commands;
import Management.RentalManagementSystem;
public class AddApartmentCommand implements Command {
    private RentalManagementSystem rms;
    private int size;
    private int rooms;
    private double rent;

    public AddApartmentCommand(RentalManagementSystem rms, int size, int rooms, double rent) {
        this.rms = rms;
        this.size = size;
        this.rooms = rooms;
        this.rent = rent;
    }

    @Override
    public void execute() {
        rms.addApartment(size, rooms, rent);
    }
}
