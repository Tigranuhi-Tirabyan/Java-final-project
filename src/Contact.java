//Contact node for linked lists
public class Contact {
    public String name; //key
    public ContactData data; //value
    public Contact next;  // Reference to next contact

    // Constructor
    public Contact(String name, ContactData data) {
        this.name = name;
        this.data = data;
        this.next = null;
    }

    public String toString() {
        return "[" + name + " - " + data.toString() + "]";
    }
}
