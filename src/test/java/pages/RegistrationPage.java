package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;


import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    private final String Title_Form = "Student Registration Form";
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderSelector = $("#genterWrapper").$(byText("Female")),
            phoneNumberInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            hobbieInput = $("#hobbiesWrapper").$(byText("Reading")),
            fileUploadButton = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateDropdown = $("#stateCity-wrapper").$(byText("Select State")),
            stateNameSelector = $("#stateCity-wrapper"),
            cityDropdown = $("#stateCity-wrapper").$(byText("Select City")),
            submitButton = $("#submit"),
            resultsTable = $("tbody");

    public CalendarComponent calendar = new CalendarComponent();

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(Title_Form));
    }

    public RegistrationPage enterFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage enterLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage enterEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }

    public RegistrationPage selectGender() {
        genderSelector.click();
        return this;
    }

    public RegistrationPage enterPhoneNumber(String phoneNumber) {
        phoneNumberInput.setValue(phoneNumber);
        return this;
    }

    public RegistrationPage enterSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage enterHobbie() {
        hobbieInput.click();
        return this;
    }

    public RegistrationPage uploadFile(String pathName) {
        fileUploadButton.uploadFile(new File(pathName));
        return this;
    }

    public RegistrationPage enterCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress).pressEnter();
        return this;
    }

    public RegistrationPage selectState(String state) {
        stateDropdown.scrollIntoView(true).click();
        stateNameSelector.$(byText(state)).click();
        return this;
    }

    public RegistrationPage selectCity(String city) {
        cityDropdown.scrollIntoView(true).click();
        stateNameSelector.$(byText(city)).click();
        return this;
    }

    public RegistrationPage clickSubmit() {
        submitButton.click();
        return this;
    }

    public void checkResults(String firstName,
                             String lastName,
                             String userEmail,
                             String phoneNumber,
                             String subject,
                             String currentAddress,
                             String state,
                             String city,
                             String month,
                             String year,
                             int day
    ) {
        resultsTable.shouldHave(
                text(firstName + " " + lastName),
                text(userEmail),
                text(phoneNumber),
                text(subject),
                text(currentAddress),
                text(state),
                text(city),
                text(day + " " + month + "," + year)
        );

    }

}