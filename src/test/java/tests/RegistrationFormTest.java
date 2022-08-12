package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;


public class RegistrationFormTest {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }


    @Test
    void successRegistrationAllFields() {
        registrationFormPage.openPage()
                .setFirstName("Tanya")
                .setLastName("Inanova")
                .setPhoneNumber("1234567890")
                .setEmail("q@mail.com")
                .setGender("Female")
                .setBirthDay("31", "July", "1990")
                .setSubject("English")
                .setSubject("Math")
                .setHobby("Reading")
                .setHobby("Music")
                .setHobby("Sports")
                .uploadPicture("src/test/resources/photo.jpg")
                .setAddress("Moscow, Gagarina 1")
                .setStateAndCity("NCR", "Delhi")
                .submit();

        registrationFormPage.checkResultTableVisible();
        registrationFormPage.checkResult("Student Name", "Tanya Inanova")
                .checkResult("Student Email", "q@mail.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "31 July,1990")
                .checkResult("Subjects", "English, Math")
                .checkResult("Hobbies", "Reading, Music, Sports")
                .checkResult("Picture", "photo.jpg")
                .checkResult("Address", "Moscow, Gagarina 1")
                .checkResult("State and City", "NCR Delhi");


    }

    @Test
    void successRegistrationRequiredFields() {
        registrationFormPage.openPage()
                .setFirstName("Tanya")
                .setLastName("Inanova")
                .setPhoneNumber("1234567890")
                .setGender("Female")
                .setBirthDay("31", "July", "1990")
                .submit();
        registrationFormPage.checkResultTableVisible();
        registrationFormPage.checkResult("Student Name", "Tanya Inanova")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "31 July,1990");

    }
}