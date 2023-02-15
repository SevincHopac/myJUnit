package day13;
import org.apache.poi.ss.usermodel.*;   // microsoft dosylari ile iletisime gecmek icin
import org.junit.Assert;
import org.junit.Test;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class _01_ExelRead {

    @Test
    public void readExelTest() throws Exception {

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

        //ilk elemani cek
        Cell cell1 = row1.getCell(0);

        //print
        System.out.println(cell1);


        System.out.println("------------------");
        // 1.row 2.column
        Cell cell12 = sheet1.getRow(0).getCell(2);
        System.out.println(cell12);

        //3.r 1.c  ve verify 'France'
        String  cell31 = sheet1.getRow(2).getCell(0).toString();
        System.out.println(cell31);

        Assert.assertEquals("France",cell31);
        System.out.println("------------------");


        // toplam exeldeki satir sayisi
        int totolRow = sheet1.getLastRowNum()+1;  // index num veriyor
        System.out.println(totolRow);

        // kullanilan toplam row say
        int kultoprow = sheet1.getPhysicalNumberOfRows(); // 1 den basliyor
        System.out.println(kultoprow);

//        COUNTRY, CAPITALS key ve value lari map a alip print et
//        {{USA, D.C},{FRANCE, PARIS},...}


        Map<String,String> ulkeBaskentleri = new HashMap<>();

        for (int row =1 ; row < totolRow ; row++) {

            String country = sheet1.getRow(row).getCell(0).toString();

            String capital = sheet1.getRow(row).getCell(1).toString();

            ulkeBaskentleri.put(country,capital);
        }

        System.out.println(ulkeBaskentleri);
    }
}
