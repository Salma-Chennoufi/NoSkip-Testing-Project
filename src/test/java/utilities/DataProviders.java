package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    // DataProvider 1

    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {

        String path = "./testData/LoginData.xlsx";

        ExcelUtility xlutil = new ExcelUtility(path);

        int totalRows = xlutil.getRowCount("Feuille 1");
        int totalCols = xlutil.getCellCount("Feuille 1", 1);

        String[][] loginData = new String[totalRows][totalCols];

        for (int i = 1; i <= totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                loginData[i-1][j] = xlutil.getCellData("Feuille 1", i, j);
            }
        }
        return loginData;
    }

    // DataProvider2
    @DataProvider(name = "CreateClassData")
    public String[][] getClassData() throws IOException {

        String path = "./testData/CreateClassData.xlsx";

        ExcelUtility xlutil = new ExcelUtility(path);

        int totalRows = xlutil.getRowCount("Feuille 1");
        int totalCols = xlutil.getCellCount("Feuille 1", 1);

        String[][] classData = new String[totalRows][totalCols];

        for (int i = 1; i <= totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                classData[i-1][j] = xlutil.getCellData("Feuille 1", i, j);
            }
        }
        return classData;
    }

    // DataProvider3
    @DataProvider(name = "EditClassData")
    public String[][] editClassData() {
        String[][] data = {
                {"GI3", "Cloud", "2026"}
        };
        return data;
    }

}
