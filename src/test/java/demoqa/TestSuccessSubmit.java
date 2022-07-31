package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestSuccessSubmit {
    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }


    @Test
    void successSubmit() {
        open("/automation-practice-form");
        $("#firstName").setValue("Tanya");
        $("#lastName").setValue("Inanova");
        $("#userEmail").setValue("Tanya@gmail.com");
        $("[for='gender-radio-2']").click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(6);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionContainingText("1990");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__day--031").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("[for = hobbies-checkbox-1]").click();
        $("[for = hobbies-checkbox-2]").click();
        $("[for = hobbies-checkbox-3]").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/photo.jpg"));
        $("#currentAddress").setValue("Moscow, Gagarina 1");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Tanya Inanova"));
        $(".modal-body").shouldHave(text("Tanya@gmail.com"));
        $(".modal-body").shouldHave(text("Female"));
        $(".modal-body").shouldHave(text("1234567890"));
        $(".modal-body").shouldHave(text("31 July,1990"));
        $(".modal-body").shouldHave(text("Moscow, Gagarina 1"));
        $(".modal-body").shouldHave(text("English, Math"));
        $(".modal-body").shouldHave(text("Sports, Reading, Music"));
        $(".modal-body").shouldHave(text("photo.jpg"));
        $(".modal-body").shouldHave(text("NCR Delhi"));

    }
}