package commons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	
	static Workbook book;
	static Sheet sheet;
	public static String SHEET_PATH = "testcases\\testdata\\TestData.xlsx";
	
		public static Object[][] getTestData(String sheetName){
			
			FileInputStream file = null;
			try {
				file = new FileInputStream(SHEET_PATH);
				
			}catch(FileNotFoundException e) {
				
				e.printStackTrace();
			}
			try {
				book = WorkbookFactory.create(file);
			}
			catch(InvalidFormatException e) {
				
				e.printStackTrace();
			}
			catch(IOException e) {
				e.printStackTrace();
			}	
			sheet = book.getSheet(sheetName);
			
			int count = 0;
			Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()]; 
			
			try {
				//System.out.println(sheet.getLastRowNum());
				for(int i= 0;i<sheet.getLastRowNum();i++) {
					for(int j = 0;j<sheet.getRow(0).getLastCellNum();j++) {
						data[i][j] = sheet.getRow(i+1).getCell(j).toString();
						//System.out.println(data[i][j]);
					}
					count++;
				}
			}catch (Exception e){
				
				Object[][] dataFix = new Object[count][sheet.getRow(0).getLastCellNum()];
				
				for (int i = 0; i < dataFix.length; i++) {
					for (int j = 0; j < dataFix[0].length; j++) {
						dataFix[i][j] = data[i][j];
					}
				}
				
				return dataFix;
			}
			
			return data;
		}
	
}

