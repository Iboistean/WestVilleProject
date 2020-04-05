package com.westville.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WestVillePage {

    WebDriver ldriver;

    // Constructor
    public WestVillePage(WebDriver rdriver) {

        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);


    }



    @FindBy(xpath = "//div[contains(@class,'offset-md-1')]")
    List<WebElement> descriptionList;


    @FindBy(xpath = "//div[@class='col-2']")
    List<WebElement> priceList;





    public List <WebElement> getDescription() {

        return descriptionList;

    }


    public List <WebElement> getPrice() {

        return priceList;

    }





}

