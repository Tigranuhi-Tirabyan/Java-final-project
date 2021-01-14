public class test_main {
    public static void main(String[] args) {
        ContactBook contact_book = new ContactBook(15);
        ContactData Adam = new ContactData("077-77-78-79","Adam@gmail.com", "Yerevan", "-");
        ContactData Aram = new ContactData("094-64-68-72","Aram@gmail.com", "Vanadzor", "-");
        ContactData Mariam= new ContactData("093-05-03-20","Mariam@gmail.com", "Gyumri",
                "012-16-16-10");
        ContactData Tigran = new ContactData("098-19-21-19","Tigran@gmail.com","Yerevan", "-");
        ContactData newAram = new ContactData("098-15-16-19","Aram2@gmail.com","Yerevan", "-");
        ContactData Armen = new ContactData("094-54-73-62","Armen@gmail.com", "Vanadzor", "-");
        ContactData Suren = new ContactData("094-64-68-72","Suren@gmail.com", "Yerevan", "-");
        ContactData Maya = new ContactData("093-65-98-52","Maya@gmail.com", "Yerevan", "-");
        ContactData Ara = new ContactData("093-05-10-15","Ara@gmail.com", "Yerevan", "-");
        contact_book.addContact("Adam", Adam);
        contact_book.addContact("Aram", Aram);
        contact_book.addContact("Mariam Sargsyan", Mariam);
        contact_book.addContact("Tigran Khachatryan", Tigran);
        contact_book.addContact("Armen Antonyan", Armen);
        contact_book.addContact("Suren", Suren);
        contact_book.addContact("Maya", Maya);
        contact_book.addContact("Ara", Ara);
        contact_book.printContactBook();
        System.out.println("Count of contacts: "+ contact_book.getSize());
        contact_book.existsContact("Adam");
        System.out.println("Information about Adam - "+ contact_book.searchData("Adam"));
        Adam.setTelephone("3-13-63");
        Adam.setAddress("Ijevan");
        Adam.setMail("Adam@yahoo.com");
        Adam.setNumber("077-77-78-80");
        System.out.println("New information about Adam - "+ contact_book.searchData("Adam"));
        contact_book.addContact("Aram", newAram);
        contact_book.deleteContact("Mariam");
        contact_book.existsContact("Mariam Sargsyan");
        contact_book.deleteContact("Mariam Sargsyan");
        contact_book.printContactBook();
        System.out.println("Count of contacts: "+ contact_book.getSize());
        contact_book.existsContact("Mariam Sargsyan");
        System.out.println(contact_book.searchName("077-77-78-80"));
        System.out.println(contact_book.searchName("098-19-21-15"));
        contact_book.contactNames();
    }
}
