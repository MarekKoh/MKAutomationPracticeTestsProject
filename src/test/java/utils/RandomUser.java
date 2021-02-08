package utils;

import com.github.javafaker.Faker;

public class RandomUser {
    public String firstName;
    public String lastName;
    public String email;
    Boolean isRegistered = false;
    public String password = "1qaz!QAZ";
    public int yearOfBirth;
    public int dayOfBirth;
    public int monthOfBirth;
    public String postalCode;
    public String state;
    public String address1;
    public String address2;
    public String city;
    public String mobilePhone;



    public RandomUser() {
        Faker faker = new Faker();
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.email = this.firstName + this.lastName + faker.random().nextInt(100000) + "@gmail.com";
        this.dayOfBirth = faker.date().birthday().getDay() + 1;
        this.monthOfBirth = faker.date().birthday().getMonth() +1;
        this.postalCode = String.valueOf(faker.random().nextInt(10000, 99999));
        this.state = faker.address().state();
        this.yearOfBirth = (faker.date().birthday().getYear() + 1900);
        this.address1 = faker.address().streetAddress();
        this.address2 = faker.address().streetAddress();
        this.mobilePhone = faker.phoneNumber().cellPhone();
        this.city = faker.address().city();
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "RandomUser{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", isRegistered=" + isRegistered +
                ", password='" + password + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", dayOfBirth=" + dayOfBirth +
                ", monthOfBirth=" + monthOfBirth +
                ", postalCode='" + postalCode + '\'' +
                ", state='" + state + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
