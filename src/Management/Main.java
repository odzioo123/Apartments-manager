package Management;

import Commands.AddApartmentCommand;
import Commands.AddRentContractCommand;
import Commands.AddRenterCommand;
import Commands.SetApartmentRenovationCommand;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

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
        new AddRenterCommand(terminal.getRms(), "Szymon", "Orlos", "589271842").execute();

        try
        {
            LocalDate date1 = null;
            LocalDate date2 = null;
            LocalDate date3 = null;
            String dateString1 = "16, 01, 2024";
            String dateString2 = "02, 01, 2024";
            String dateString3 = "10, 01, 2024";
            DateTimeFormatter formatter  = DateTimeFormatter.ofPattern("dd, MM, yyyy");
            date1 = LocalDate.parse(dateString1, formatter);
            date2 = LocalDate.parse(dateString2, formatter);
            date3 = LocalDate.parse(dateString3, formatter);

            new AddRentContractCommand(terminal.getRms(), 3, 3, date1, 5).execute();
            new AddRentContractCommand(terminal.getRms(), 1, 5, date1, 5).execute();
            new AddRentContractCommand(terminal.getRms(), 0, 0, date2, 5).execute();
            new AddRentContractCommand(terminal.getRms(), 3, 1, date3, 5).execute();
        }
        catch (Exception e) {
            System.out.println(e);
        }




        terminal.startTerminal();

    }
}