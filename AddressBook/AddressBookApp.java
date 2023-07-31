import java.util.*;

public class AddressBookApp {
    private AddressBook addressBook;
    private Scanner scanner;
    private Contact contact;

    public AddressBookApp() {
        addressBook = new AddressBook();
        scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Welcome to the Address Book System!");

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add a new contact");
            System.out.println("2. Edit an existing contact's information");
            System.out.println("3. Search for a contact");
            System.out.println("4. Display all contacts");
            System.out.println("5. Exit");

            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    addNewContact();
                    break;
                case 2:
                    editContact();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    displayAllContacts();
                    break;
                case 5:
                    System.out.println("Exiting the application.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addNewContact() {
        System.out.println("Enter the contact details:");
        String name = getStringInput("Name: ");
        String phoneNumber = getStringInput("Phone Number: ");
        String emailAddress = getStringInput("Email Address: ");
        String city = getStringInput("City: ");

        Contact contact = new Contact(name, phoneNumber, emailAddress,city);
        addressBook.addContact(contact);

        System.out.println("Contact added successfully!");
    }

    private void editContact() {
        String name = getStringInput("Enter the name of the contact you want to edit: ");
        Contact contact = addressBook.searchContact(name);

        if (contact == null) {
            System.out.println("Contact not found.");
            return;
        }

       System.out.println("Enter the new contact details:");
        String newPhoneNumber = getStringInput("New Phone Number: ");
        String newEmailAddress = getStringInput("New Email Address: ");
        String newCity = getStringInput("New City: ");

        contact.setPhoneNumber(newPhoneNumber);
        contact.setEmailAddress(newEmailAddress);
        contact.setCity(newCity);

        System.out.println("Contact updated successfully!");
    }

    private void searchContact() {
        String name = getStringInput("Enter the name of the contact you want to search: ");
        Contact contact = addressBook.searchContact(name);

        if (contact != null) {
            System.out.println("Contact Details:");
            System.out.println("Name: " + contact.getName());
            System.out.println("Phone Number: " + contact.getPhoneNumber());
            System.out.println("Email Address: " + contact.getEmailAddress());
            System.out.println("City: " + contact.getCity());
        } else {
            System.out.println("Contact not found.");
        }
    }

    private void displayAllContacts() {
        List<Contact> contacts = addressBook.getAllContacts();
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        System.out.println("All Contacts:");
        for (Contact contact : contacts) {
            System.out.println("Name: " + contact.getName());
            System.out.println("Phone Number: " + contact.getPhoneNumber());
            System.out.println("Email Address: " + contact.getEmailAddress());
             System.out.println("City: " + contact.getCity());
            System.out.println("---------------------");
        }
    }

    private String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public static void main(String[] args) {
        AddressBookApp app = new AddressBookApp();
        app.run();
    }
}