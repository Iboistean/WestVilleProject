package com.westville.testCases;

import com.westville.utilities.XLUtils2;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TC_ValidatingData_002 {


    @Test
    public void compareFile() {

        XLUtils2 inputFile = new XLUtils2("/Users/ivanboistean/Documents/SeleniumProjects/src/test/java/com/westville/testData/MasterMenueInput.xlsx");
        XLUtils2 outputFile = new XLUtils2("/Users/ivanboistean/Documents/SeleniumProjects/src/test/java/com/westville/testData/MasterMenueOutput.xlsx");


        int rowCount = inputFile.getRowCount("INPUT_FILE_BREAKFAST");
        String date = new SimpleDateFormat("MM.dd.yyyy.").format(new Date());

        String outputSheetName = "WV_RT_RESULT_" + date;


        for (int i = 1; i < rowCount; i++) {

            String inputDescription = inputFile.getCellData("INPUT_FILE_BREAKFAST", "DESCRIPTION", i).trim();
            String inputPrice = inputFile.getCellData("INPUT_FILE_BREAKFAST", "PRICE", i).trim();
            String inputDescriptionPrice = inputDescription + inputPrice;


            for (int j = 1 ; j < rowCount; j++) {


                String outputDescription = outputFile.getCellData(outputSheetName, "WEB DESCRIPTION", j).trim();
                String outputlPrice = outputFile.getCellData(outputSheetName, "WEB PRICE", j).trim();
                String outputDescriptionPrice = outputDescription + outputlPrice;


                if (inputDescriptionPrice.equals(outputDescriptionPrice)) {

                    System.out.println("PASSED --> " + inputDescription + " " + inputPrice);


                }

            }


        }











    }
}

