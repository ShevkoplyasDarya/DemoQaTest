package ru.shevkoplyas;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestRegistrationForm {
        @BeforeAll
        static void beforeAll() {
        Configuration.startMaximized = true;
        }

        @AfterEach
        void afterAll() {
        Selenide.closeWebDriver();
        }

        @Test
        void fillFormTest() {

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Kate");
        $("#lastName").setValue("Smith");
        $("#userEmail").setValue("katesmith@gmail.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("9212313427");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("9");
        $(".react-datepicker__year-select").selectOptionByValue("1990");
        $(".react-datepicker__day--016").click();
        $("#subjectsInput").setValue("A").pressEnter();
        $("#subjectsInput").setValue("B").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();

        //upload image
        File image = new File("src/test/java/resourses/squirrel.jpg");
        $("#uploadPicture").uploadFile(image);

        $("#currentAddress").setValue("Elm street, 10").pressEnter();
        $("#stateCity-wrapper").$(byText("Select State")).scrollIntoView(true).click();
        $("#stateCity-wrapper").$(byText("Rajasthan")).click();
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $("#stateCity-wrapper").$(byText("Jaipur")).click();
        $("#submit").click();

        //submitted form
        $x("//table/tbody/tr[1]").shouldHave(text("Kate Smith"));
        $x("//table/tbody/tr[2]").shouldHave(text("katesmith@gmail.com"));
        $x("//table/tbody/tr[3]").shouldHave(text("Female"));
        $x("//table/tbody/tr[4]").shouldHave(text("9212313427"));
        $x("//table/tbody/tr[5]").shouldHave(text("16 October,1990"));
        $x("//table/tbody/tr[6]").shouldHave(text("Maths, Biology"));
        $x("//table/tbody/tr[7]").shouldHave(text("Reading"));
        $x("//table/tbody/tr[8]").shouldHave(text("squirrel.jpg"));
        $x("//table/tbody/tr[9]").shouldHave(text("Elm street, 10"));
        $x("//table/tbody/tr[10]").shouldHave(text("Rajasthan Jaipur"));
        $("#closeLargeModal").scrollIntoView(true).click();

        }
        }
