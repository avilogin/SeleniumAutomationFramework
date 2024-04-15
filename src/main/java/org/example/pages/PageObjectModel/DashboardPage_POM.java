package org.example.pages.PageObjectModel;

import org.openqa.selenium.By;
import org.example.base.CommonToAllPage;

public class DashboardPage_POM extends CommonToAllPage{

    public DashboardPage_POM(){

    }


    // Page Locators
    By userNameOnDashboard = By.cssSelector("[data-qa=\"lufexuloga\"]");



    // Page Actions
    public String loggedInUserName() {
        presenceOfElement(userNameOnDashboard);
        return getElement(userNameOnDashboard).getText();
    }

}
