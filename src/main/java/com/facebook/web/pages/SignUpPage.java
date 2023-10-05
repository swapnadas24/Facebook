package com.facebook.web.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.facebook.web.base.FacebookWebbase;

public class SignUpPage extends FacebookWebbase {

    @FindBy(xpath = "//div[@class='_6ltg']//a[@role='button']")
    WebElement CreateNewAccount_tab;

    @FindBy(name = "firstname")
    WebElement firstName;

    @FindBy(name = "lastname")
    WebElement lastName;

    @FindBy(xpath = "//input[@aria-label='Mobile number or email address']")
    WebElement EmailmobileNumber;

    @FindBy(xpath = "//input[@aria-label='Re-enter email address']")
    WebElement ReEmailmobileNumber;

    @FindBy(xpath = "//input[@aria-label='New password']")
    WebElement password;

    @FindBy(xpath = "//select[@aria-label='Day']")
    WebElement Dates;

    @FindBy(xpath = "//select[@aria-label='Day']/option")
    List<WebElement> dateOption;

    @FindBy(xpath = "//select[@aria-label='Month']")
    WebElement months;

    @FindBy(xpath = "//select[@aria-label='Month']/option")
    List<WebElement> monthOption;

    @FindBy(xpath = "//select[@aria-label='Year']")
    WebElement years;

    @FindBy(xpath = "//select[@aria-label='Year']/option")
    List<WebElement> yearOption;

    @FindBy(xpath = "//span/label[contains(text(),'Female')]")
    WebElement select_Female;

    @FindBy(xpath = "//span/label[contains(text(),'Male')]")
    WebElement select_Male;

    @FindBy(xpath = "//span/label[contains(text(),'Custom')]")
    WebElement select_Custom;

    @FindBy(xpath = "//select[@aria-label='Select your pronoun']")
    WebElement selct_pronoun;

    @FindBy(xpath = "//select[@aria-label='Select your pronoun']/option")
    List<WebElement> selct_Your_pronoun;

    @FindBy(xpath = "//select[@aria-label='Select your pronoun']/option[contains(text(),'Select your pronoun')]")
    WebElement Select_Your_pronoun;

    // initialize the page object
    public SignUpPage() {

        PageFactory.initElements(driver, this);

    }

    public void click_CreateNewAccount_tab() throws InterruptedException {

        CreateNewAccount_tab.click();
        Thread.sleep(2000);
    }

    public void first_LastName(String fName, String lName) {

        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
    }

    public void enter_emailOrMobile(String mobile, String pwd) {

        EmailmobileNumber.sendKeys(mobile);
        ReEmailmobileNumber.sendKeys(mobile);
        password.sendKeys(pwd);

    }

    public void select_Date() {

        Select date = new Select(Dates);

        // Generate a random index within the range of available options
        Random randomDate = new Random();
        int randomDateIndex = randomDate.nextInt(dateOption.size());

        // select any random date
        date.selectByIndex(randomDateIndex);
    }

    public void select_Month() {

        Select month = new Select(months);

        // Generate a random index within the range of available options
        Random randomMonth = new Random();
        int randomMonthIndex = randomMonth.nextInt(monthOption.size());

        // select any random month
        month.selectByIndex(randomMonthIndex);
    }

    public void select_Year() {

        Select year = new Select(years);

        // Generate a random index within the range of available options
        Random random = new Random();
        int randomYear;

        // Determine the range of years available
        int maxYear = Integer.parseInt(yearOption.get(0).getText());
        int minYear = Integer.parseInt(yearOption.get(yearOption.size() - 1).getText());

        do {
            randomYear = random.nextInt(maxYear - minYear + 1) + minYear;
        } while (randomYear >= 2005);
        year.selectByVisibleText(Integer.toString(randomYear));
    }

    public void select_Gender() {

        WebElement[] gender = { select_Female, select_Male, select_Custom };

        Random randomGender = new Random();

        int randomGenderIndex = randomGender.nextInt(gender.length);

        if (gender[randomGenderIndex] == select_Female) {

            gender[randomGenderIndex].click();

        } else if (gender[randomGenderIndex] == select_Male) {

            gender[randomGenderIndex].click();

        } else {

            gender[randomGenderIndex].click();

            Select pronouns = new Select(selct_pronoun);

            Random randomPronouns = new Random();
            int randomPronounsIndex = randomPronouns.nextInt(selct_Your_pronoun.size());

            // select random pronoun
            if (selct_Your_pronoun == Select_Your_pronoun) {

                pronouns.deselectByIndex(randomPronounsIndex);

            } else {

                pronouns.selectByIndex(randomPronounsIndex);
            }
        }
    }
}
