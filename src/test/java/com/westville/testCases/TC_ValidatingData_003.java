package com.westville.testCases;

import com.westville.utilities.XLUtils2;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TC_ValidatingData_003 {


    @Test
    public void compareFile() {

        XLUtils2 inputFile = new XLUtils2("/Users/ivanboistean/Documents/SeleniumProjects/src/test/java/com/westville/testData/MasterMenueInput.xlsx");
        XLUtils2 outputFile = new XLUtils2("/Users/ivanboistean/Documents/SeleniumProjects/src/test/java/com/westville/testData/MasterMenueOutput.xlsx");


        int rowCount = inputFile.getRowCount("INPUT_FILE_BREAKFAST");
        String date = new SimpleDateFormat("MM.dd.yyyy.").format(new Date());

        String outputSheetName = "WV_RT_RESULT_" + date;


        for (int i = 2; i <= rowCount; i++) {

            String inputDescription = inputFile.getCellData("INPUT_FILE_BREAKFAST", "DESCRIPTION", i).trim();
            String inputPrice = inputFile.getCellData("INPUT_FILE_BREAKFAST", "PRICE", i).trim();
            String inputDescriptionPrice = inputDescription + inputPrice;

            String outputDescription = outputFile.getCellData(outputSheetName, "WEB DESCRIPTION", i).trim();
            String outputlPrice = outputFile.getCellData(outputSheetName, "WEB PRICE", i).trim();
            String outputDescriptionPrice = outputDescription + outputlPrice;


            if (inputDescriptionPrice.equals(outputDescriptionPrice)) {


                System.out.println("PASSED --> " + inputDescriptionPrice + " " + outputDescriptionPrice);


            } else {


                for (int j = 2; j <= rowCount; j++) {


                    String outputDescription1 = outputFile.getCellData(outputSheetName, "WEB DESCRIPTION", j).trim();
                    String outputlPrice1 = outputFile.getCellData(outputSheetName, "WEB PRICE", j).trim();
                    String outputDescriptionPrice1 = outputDescription1 + outputlPrice1;


                    if (inputDescriptionPrice.equals(outputDescriptionPrice1)) {

                        System.out.println("PASSED_SECOND_TIME --> " + inputDescriptionPrice + " " + outputDescriptionPrice1);



                    }




                }


            }


        }
    }
}


