package com.westville.testCases;

import com.westville.pageObject.WestVillePage;
import com.westville.utilities.XLUtils2;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TC_GettingData_001 extends Base_Class {


    @Test
    public void getWebData() {


        String date = new SimpleDateFormat("MM.dd.yyyy.").format(new Date());
        logger.info("Getting the Today's Date");

        String sheetName = "WV_RT_RESULT_" + date;
        logger.info("Creating Sheet Name with the date");


        XLUtils2 outputFile = new XLUtils2("/Users/ivanboistean/Documents/SeleniumProjects/src/test/java/com/westville/testData/MasterMenueOutput.xlsx");

        logger.info("Checking if the Sheet Exist or Not");
        if (outputFile.isSheetExist(sheetName)) {

            outputFile.removeSheet(sheetName);

        }


        outputFile.addSheet(sheetName);
        logger.info("Creating the Sheet with the New SheetName");

        outputFile.addColumn(sheetName, "WEB DESCRIPTION");
        logger.info("Creating Column 1");
        outputFile.addColumn(sheetName, "WEB PRICE");
        logger.info("Creating Column 2");



        WestVillePage wv = new WestVillePage(driver);
        logger.info("Initialing the WebPage");

        int webElementSize = wv.getDescription().size();
        logger.info("Getting the size of the Elements ");

        int j = 2;


        logger.info("Creating the Loop and writing the data from web into Excel file");
        for (int i = 0; i < webElementSize; i++) {

            String description = wv.getDescription().get(i).getText();
            String price = wv.getPrice().get(i).getText();

            outputFile.setCellData(sheetName, "WEB DESCRIPTION", j, description);
            outputFile.setCellData(sheetName, "WEB PRICE", j, price);
            j++;


        }
        logger.info("Test Succeseful Passed");
    }


}
