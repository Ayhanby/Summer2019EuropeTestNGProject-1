package com.cybertek.pages;


import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateCalendarEventsPage extends BasePage {

    public CreateCalendarEventsPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[id^='recurrence-repeat-view']")
    public WebElement repeat;

    @FindBy(xpath = "//*[@*='btn-success btn dropdown-toggle']")
    public WebElement saveAndClose;

    @FindBy(xpath = "//*[@*='action-button dropdown-item']")
    public WebElement subSaveAndClose;

    @FindBy(xpath = "(//*[@*='main-group action-button dropdown-item'])[1]")
    public WebElement saveAndNew;

    @FindBy(xpath = "(//*[@*='main-group action-button dropdown-item'])[2]")
    public WebElement save;

    @FindBy(xpath = "//*[@*='btn back icons-holder-text ']")
    public WebElement cancel;

    @FindBy(xpath = "//*[@*='oro-subtitle']")
    public WebElement allCalendarEventsSubtitle;

    @FindBy(css = "[id^='recurrence-repeats-view']")
    public WebElement repeatOptions;

    @FindBy(xpath = "(//*[@*='weekly'])[1]")
    public WebElement repeatWeekly;

    @FindBy(xpath = "(//*[@*='monday'])[3]")
    public WebElement monday;

    @FindBy(xpath = "(//*[@*='friday'])[3]")
    public WebElement friday;

    @FindBy(className = "select2-chosen")
    public WebElement selectedOwner;

    @FindBy(css = "input[id^='oro_calendar_event_form_title-']")
    public WebElement title;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    public WebElement startDate;
    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_end']")
    public WebElement endDate;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_start']")
    public WebElement startTime;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_end']")
    public WebElement endTime;

    @FindBy(xpath = "//*[@*='oro_calendar_event_form_allDay']")
    public WebElement allDayEventCheckBox;

    @FindBy(xpath = "(//input[@type='radio'])[1]")
    public WebElement days;

    @FindBy(xpath = "(//input[@type='radio'])[2]")
    public WebElement weekday;

    @FindBy(xpath = "(//*[@*='radio'])[1]")
    public WebElement repeatEveryCheckBox;

    @FindBy(xpath = "(//input[@type='radio'])[3]")
    public WebElement never;

    @FindBy(xpath = "(//input[@type='radio'])[4]")
    public WebElement after;

    @FindBy(xpath = "(//*[@*='recurrence-subview-control__number'])[7]")
    public WebElement occurrences;

    @FindBy(xpath = "(//input[@type='radio'])[5]")
    public WebElement by;

    @FindBy(xpath = "//*[@class='datepicker-input hasDatepicker']")
    public WebElement byDateBox;

    @FindBy(xpath = "//*[@*='recurrence-summary']")
    public WebElement summary;

    public Select repeatOptionsList(){
        return new Select(repeatOptions);
    }

}
