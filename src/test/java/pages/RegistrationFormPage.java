package pages;


import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultTableComponent;
import pages.components.StateAndCityComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    public final static String TITLE_TEXT = "Student Registration Form";
    private CalendarComponent calendarComponent = new CalendarComponent();
    private StateAndCityComponent stateAndCityComponent = new StateAndCityComponent();
    private ResultTableComponent resultTableComponent = new ResultTableComponent();
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            phoneNumber = $("#userNumber"),
            genderMale = $("#gender-radio-1"),
            genderFemale = $("#gender-radio-2"),
            genderOther = $("#gender-radio-3"),
            subjectsInput = $("#subjectsInput"),
            sportsInput = $("[for = hobbies-checkbox-1]"),
            readingInput = $("[for = hobbies-checkbox-2]"),
            musicInput = $("[for = hobbies-checkbox-3]"),
            pictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            submitButton = $("#submit");


    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;

    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setPhoneNumber(String value) {
        phoneNumber.setValue(value);
        return this;
    }

    public RegistrationFormPage setGender(String value) {
        if (value == "Male") {
            genderMale.parent().click();
        } else if (value == "Female") {
            genderFemale.parent().click();
        } else {
            genderOther.parent().click();
        }
        return this;

    }

    public RegistrationFormPage setBirthDay(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPage setHobby(String value) {
        if (value == "Sports") {
            sportsInput.click();
        } else if (value == "Reading") {
            readingInput.click();
        } else {
            musicInput.click();
        }
        return this;
    }

    public RegistrationFormPage uploadPicture(String value) {
        pictureInput.uploadFile(new File(value));
        return this;
    }

    public RegistrationFormPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setStateAndCity(String state, String city) {
        stateAndCityComponent.setStateCity(state, city);
        return this;
    }

    public RegistrationFormPage checkResultTableVisible() {
        resultTableComponent.checkVisible();
        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        resultTableComponent.checkResult(key, value);
        return this;
    }

    public RegistrationFormPage submit() {
        submitButton.click();
        return this;
    }


}