package utils;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ExcelUtilsClass {

    public static String getCellValue(Row row, Integer colIndex) {
        if (colIndex == null) return ""; // Prevents NullPointerException

        Cell cell = row.getCell(colIndex);
        if (cell == null) return ""; // Handle empty cells

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                return String.valueOf((long) cell.getNumericCellValue()); // Convert numeric to long to avoid decimal
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }

    public static List<UserDataList> readExcel(String filePath, String sheetName) throws IOException {
        List<UserDataList> dataList = new ArrayList<>();

        // Using try-with-resources to automatically close FileInputStream
        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new RuntimeException("Sheet '" + sheetName + "' not found in file: " + filePath);
            }

            Row headerRow = sheet.getRow(0);
            if (headerRow == null) {
                throw new RuntimeException("No header row found in Excel file: " + filePath);
            }

            // **📌 Read Column Headers Dynamically**
            Map<String, Integer> columnMap = new LinkedHashMap<>();
            for (int i = 0; i < headerRow.getPhysicalNumberOfCells(); i++) {
                columnMap.put(headerRow.getCell(i).getStringCellValue().trim(), i);
            }

            // **📌 Read Data Rows Dynamically**
            for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Use `<=` to include last row
                Row row = sheet.getRow(i);
                if (row == null || row.getPhysicalNumberOfCells() < columnMap.size()) {
                    System.out.println("Skipping empty or incomplete row at index: " + i);
                    continue;
                }

                UserDataList udl = new UserDataList();
                udl.setFirstName(getCellValue(row, columnMap.get("FirstName")));
                udl.setLastName(getCellValue(row, columnMap.get("LastName")));
                udl.setAddress(getCellValue(row, columnMap.get("Address")));
                udl.setCity(getCellValue(row, columnMap.get("City")));
                udl.setState(getCellValue(row, columnMap.get("State")));
                udl.setZipCode(getCellValue(row, columnMap.get("ZipCode")));
                udl.setPhone(getCellValue(row, columnMap.get("Phone"))); 
                udl.setSSN(getCellValue(row, columnMap.get("SSN")));
                udl.setUsername(getCellValue(row, columnMap.get("Username")) + new Random().nextInt(1000));
                udl.setPassword(getCellValue(row, columnMap.get("Password")));
                udl.setConfirm(getCellValue(row, columnMap.get("Confirm")));

                dataList.add(udl);
            }

        } catch (IOException e) {
            System.err.println("Error reading Excel file: " + e.getMessage());
            throw e;
        }

        if (dataList.isEmpty()) {
            throw new RuntimeException("No valid user data found in Excel file: " + filePath);
        }

        return dataList;
    }
}
