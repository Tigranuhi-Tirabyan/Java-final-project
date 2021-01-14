import java.util.ArrayList;
import java.util.Arrays;

public class ContactBook {
    private Contact[] contact_book;// array to store chains(linked lists)
    private int size; // Current size of array list(the number of (key,value) pairs)

    // Constructor
    public ContactBook(int initial_size) {
        contact_book = new Contact[initial_size];
    }

    public int getSize() {
        return size;
    }


    //Hash function to find index for a new contact
    private int getIndex(String name) {
        int hash = name.hashCode();
        return Math.abs(hash) % contact_book.length;
    }

    public void addContact(String name, ContactData data) {
        int index = getIndex(name); // Find index for new name
        Contact contacts = contact_book[index]; // Contacts linked list of corresponding index

        // if contact name is already present, update data
        while (contacts != null) {
            if (contacts.name.equals(name)) {
                contacts.data = data;
                System.out.println("Data for " + contacts.name + " was updated");
                return;
            }
            contacts = contacts.next; // moving on
        }

        // Add contact as head to contacts chain
        Contact newContact = new Contact(name, data);
        newContact.name = name;
        newContact.data = data;
        newContact.next = contact_book[index];
        contact_book[index] = newContact;
        size++;

        // If the load factor is greater than 0.75, double the size of contact book
        if ((1.0 * size) / contact_book.length >= 0.75) {
            Contact[] oldBook = contact_book;
            contact_book = new Contact[contact_book.length * 2];
            size = 0;
            for (Contact node : oldBook) { // for each contact in linked list
                while (node != null) {
                    addContact(node.name, node.data);
                    node = node.next;
                }
            }
        }
    }

    public void deleteContact(String name) {
        int index = getIndex(name); // index of name we want to delete
        Contact contacts = contact_book[index]; // Contacts linked list of corresponding index

        Contact prev = null; //starting from head
        while (contacts != null) { //search name in contacts linked list
            if (contacts.name.equals(name)) {
                break;
                // if key is not found, check next contact
            } else {
                prev = contacts;
                contacts = contacts.next;
            }
        }
        //if there is no contact in that position
        if (contacts == null) {
            System.out.println("There is no such contact: " + name);
        }

        //remove contact
        if (prev != null) { // if contact is not head in linked list
            if (contacts != null) { //there is such contact
                prev.next = contacts.next;
                size--; //reduce size
                System.out.println("You deleted contact "+ contacts.name);
            }
        } else { // for head of list
            if (contacts != null) { //there is such contact
                contact_book[index] = contact_book[index].next;//replace with next contact
                size--; //reduce size
                System.out.println("You deleted contact "+ contacts.name);
            }
        }
    }

    public void printContactBook() {
        System.out.println();
        System.out.println("This is your contact book");
        for (int i = 0; i < contact_book.length; i++) {
            System.out.print(i + ":  "); // position in HT
            Contact info = contact_book[i]; // to print linked lists by nodes
            while (info != null) {
                System.out.print(info.toString());
                info = info.next;
            }
            System.out.println();
        }
    }

    public void existsContact(String name) {
        int index = getIndex(name); // index for name we want to check
        Contact contacts = contact_book[index]; // Contacts linked list of corresponding index
        while (contacts != null) { //search name in contacts linked list
            if (contacts.name.equals(name)) {
                System.out.println("Contact is found: " + contacts.name);
                return;
            } else {
                contacts = contacts.next;
            }
        }
        System.out.println("There is no such contact: " + name);
    }

    public ContactData searchData(String name) {
        int index = getIndex(name); // index of name we want to find
        Contact contacts = contact_book[index]; // Contacts linked list of corresponding index
        while (contacts != null) { //search name in contacts linked list
            if (contacts.name.equals(name)) {
                return contacts.data;
            } else {
                contacts = contacts.next;
            }
        }
        return null; // if name is not in contact book
    }

    public Object searchName(String mobile_number) {
        for (Contact contact : contact_book) { // for each linked list
            while (contact != null) { //search name in contacts linked list
                if (contact.data.getMobileNumber().equals(mobile_number)) {
                    return "Number "+ mobile_number + " belongs to "+contact.name;
                } else {
                    contact = contact.next;
                }
            }
        }
        System.out.println("There is no such number in contact book: "+mobile_number);
            return null; // if name is not in contact book
        }

        public void contactNames() {
            ArrayList<String> book = new ArrayList<>();// create empty arraylist
            for (Contact contact : contact_book) { //for each linked list
                while (contact != null) {
                    book.add(contact.name); // add names of contacts to arraylist
                    contact = contact.next; //moving on
                }
            }

            // Array list to array
            String[] contact_names = new String[book.size()];
            contact_names = book.toArray(contact_names);
            System.out.println("Contact names");
            System.out.println(Arrays.toString(contact_names));

            // Ordering contact names alphabetically (bubble sort)
            String temp;
            boolean swapped = true;
            while (swapped) {
                swapped = false;
                for (int i = 0; i < contact_names.length - 1; i++) {
                    //if two names are in wrong order swap them
                    if (contact_names[i].compareTo(contact_names[i + 1]) > 0) {
                        temp = contact_names[i];
                        contact_names[i] = contact_names[i + 1];
                        contact_names[i + 1] = temp;
                        swapped = true; // to move on
                    }
                }
            }
            System.out.println("Contact names in alphabetical order");
            System.out.println(Arrays.toString(contact_names));

}
}




