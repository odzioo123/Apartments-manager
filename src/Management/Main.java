package Management;

import Commands.AddApartmentCommand;
import Commands.AddRentContractCommand;
import Commands.AddRenterCommand;
import Commands.SetApartmentRenovationCommand;

public class Main {
    public static void main(String[] args) {


//        RentalManagementSystem rentalManagementSystem = new RentalManagementSystem();
//        rentalManagementSystem.addApartment(20, 3, 20);
//        rentalManagementSystem.addApartment(10, 1, 10);
//        rentalManagementSystem.addRenter("Dawid", "Kaszkowicz", "123456789");
//        rentalManagementSystem.createRentContract(1,1, "01.02", 5);
//
//        rentalManagementSystem.displayApartments();
//        rentalManagementSystem.displayRenters();
//        rentalManagementSystem.displayContracts();

        TerminalController terminal = TerminalController.getTerminalController();

        new AddApartmentCommand(terminal.getRms(), 20, 1, 300).execute();
        new AddApartmentCommand(terminal.getRms(), 23, 1, 350).execute();
        new AddApartmentCommand(terminal.getRms(), 30, 2, 400).execute();
        new AddApartmentCommand(terminal.getRms(), 100, 3, 700).execute();
        new AddApartmentCommand(terminal.getRms(), 110, 4, 1000).execute();
        new AddApartmentCommand(terminal.getRms(), 130, 4, 1200).execute();
        new AddApartmentCommand(terminal.getRms(), 130, 4, 1200).execute();
        new SetApartmentRenovationCommand(terminal.getRms(),6).execute();

        new AddRenterCommand(terminal.getRms(), "Konrad", "Sadowski", "konrad.sadowski@student.pk.edu.pl").execute();
        new AddRenterCommand(terminal.getRms(), "Konrad", "Serwa", "konrad.serwa@student.pk.edu.pl").execute();
        new AddRenterCommand(terminal.getRms(), "Mateusz", "Sarnacki", "Mateusz.Sarnacki@student.pk.edu.pl").execute();
        new AddRenterCommand(terminal.getRms(), "John", "Smith", "582917214").execute();
        new AddRenterCommand(terminal.getRms(), "John", "Lumberjack", "63912214").execute();
        new AddRenterCommand(terminal.getRms(), "Jan", "Sarnacki", "Jan.Sarnacki@gmail.com").execute();

        new AddRentContractCommand(terminal.getRms(), 3, 3, "04.01", 5).execute();
        new AddRentContractCommand(terminal.getRms(), 1, 5, "04.01", 5).execute();
        new AddRentContractCommand(terminal.getRms(), 0, 0, "04.01", 5).execute();
        new AddRentContractCommand(terminal.getRms(), 3, 1, "04.01", 5).execute();



        terminal.startTerminal();



    }
}