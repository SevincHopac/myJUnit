package day13;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _02_WriteExel {

    @Test
    public void writeExelTest() throws IOException {

        //  WORKBOOK > WORKSHEET/SHEET (SAYFA) > ROW (SATIR) > CELL (VERI HUCRESI)

        String path = "./src/test/java/resources/Capitals.xlsx";
        //        String path =".\\src\\test\\java\\resources\\Capitals.xlsx";//WINDOWS

        // Dosya AC
        FileInputStream fileInputStream = new FileInputStream(path);

        // Workbook  ac
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // Sayfayi ac / Sheet1
        Sheet sheet1 = workbook.getSheet("Sheet1");
        // Sheet sheet1 = workbook.getSheetAt(0);


        //ilk satira git
        Row row1 = sheet1.getRow(0);

        // 1. row 3. column

        Cell cell13 = row1.createCell(2);

        // o hücreye yaz

        cell13.setCellValue("Population");

        // 2.row 3.column  450000
        sheet1.getRow(1).createCell(2).setCellValue("450000");

        // 3. satir 3. sutuna 350000
        sheet1.getRow(2).createCell(2).setCellValue("350000");

        // save
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);
    }
}
