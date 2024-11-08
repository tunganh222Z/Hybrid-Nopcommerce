package ultilities;

import net.datafaker.Faker;

import java.util.Locale;

public class FakerConfig {
    public static FakerConfig getFakerConfig(){
        return new FakerConfig();
    }

    Faker faker = new Faker(Locale.US);

    public String getFirstName(){
        return faker.name().firstName();
    }

    public String getLastName(){
        return faker.name().lastName();
    }

    public String getEmail(){
        return faker.internet().emailAddress();
    }

    public String getPassword(){
        return faker.internet().password(6, 12, true, true, true);
    }

    public String getCompanyName(){
        return faker.company().name();
    }

    public String getAddress1(){
        return faker.address().fullAddress();
    }


    public String getCity(){
        return faker.address().city();
    }

    public String getZipCode(){
        return faker.address().zipCode();
    }

    public String getPhoneNumber(){
        return faker.phoneNumber().phoneNumber();
    }
}
