package Management;

import Commands.*;

import java.util.Scanner;

public class TerminalController {
    private static TerminalController instance;
    private RentalManagementSystem rms;

    private TerminalController() {
        this.rms = new RentalManagementSystem();
    }
    public static TerminalController getTerminalController()
    {
        if(instance == null)
            instance = new TerminalController();
        return instance;
    }

    public void startTerminal() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the command:");
            System.out.println("- addA -  addApartment");
            System.out.println("- rA -    removeApartment");
            System.out.println("- addR -  addRenter");
            System.out.println("- rR -    removeRenter");
            System.out.println("- addRC - addRentContract");
            System.out.println("- rRC -   removeRentContract");
            System.out.println("- pR -    printRenters");
            System.out.println("- pA -    printApartments");
            System.out.println("- pRC -   printRentContracts");
            System.out.println("- sAR -   setAppartementRenovation");
            System.out.println("- exit");


            String command = scanner.nextLine();

            switch (command) {
                case "addApartment", "addA", "addapartment", "adda":

                    int rooms = 0;
                    int size = 0;
                    double rent = 0.;

                    while(true)
                    {
                        boolean wrong = false;

                        try {
                            System.out.println("Enter size:");
                            size = Integer.parseInt(scanner.nextLine());

                            if(size < 10 || size > 600)
                                throw new NumberFormatException();
                        }
                        catch (NumberFormatException e)
                        {
                            System.out.println("Wrong size, should be between 10 - 600");
                            continue;
                        }
                        try {
                            System.out.println("Enter rooms:");
                            rooms = Integer.parseInt(scanner.nextLine());

                            if(rooms < 1 || rooms > 20)
                                throw new NumberFormatException();
                        }
                        catch (NumberFormatException e)
                        {
                            System.out.println("Wrong rooms quantity, should be between 1 - 20");
                            continue;
                        }

                        try {
                            System.out.println("Enter rent:  (per month)");
                            rent = Double.parseDouble(scanner.nextLine());

                            if(rent < 50. || rent > 10000000.)
                                throw new NumberFormatException();
                        }
                        catch (NumberFormatException e)
                        {
                            System.out.println("Wrong rooms quantity, should be between 0 - 10000000");
                            continue;
                        }
                        break;
                    }
                    new AddApartmentCommand(rms, size, rooms, rent).execute();
                    break;

                case "removeApartment", "rA","removeapartment", "ra":
                    try {
                        System.out.println("Enter apartment ID:");
                        int apartmentIdToRemove = Integer.parseInt(scanner.nextLine());
                        new RemoveApartmentCommand(rms, apartmentIdToRemove).execute();
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("Wrong apartment id");
                    }
                    break;

                case "addRenter", "addR","addrenter", "addr":
                    // Implement logic to get renter details from the user
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();

                    System.out.println("Enter surname:");
                    String surname = scanner.nextLine();

                    System.out.println("Enter contact info:");
                    String contactInfo = scanner.nextLine();

                    new AddRenterCommand(rms, name, surname, contactInfo).execute();
                    break;

                case "removeRenter", "rR", "removerenter", "rr":
                    try {
                        System.out.println("Enter renter ID:");
                        int renterIdToRemove = Integer.parseInt(scanner.nextLine());
                        new RemoveRenterCommand(rms, renterIdToRemove).execute();
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("Wrong renter id");
                    }
                    break;

                case "addRentContract", "addRC","addrentcontract", "addrc":

                    int apartmentId = 0;
                    int renterId = 0;
                    int durationMonths = 0;
                    try {
                        System.out.println("Enter apartment ID:");
                        apartmentId = Integer.parseInt(scanner.nextLine());
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("Wrong apartment ID");
                        continue;
                    }

                    try {
                        System.out.println("Enter renter ID:");
                        renterId = Integer.parseInt(scanner.nextLine());
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("Wrong renter ID");
                        continue;
                    }

                    System.out.println("Enter start date:");
                    String startDate = scanner.nextLine();

                    System.out.println("Enter duration (in months):");
                    durationMonths = Integer.parseInt(scanner.nextLine());

                    new AddRentContractCommand(rms, apartmentId, renterId, startDate, durationMonths).execute();
                    break;

                case "removeRentContract", "rRC", "removerentcontract", "rrc":
                    try {
                        System.out.println("Enter RentContract ID:");
                        int RentContractIdToRemove = Integer.parseInt(scanner.nextLine());
                        new RemoveRenterCommand(rms, RentContractIdToRemove).execute();
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("Wrong RentContract id");
                    }
                    break;

                case "printRenters", "pR","printrenters", "pr":
                    new PrintRentersCommand(rms).execute();
                    break;

                case "printApartments", "pA","printapartments", "pa":
                    new PrintApartmentsCommand(rms).execute();
                    break;

                case "printRentContracts", "pRC","printrentcontracts", "prc":
                    new PrintRentContractsCommand(rms).execute();
                    break;

                case "setApartmentRenovation", "sAR","setapartmentrenovation", "sar":

                    try {
                        System.out.println("Enter Apartment ID:");
                        int apartmentID = Integer.parseInt(scanner.nextLine());
                        new SetApartmentRenovationCommand(rms, apartmentID).execute();
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("Wrong Apartment ID");
                    }
                    break;

                case "setApartmentAvailable", "sAA","setapartmentAvailable", "saa":

                    try {
                        System.out.println("Enter Apartment ID:");
                        int apartmentID = Integer.parseInt(scanner.nextLine());
                        new SetApartmentAvailableCommand(rms, apartmentID).execute();
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("Wrong Apartment ID");
                    }
                    break;

                case "exit", "EXIT", "Exit":
                    scanner.close();
                    System.out.println("Exiting the terminal.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }

    public RentalManagementSystem getRms() {
        return rms;
    }
}

