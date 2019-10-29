package util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import static org.junit.Assert.*;
import static util.Printer.Print;
import static util.Printer.PrintDepositWithdraw;
import static util.Printer.PrintLine;

public class PrinterTest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }



    @Test
    public void testPrint() {
        Printer printer = new Printer();
        Print("bbb");
        Assert.assertEquals("bbb", out.toString());
    }

    @Test
    public void testPrintLine() {
        PrintLine("aaa");
        String actualOutput = out.toString().replace("\r\n", "").replace("\n","");
        Assert.assertEquals("aaa", actualOutput);
    }

    @Test
    public void testPrintDepositWithdraw_D() {
        PrintDepositWithdraw(0, new BigDecimal(100), new BigDecimal(150));
//        String actualOutput = out.toString().replace("\r\n", "").replace("\n","");
        Assert.assertEquals("$100 had been deposited to your account,\r\nCurrent balance: $150\r\n", out.toString());
    }

    @Test
    public void testPrintDepositWithdraw_W() {
        BigDecimal amt = new BigDecimal("100.1");
        BigDecimal amtafter = new BigDecimal("150.11");
        PrintDepositWithdraw(1, amt, amtafter);
        Assert.assertEquals("$100.1 had been withdrawn from your account,\r\nCurrent balance: $150.11\r\n", out.toString());
    }
}