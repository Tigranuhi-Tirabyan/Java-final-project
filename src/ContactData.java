//class for information about contact
public class ContactData {
    private String mobile_number;
    private String mail;
    private String address;
    private String telephone;

    //Constructor
    public ContactData(String number, String mail, String address, String telephone) {
        this.mobile_number = number;
        this.mail = mail;
        this.address = address;
        this.telephone = telephone;
    }

    public String getMobileNumber() {
        return mobile_number;
    }

    public void setNumber(String newNumber) {
        this.mobile_number = newNumber;
    }
    public void setMail(String newMail) {
        this.mail = newMail;
    }
    public void setAddress(String newAddress) {
        this.address = newAddress;
    }
    public void setTelephone(String newTelephone) {
        this.telephone = newTelephone;
    }

    public String toString() {
        return  "number: "+ mobile_number + ", telephone: "+ telephone+", e-mail: "+ mail + ", address: "+ address;
    }
}
