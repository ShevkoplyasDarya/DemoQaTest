package ru.shevkoplyas.tests;

import com.codeborne.selenide.commands.ToString;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import ru.shevkoplyas.pages.RegistrationPage;

public class TestRegistrationFormWithPageObject extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    String currentAddress = faker.address().fullAddress();
    int day = faker.number().numberBetween(10, 30);
    String month = "October";
    String year = "1990";
    String subject = "Maths";
    String pathName = "src/test/resourses/images/squirrel.jpg";
    String state = "Rajasthan";
    String city = "Jaipur";


    @Test
    void fillFormTest() {
        registrationPage.openPage();
        registrationPage.enterFirstName(firstName)
                .enterLastName(lastName)
                .enterEmail(userEmail)
                .selectGender()
                .enterPhoneNumber(phoneNumber)
                .enterSubject(subject)
                .enterHobbie()
                .uploadFile(pathName)
                .enterCurrentAddress(currentAddress)
                .selectState(state)
                .selectCity(city);
        registrationPage.calendar.setDate(day, month, year);
        registrationPage.clickSubmit()
                .checkResults(firstName,
                        lastName,
                        userEmail,
                        phoneNumber,
                        subject,
                        currentAddress,
                        state,
                        city,
                        month,
                        year,
                        day);

    }
}
