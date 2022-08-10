package pages.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {
    public final static String TITLE_TEXT = "Thanks for submitting the form";
    public ResultTableComponent checkVisible() {
        $(".modal-dialog").should(Condition.appear);
        $("#example-modal-sizes-title-lg").shouldHave(text(TITLE_TEXT));
        return this;
    }
    public ResultTableComponent checkResult(String key, String value) {
        $(".table-responsive table").$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

}
