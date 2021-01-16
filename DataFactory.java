package Clase14.Ejercicios.Fakers;

import com.github.javafaker.Faker;
import java.util.Random;

public class DataFactory {
    public static Faker FAKER = new Faker();

    public static String getFirstName(){
        String firstName = FAKER.name().firstName();
        return firstName;

    }
    public static String getLastName(){
        String lastName = FAKER.name().lastName();
        return lastName;

    }
    public static String getEmail(){
        String email = FAKER.internet().emailAddress();
        return email;

    }
    public static String getPhone(){
        Random cellPhone = new Random();
        return String.valueOf(cellPhone.nextInt(1000000) + 1000000000);

    }
    public static String getAdress(){
        String adress = FAKER.address().fullAddress();
        return adress;

    }
    public static String getTitle(){
        String title = FAKER.name().title();
        return title;

    }
    public static String getCompanyName(){
        String companyName = FAKER.company().name();
        return companyName;

    }
}
