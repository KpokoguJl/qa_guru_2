import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Browsers.OPERA;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class HomeWorkTwoTest {
    @Test
    void firstTest(){
        String firstName = "Ivanov";
        String lastName = "Petr";
        String email = "petr@email.com";
        String phone = "9121111112";
        String address = "Some City, some Street";

        Configuration.browser = OPERA;
        Configuration.browserSize = "1920x1080";
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $x("//label[contains(text(),'Male')]").click();
        $("#userNumber").setValue(phone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
//        $(".react-datepicker__year-select").selectOptionByValue("2010");  //selectOption("2000"); todo Разобраться почему не работает в опере
        $(".react-datepicker__month-select").selectOption("January");
        $("[aria-label='Choose Saturday, January 1st, 2000']").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $x("//label[contains(text(),'Sports')]").click();
        $("#uploadPicture").uploadFromClasspath("file.txt");
        $("#currentAddress").setValue(address);
        $x("//div[contains(text(),'Select State')]").click();
        $x("//div[contains(text(),'NCR')]").click();
        $x("//div[contains(text(),'Select City')]").click();
        $x("//div[contains(text(),'Delhi')]").click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldBe(visible);
        $x("//tbody/tr[1]/td[2]").shouldHave(text(firstName + ' ' + lastName));
        $x("//tbody/tr[2]/td[2]").shouldHave(text(email));
        $x("//tbody/tr[3]/td[2]").shouldHave(text("Male"));
        $x("//tbody/tr[4]/td[2]").shouldHave(text(phone));
        $x("//tbody/tr[5]/td[2]").shouldHave(text("01 January,2000"));
        $x("//tbody/tr[6]/td[2]").shouldHave(text("English"));
        $x("//tbody/tr[7]/td[2]").shouldHave(text("Sports"));
        $x("//tbody/tr[8]/td[2]").shouldHave(text("file.txt"));
        $x("//tbody/tr[9]/td[2]").shouldHave(text(address));
        $x("//tbody/tr[10]/td[2]").shouldHave(text("NCR Delhi"));

    }
}
