package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "(//*[@class='dropdown-toggle'])[6]")
    public WebElement treedots;

    @FindBy(xpath = "(//*[@*='View'])[6]")
    public WebElement view;

    @FindBy(xpath = "(//*[@*='Edit'])[6]")
    public WebElement edit;

    @FindBy(xpath = "(//*[@*='Delete'])[6]")
    public WebElement delete;

    @FindBy(xpath = "//*[@class='fa-cog hide-text']")
    public WebElement grid;

    @FindBy(xpath = "(//*[@*='checkbox'])[7]")
    public WebElement titleCheckbox;

    @FindBy(xpath = "(//*[@*='checkbox'])[8]")
    public WebElement calendarCheckbox;

    @FindBy(xpath = "(//*[@*='checkbox'])[9]")
    public WebElement startCheckbox;

    @FindBy(xpath = "(//*[@*='checkbox'])[10]")
    public WebElement endCheckbox;

    @FindBy(xpath = "(//*[@*='checkbox'])[11]")
    public WebElement recurrentCheckbox;

    @FindBy(xpath = "(//*[@*='checkbox'])[12]")
    public WebElement recurrenceCheckbox;

    @FindBy(xpath = "(//*[@*='checkbox'])[13]")
    public WebElement invalidStatusCheckbox;




}
