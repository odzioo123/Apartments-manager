package Management;

import Commands.*;
import Sorts.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
            System.out.println("- sAA -   setApartmentAvailable");
            System.out.println("- sAC -   setApartmentCost");
            System.out.println("- sortA - sort Renters");
            System.out.println("- sortR - sort Apartments");
            System.out.println("- save -  save to file");
            System.out.println("- load -  load from file and overwrite");
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
                            System.out.println("Wrong rent, should be between 50 - 10000000");
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
                    LocalDate startDate;
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

                    try
                    {
                        System.out.println("Enter start date:");
                        String startDateString = scanner.nextLine();

                        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd, MM, yyyy");
                        startDate = LocalDate.parse(startDateString, formatter);

                    } catch (Exception e)
                    {
                        System.out.println("Wrong date format, should be dd, MM, yyyy");
                        continue;
                    }

                    try {
                        System.out.println("Enter duration (in months):");
                        durationMonths = Integer.parseInt(scanner.nextLine());
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("Wrong duration");
                        continue;
                    }

                    new AddRentContractCommand(rms, apartmentId, renterId, startDate, durationMonths).execute();
                    break;

                case "removeRentContract", "rRC", "removerentcontract", "rrc":
                    try {
                        System.out.println("Enter RentContract ID:");
                        int RentContractIdToRemove = Integer.parseInt(scanner.nextLine());
                        new RemoveRentContractCommand(rms, RentContractIdToRemove).execute();
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
                        continue;
                    }
                    break;

                case "setApartmentCost", "sac","setapartmentcost", "sAC":
                    int apartmentID;
                    double cost;
                    try {
                        System.out.println("Enter Apartment ID:");
                        apartmentID = Integer.parseInt(scanner.nextLine());

                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("Wrong Apartment ID");
                        continue;
                    }

                    try {
                        System.out.println("Enter Apartment rent to change:");
                        cost = Double.parseDouble(scanner.nextLine());
                        if(cost < 1.)
                        {
                            throw new NumberFormatException("too small");
                        }
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("Wrong rent, should be between 0 - 10000000 ");
                        continue;
                    }
                    new SetApartmentCostCommand(rms, apartmentID, cost).execute();

                    break;

                case "exit", "EXIT", "Exit":
                    scanner.close();
                    System.out.println("Exiting the terminal.");
                    System.exit(0);
                    break;

                case "sortR", "sr", "SortRenter","sortr":
                    System.out.println("Enter type: |ID| |Name| |Surname| |Fullname|");
                    String type1 = scanner.nextLine();
                    switch (type1)
                    {
                        case "ID", "id", "iD":
                            new SortByRenterID().sort(rms);
                            break;
                        case "Name", "name", "n", "NAME":
                            new SortByName().sort(rms);
                            break;
                        case "Surname", "surname", "s", "SURNAME":
                            new SortBySurname().sort(rms);
                            break;
                        case "Fullname", "fname", "f", "full":
                            new SortByFullName().sort(rms);
                            break;
                        default:
                            System.out.println("Wrong type of sorting");
                    }
                    break;

                case "sortA", "sa", "SortApartment","sorta":
                    System.out.println("Enter type: |ID| |Rent| |Status| |Rooms|");
                    String type2 = scanner.nextLine();
                    switch (type2)
                    {
                        case "ID", "id", "iD":
                            new SortByApartmentID().sort(rms);
                            break;
                        case "Rent", "rent", "re", "RENT", "RE":
                            new SortByRent().sort(rms);
                            break;
                        case "Status", "status", "s", "STATUS", "stat":
                            new SortByStatus().sort(rms);
                            break;
                        case "Rooms", "rooms", "ro", "rs", "RO":
                            new SortByRooms().sort(rms);
                            break;
                        default:
                            System.out.println("Wrong type of sorting");
                    }
                    break;

                case "save", "saveToFile", "savefile":
                    System.out.println("Enter filname.");
                    String filename1 = scanner.nextLine();
                    rms.saveToFile(filename1);
                    break;

                case "load", "loadToFile", "loadfile":
                    System.out.println("Enter filname.");
                    String filename2 = scanner.nextLine();
                    rms.loadFromFile(filename2);
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

