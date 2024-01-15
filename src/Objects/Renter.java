package Objects;

public class Renter {
    private int id;
    private String name;
    private String surname;
    private String contactInfo;
    public static int idToAdd = 0;
    public Renter(String name, String surname, String contactInfo) {
        this.id = idToAdd;
        idToAdd++;
        this.name = name;
        this.surname = surname;
        this.contactInfo = contactInfo;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public int getId() {
        return id;
    }
    public void displayDetails() {
        System.out.println("Tenant ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Contact Information: " + contactInfo);
        System.out.println();
    }
}