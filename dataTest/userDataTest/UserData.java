package userDataTest;

import ultilities.FakerConfig;

public class UserData {
    public static UserData getUserData(){
        return new UserData();
    }
    private FakerConfig fakerConfig;

    public FakerConfig getFakerConfig() {
        return fakerConfig;
    }
    // Data
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String country;
    private String stateProvince;
    private String city;
    private String address;
    private String zipPostalCode;
    private String phoneNumber;
    // Setter
    public void setEmail() {
        this.email = fakerConfig.getEmail();
    }

    public void setPassword() {
        this.password = fakerConfig.getPassword();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public void setCity(String city) {
        this.city = fakerConfig.getCity();
    }

    public void setAddress(String address) {
        this.address = fakerConfig.getAddress1();
    }

    public void setZipPostalCode(String zipPostalCode) {
        this.zipPostalCode = fakerConfig.getZipCode();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = fakerConfig.getPhoneNumber();
    }

    // Getter
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCountry() {
        return country;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getZipPostalCode() {
        return zipPostalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
