package pages.components;

import java.util.function.ToIntFunction;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class CalendarComponent {
    public CalendarComponent setDate(String day, String month, String year) {
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        if (Integer.valueOf(day) <= 9) {
            $(format(".react-datepicker__day--00%s", day)).click();
        } else {
            $(format(".react-datepicker__day--0%s", day)).click();
        }
        return this;

    }

}
