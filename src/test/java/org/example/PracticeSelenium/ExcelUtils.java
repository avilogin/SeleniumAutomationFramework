package org.example.PracticeSelenium;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtils {

    public static Object[][] getExcelData(String excelPath, String sheetName) {
        Object[][] data = null;

        try {
            FileInputStream fis = new FileInputStream(excelPath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);

            int rows = sheet.getPhysicalNumberOfRows();
            int cols = sheet.getRow(0).getLastCellNum();

            data = new Object[rows - 1][cols];

            for (int i = 1; i < rows; i++) {
                Row row = sheet.getRow(i);

                for (int j = 0; j < cols; j++) {
                    Cell cell = row.getCell(j);

                    if (cell.getCellType() == CellType.STRING)
                        data[i - 1][j] = cell.getStringCellValue();

                    else if (cell.getCellType() == CellType.NUMERIC)
                        data[i - 1][j] = cell.getNumericCellValue();

                    else
                        data[i - 1][j] = "";
                }
            }

            workbook.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}
