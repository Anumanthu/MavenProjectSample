package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestUtil {
	
	

	public static FileInputStream fis1, fis2;

	public static String sheetName = "FIRSTXCELNAME2";

	// See the file exists or not and check properties file

	public static String PropertiesFilePath = ".\\src\\main\\java\\resources\\config.properties";

	static Properties prop1;
	public static String excel_path;

	@Test(dataProvider = "getData")
	public void printuseridpassord(String input1, String input2) {
		// System.out.println(input1+" "+input2+" "+input3+" "+input4);
		// System.out.println(password);
		System.out.println(input1 + " " + input2);
	}

	@DataProvider
	public static Object[][] getData() throws IOException {
		Object ob[][] = getTestData(sheetName);
		return ob;

	}

	public static Object[][] getTestData(String sheetName) throws IOException {

		fis1 = new FileInputStream(PropertiesFilePath);

		prop1 = new Properties();

		prop1.load(fis1);

		excel_path = prop1.getProperty("EXCEL_PATH");
		fis2 = new FileInputStream(excel_path);

		XSSFWorkbook wb = new XSSFWorkbook(fis2);
		XSSFSheet sheet = wb.getSheet(sheetName);
		
		//We can format the cell values using below class
		DataFormatter formatter=new DataFormatter();

		Object[][] ob = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		// System.out.println(sheet.getLastRowNum());
		// System.out.println(sheet.getRow(0).getLastCellNum());

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			System.out.println("");

			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {

				// ob[i][j]=sheet.getRow(i).getCell(j).toString();
				//ob[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				ob[i - 1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));

				System.out.print(ob[i-1][j]+" ");

			}
		}

		return ob;

	}

}
