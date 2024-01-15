package Commands;

import Management.RentalManagementSystem;

public class AddRenterCommand implements Command {
    private RentalManagementSystem rms;
    private String name;
    private String surname;
    private String contactInfo;

    public AddRenterCommand(RentalManagementSystem rms, String name, String surname, String contactInfo) {
        this.rms = rms;
        this.name = name;
        this.surname = surname;
        this.contactInfo = contactInfo;
    }

    @Override
    public void execute() {
        rms.addRenter(name, surname, contactInfo);
    }
}
