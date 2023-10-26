package addressBook;

import java.util.Scanner;

public class AddressBookMenu {

    public static void main(String[] args) {
        // Create some initial contacts
        Contact c1 = new Contact("John", "Doe", "(426)952-6502", "john.doe@mail.com");
        Contact c2 = new Contact("Samara", "Young", "(989)862-4982", "sam.young@mail.com");
        Contact c3 = new Contact("Kreyul", "Arroyal", "(340)291-1229", "kreyul.arroyal@mail.com");
        Contact c4 = new Contact("Nari", "Oh", "(362)688-2992", "nari.oh@mail.com");

        // Create AddressBook and add initial contacts
        AddressBook abook = new AddressBook();
        abook.addContact(c1);
        abook.addContact(c2);
        abook.addContact(c3);
        abook.addContact(c4);

        Scanner sc = new Scanner(System.in);

        OUTER:
        while (true) {
            // Displays main menu
            System.out.println("Select one of the options below (Enter 1, 2, or 3): ");
            System.out.println("1. Add new contact");
            System.out.println("2. Search a contact by lastname");
            System.out.println("3. Exit");
            String input = sc.nextLine();
            
            switch (input) {
                case "1" -> {
                    // Prompt user to enter details for new contact
                    System.out.println("Enter contact's firstname: ");
                    String firstName = sc.nextLine();
                    System.out.println("Enter contact's lastname: ");
                    String lastname = sc.nextLine();
                    System.out.println("Enter contact's phone number: ");
                    String phone = sc.nextLine();
                    System.out.println("Enter contact's email: ");
                    String email = sc.nextLine();
                    // Check if address book is at its maximum limit
                    int counter = 0;
                    if (counter == abook.getContact().length) {
                        System.out.println("Reached address book's maximum limit.");
                    }
                    else {
                        // Create new contact and add to address book
                        Contact c = new Contact(firstName, lastname, phone, email);
                        abook.addContact(c);
                    }
                }

                case "2" -> {
                    // Prompt user to enter first letter of last name to search for
                    System.out.println("Enter first letter of contact's last name");
                    String found = sc.nextLine();
                    Contact[] search = abook.searchContact(found);
                    int countSearch = 0;
                    
                    // Count number of search results
                    for (Contact search1 : search) {
                        if (search1 != null) {
                            countSearch++;
                        }
                    }   
                    // Display search results or "No contact found" message
                    if (countSearch == 0) {
                        System.out.println("No contact found.");
                    }
                    else {
                        for (int i = 0; i < countSearch; i++) {
                            System.out.println(search[i]);
                        }
                    }
                }
                
                case "3" -> {
                    // Exit program
                    break OUTER;
                }
                default -> {
                    // Handle invalid input (ignore it in this case)
                }
            }
        }
    }
}