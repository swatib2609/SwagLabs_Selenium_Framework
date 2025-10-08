package Utility;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
    public static String getCellValue(String filePath, String sheetName, int row, int col) throws Exception {
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        String data = sheet.getRow(row).getCell(col).getStringCellValue();
        workbook.close();
        fis.close();
        return data;
    }
}
