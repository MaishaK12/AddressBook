package addressBook;

public class AddressBook {
    private Contact[] contact;
    public static int counter = 0;

    public AddressBook() {
        this.contact = new Contact[20];
    }

    public Contact[] getContact() {
        return contact;
    }

    public void addContact(Contact c) {
        this.contact[counter] = c;
        counter++;
        
        // Sort contacts by last name
        for (int i = 0; i < counter; i++) {
            for (int j = i + 1; j < counter; j++) {
                Contact ln;
                if (this.contact[i].getLastName().compareTo(this.contact[j].getLastName()) > 0) {
                    ln = this.contact[i];
                    this.contact[i] = this.contact[j];
                    this.contact[j] = ln;
                }
            }
        }
        // Displays all contacts in array
        for (int i = 0; i < counter; i++) {
            System.out.println(this.contact[i]);
        }
        System.out.println();
    }

    // Search for contacts by first letter of last name
    public Contact[] searchContact(String found) {
        String lastName;
        Contact[] search = new Contact[counter];
        int count = 0;

        for (int i = 0; i < counter; i++) {
            lastName = Character.toString(this.contact[i].getLastName().charAt(0));
            
            if (lastName.equalsIgnoreCase(found)) {
                search[count] = this.contact[i];
                count++;
            }
        }
        return search;
    }
}