public class Contact {
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String city;
    // Add other relevant details as needed

    public Contact(String name, String phoneNumber, String emailAddress,String city) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
         this.city=city;
    }

    // Add getters and setters for each attribute

    public String getName() {
        return name;
    }
    public String getCity() {
        return city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
    public void setPhoneNumber(String n){
     phoneNumber=n;
    }
    public void setEmailAddress(String e){
     emailAddress=e;
    }
    public void setCity(String n){
     city=n;
    }
}