package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.github.javafaker.Faker;
import utils.RandomUtils;

import static java.lang.String.format;
import static tests.TestData.*;

public class RegistrationFormTest extends TestBase {

    Faker faker = new Faker();

    String firstName,
            lastName,
            userEmail,
            userPhoneNumber,
            userGender,
            day,
            month,
            year,
            userHobby,
            userAddress,
            userFullName,
            userDateOfBirth;


    @BeforeEach
    void prepareTestData() {
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        userEmail = faker.internet().emailAddress();
        userPhoneNumber = faker.phoneNumber().subscriberNumber(10);
        day = faker.number().numberBetween(1, 28) + "";
        month = RandomUtils.getRandomMonth();
        year = faker.number().numberBetween(1900, 2010) + "";
        userAddress = faker.address().fullAddress();
        userGender = RandomUtils.getRandomGender();
        userHobby = RandomUtils.getRandomHobby();
        userFullName = format("%s %s",firstName, lastName);
        userDateOfBirth = format("%s %s,%s",day,month,year);

    }

    @Test
    void successRegistrationAllFields() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPhoneNumber(userPhoneNumber)
                .setEmail(userEmail)
                .setGender(userGender)
                .setBirthDay(day, month, year)
                .setSubject(userSubject)
                .setHobby(userHobby)
                .uploadPicture(userPicture)
                .setAddress(userAddress)
                .setStateAndCity(userState, userCity)
                .submit();
        String userStateAndCity = format("%s %s", userState, userCity);

        registrationFormPage.checkResultTableVisible();
        registrationFormPage.checkResult("Student Name", userFullName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userPhoneNumber)
                .checkResult("Date of Birth", userDateOfBirth)
                .checkResult("Subjects", userSubject)
                .checkResult("Hobbies", userHobby)
                .checkResult("Picture", shortPicture)
                .checkResult("Address", userAddress)
                .checkResult("State and City",userStateAndCity);


    }

    @Test
    void successRegistrationRequiredFields() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPhoneNumber(userPhoneNumber)
                .setGender(userGender)
                .setBirthDay(day, month, year)
                .submit();
        registrationFormPage.checkResultTableVisible();
        registrationFormPage.checkResult("Student Name", userFullName)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userPhoneNumber)
                .checkResult("Date of Birth", userDateOfBirth);

    }
}