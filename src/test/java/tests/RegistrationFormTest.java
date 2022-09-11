package tests;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.github.javafaker.Faker;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.RandomUtils;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;
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
        userFullName = format("%s %s", firstName, lastName);
        userDateOfBirth = format("%s %s,%s", day, month, year);

    }




    @Test
    @DisplayName("Success Registration on demoqa with All Fields")
    @Owner("Tanya")
    @Story("Demoqa registration form")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://demoqa.com")
    void successRegistrationAllFields() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open main page and insert data in all fields", () -> {
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
            ;
        });

        step("Check result modal window is open", () -> {
            registrationFormPage.checkResultTableVisible();
        });
        step("Check result data on registration form", () -> {
            String userStateAndCity = format("%s %s", userState, userCity);
            registrationFormPage.checkResult("Student Name", userFullName)
                    .checkResult("Student Email", userEmail)
                    .checkResult("Gender", userGender)
                    .checkResult("Mobile", userPhoneNumber)
                    .checkResult("Date of Birth", userDateOfBirth)
                    .checkResult("Subjects", userSubject)
                    .checkResult("Hobbies", userHobby)
                    .checkResult("Picture", shortPicture)
                    .checkResult("Address", userAddress)
                    .checkResult("State and City", userStateAndCity);
        });
        Attach.addVideo();
        Attach.takeScreenshot();


    }

    @Test
    @DisplayName("Success Registration on demoqa with only Required Fields")
    @Owner("Tanya")
    @Story("Demoqa registration form")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://demoqa.com")
    void successRegistrationRequiredFields() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open main page and insert data in only Required fields", () -> {
            registrationFormPage.openPage()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setPhoneNumber(userPhoneNumber)
                    .setGender(userGender)
                    .setBirthDay(day, month, year)
                    .submit();
        });
        step("Check result modal window is open", () -> {
            registrationFormPage.checkResultTableVisible();
        });
        step("Check result data on registration form", () -> {
            registrationFormPage.checkResult("Student Name", userFullName)
                    .checkResult("Gender", userGender)
                    .checkResult("Mobile", userPhoneNumber)
                    .checkResult("Date of Birth", userDateOfBirth);
        });
        Attach.addVideo();
        Attach.takeScreenshot();

    }
}