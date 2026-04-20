package generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileUtility {

	public String getDataFromPropFile(String key) throws IOException, FileNotFoundException {

		// Get the java representation object of the physical file
		FileInputStream fis = new FileInputStream("./src/test/resources/cd.properties");

		// Fetch keys by loading the properties file
		Properties pObj = new Properties();
		pObj.load(fis);

		// Get values by using getProperty method
		String value = pObj.getProperty(key);

		// Close stream to avoid resource leak
		fis.close();

		return value;

	}

	public String getDatafromExcelFile(String sheetName, int rowIndex, int cellIndex) throws EncryptedDocumentException, IOException {

		FileInputStream fis2 = new FileInputStream("./src/test/resources/testScriptData.xlsx");

		Workbook wb = WorkbookFactory.create(fis2);

		// Method Chaining for getExcelData
		String value = wb.getSheet(sheetName).getRow(rowIndex).getCell(cellIndex).getStringCellValue();

		// Close workbook to prevent memory leaks
		wb.close();

		return value;

	}
	
	public void getDatafromJsonFile() throws IOException, ParseException {
		
		FileReader fr = new FileReader("./src/test/resources/cd2.json");

		JSONParser jp = new JSONParser();
		Object obj = jp.parse(fr);

		JSONObject pObj = (JSONObject) obj;
		String browser = pObj.get("bro").toString();
		System.out.println(browser);

	}

}
