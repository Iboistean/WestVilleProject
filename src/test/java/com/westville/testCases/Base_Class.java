package com.westville.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.westville.utilities.ReadConfig;
import org.testng.asserts.SoftAssert;

public class Base_Class {

    ReadConfig readconfig = new ReadConfig();

    public String baseURL = readconfig.getApplicationURL();
    public static WebDriver driver;

    public static Logger logger;

    SoftAssert softAssert =new SoftAssert();


    @Parameters("browser")
    @BeforeClass
    public void setup(String br) {
        logger = Logger.getLogger("WestVille");
        PropertyConfigurator.configure("log4j.properties");

        if (br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/ivanboistean/Documents/SeleniumProjects/Drivers/chromedriver");
            driver = new ChromeDriver();
        } else if (br.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", readconfig.getFireFoxPath());
            driver = new FirefoxDriver();
        } else if (br.equals("safari")) {
            driver = new SafariDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(baseURL);
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }






    public void captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }


}
