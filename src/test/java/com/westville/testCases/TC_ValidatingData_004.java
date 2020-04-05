package com.westville.testCases;

import com.westville.utilities.XLUtils2;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TC_ValidatingData_004 extends Base_Class {


    @Test
    public void compareFile() throws IOException {

        logger.info("Reading data from Excel Files");

        XLUtils2 inputFile = new XLUtils2("/Users/ivanboistean/Documents/SeleniumProjects/src/test/java/com/westville/testData/MasterMenueInput.xlsx");
        XLUtils2 outputFile = new XLUtils2("/Users/ivanboistean/Documents/SeleniumProjects/src/test/java/com/westville/testData/MasterMenueOutput.xlsx");



        logger.info("Creating a Name with Today Date for Excel Sheet");
        int rowCount = inputFile.getRowCount("INPUT_FILE_BREAKFAST");
        String date = new SimpleDateFormat("MM.dd.yyyy.").format(new Date());

        String outputSheetName = "WV_RT_RESULT_" + date;


        logger.info("Starting to Loop");
        for (int i = 2; i <= rowCount; i++) {

            String inputDescription = inputFile.getCellData("INPUT_FILE_BREAKFAST", "DESCRIPTION", i).trim();
            String inputPrice = inputFile.getCellData("INPUT_FILE_BREAKFAST", "PRICE", i).trim();
            String inputDescriptionPrice = inputDescription + inputPrice;

            String outputDescription = outputFile.getCellData(outputSheetName, "WEB DESCRIPTION", i).trim();
            String outputlPrice = outputFile.getCellData(outputSheetName, "WEB PRICE", i).trim();
            String outputDescriptionPrice = outputDescription + outputlPrice;

            if (inputDescriptionPrice.equals(outputDescriptionPrice)) {

                softAssert.assertTrue(true);
                softAssert.assertAll();
                logger.info("PASSED --> " + inputDescriptionPrice + " / " + outputDescriptionPrice);



            } else {

                captureScreen(driver,"compareFile");

                softAssert.assertFalse(false);
                softAssert.assertAll();

                logger.warn("FAILED --> " + inputDescriptionPrice + " / " + outputDescriptionPrice);



            }

        }


    }
}







