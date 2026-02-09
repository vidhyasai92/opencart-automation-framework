package utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {

	    // DataProvider 1
	    @DataProvider(name = "LoginData")
	    public String[][] getData() throws IOException {
	        
	        // Path of Excel file from testData folder
	        String path = "./Opencart100/testData/OpenCartLogindata.ods";
	        
	        // Creating object for ExcelUtility
	        ExcelUtility xlutil = new ExcelUtility(path);
	        
	        // Get total rows and columns from Sheet1
	        int totalRows = xlutil.getRowCount("Sheet1");
	        int totalCols = xlutil.getCellCount("Sheet1", 1);
	        
	        // Create two-dimensional array [rows][columns]
	        String loginData[][] = new String[totalRows][totalCols];
	        
	        // Read data from Excel and store in array
	        for (int i = 1; i <= totalRows; i++) {   // Row loop
	            for (int j = 0; j < totalCols; j++) { // Column loop
	                loginData[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
	            }
	        }
	        
	        // Returning two-dimensional array
	        return loginData;
	    }
	}



