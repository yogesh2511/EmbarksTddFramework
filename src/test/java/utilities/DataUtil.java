package utilities;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import base.TestBase;

public class DataUtil extends TestBase{
	
	
	@DataProvider(name="dp")
	public Object[][] getData(Method m) {
	
		
		String sheetName = m.getName();
		// excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\main\\resources\\excel\\EmbarkData.xlsx");
		
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
			
		Object[][] data = new Object[rows-1][cols];
	
		
		for(int rowNum=2; rowNum<=rows; rowNum++) {
			
			for(int colNum=0; colNum<cols;colNum++) {
				
				data[rowNum-2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
				
			}
			
		}
		
		
		return data;
		
		
	}
	

}
