package com.max;

import com.max.arrays.FinanceReport;
import com.max.arrays.Payment;
import org.max.annotations.Test;

import java.io.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class FinanceReportTest {


    @Test
    public void testNotNull(){
            assertNotNull(new FinanceReport());
        }

    @Test
    public void testFound() throws IOException {
        Payment p[] = new Payment[3];
        p[0] = new Payment("яйцукен",3,3,3,15);
        p[1] = new Payment("гораций",5,3,16,15);
        p[2] = new Payment("альбина",1,1,3,15);

        FinanceReport f = new FinanceReport(p);
        f.found('А');
    }

    @Test
    public void testClone() throws IOException {
        Payment p[] = new Payment[3];
        p[0] = new Payment("яйцукен",3,3,3,15);
        p[1] = new Payment("гораций",5,3,16,15);
        p[2] = new Payment("альбина",1,1,3,15);

        FinanceReport f1 = new FinanceReport(p);
        FinanceReport f2 = new FinanceReport(f1);
        f2.set(0,new Payment());
        assertEquals("яйцукен",f1.get(0).getName());
        assertEquals("",f2.get(0).getName());

    }


    @Test
    public void testFoundLess() throws IOException {
        Payment p[] = new Payment[6];
        p[0] = new Payment("яйцукен",3,3,3,11325);
        p[1] = new Payment("гораций",5,3,16,15);
        p[2] = new Payment("альбина",1,1,3,141215);
        p[3] = new Payment("прометей",12,2,18,512505);
        p[4] = new Payment("спиридон",14,3,5,5);
        p[5] = new Payment("пике",16,12,31,611251205);

        Payment expexted[] = {p[0], p[1], p[4]};
        FinanceReport f = new FinanceReport(p);
        f.foundLess(20000);
    }


    @Test
    public void testSumAll() throws IOException {
        Payment p[] = new Payment[6];
        p[0] = new Payment("яйцукен",3,3,3,155);
        p[1] = new Payment("гораций",3,3,3,223);
        p[2] = new Payment("алькасер",15,1,7,6105);
        p[3] = new Payment("пабло",12,2,18,512505);
        p[4] = new Payment("лео",14,3,5,5);
        p[5] = new Payment("каролина",16,12,31,611251205);

        FinanceReport f  = new FinanceReport(p);


        assertEquals(f.sumDate("3.3.3"),378);
    }

    @Test
    public void testGetMonthsWithOutP() throws IOException {
        Payment p[] = new Payment[6];
        p[0] = new Payment("альбина",5,4,3,155);
        p[1] = new Payment("настя",3,3,3,223);
        p[2] = new Payment("корова",15,1,7,6105);
        p[3] = new Payment("жируха",5,3,18,512505);
        p[4] = new Payment("шина",14,3,5,5);
        p[5] = new Payment("девушка",5,12,31,611251205);

        FinanceReport f  = new FinanceReport(p);

        String s[] = f.getMonthsWithOutP(5);
        String r[] = {"Март","Апрель","Декабрь"};

        assertEquals(s, new String[]{"Март","Апрель","Декабрь"});
        assertEquals(f.getMonthsWithOutP(5)[2],"Декабрь");
    }


    @Test
    public void testInput() throws IOException {
        FinanceReport f  = new FinanceReport();

        FileInputStream fis = new FileInputStream(new File("input.txt"));
        f.read(fis);

        f.write(System.out);
    //  fis.close();
    }

    @Test
    public void testOutput() throws IOException {
        Payment p[] = new Payment[6];
        p[0] = new Payment("рома",5,4,3,155);
        p[1] = new Payment("вика",3,3,3,223);
        p[2] = new Payment("ща",15,1,7,6105);
        p[3] = new Payment("завтра сдам",5,3,18,512505);
        p[4] = new Payment("кент",14,3,5,5);
        p[5] = new Payment("дворник",5,12,31,611251205);

        FinanceReport f  = new FinanceReport(p);

        System.out.println("!!!!!");
        f.write(System.out);
    }


}
