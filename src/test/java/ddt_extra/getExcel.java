package ddt_extra;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class getExcel {
	public static void main(String[] args) throws IOException, FileNotFoundException {

		FileInputStream fis = new FileInputStream("./src/test/resources/testScriptData.xlsx");

		// Get the Access of Workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		// Get access of Sheet
		Sheet sheet = wb.getSheet("testdata");
		
		// Get access of Row
		Row row = sheet.getRow(2);
		
		// Get access of Cell
		Cell cell = row.getCell(8);

		// Get the data
		String data = cell.getStringCellValue();

		System.out.println(data);

		// To close the workbook
		wb.close();

	}
}