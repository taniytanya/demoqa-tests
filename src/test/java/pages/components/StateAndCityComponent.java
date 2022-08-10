package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StateAndCityComponent {
    public StateAndCityComponent setStateCity(String State, String city) {
        $("#state").click();
        $(byText(State)).click();
        $("#city").click();
        $(byText(city)).click();
        return this;

    }

}
