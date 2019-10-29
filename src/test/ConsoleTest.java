import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.*;

import static org.junit.Assert.*;

public class ConsoleTest {
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
    public void testConsole_Doposit() throws IOException {
        System.out.println("Starting Console.main\n");
        String[] args = null;

        String input = "1\r\n00001\r\n"
                +"1\r\n100\r\n"
                +"3\r\n2\r\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Console.main(args);
        Assert.assertEquals(true, out.toString().contains("$100 had been deposited to your account,"));
        Assert.assertEquals(true, out.toString().contains("Current balance: $200"));

        System.setOut(originalOut);
        System.out.print(out.toString());
        System.out.println("\n\n================================");
        System.out.println("Test for deposit fund completed");
        System.out.println("================================");
    }

    @Test
    public void testConsole_Withdraw() throws IOException {
        System.out.println("Starting Console.main\n");
        String[] args = null;

        String input = "1\r\n00002\r\n"
                +"2\r\n100\r\n"
                +"3\r\n2\r\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Console.main(args);
        Assert.assertEquals(true, out.toString().contains("$100 had been withdrawn from your account,"));
        Assert.assertEquals(true, out.toString().contains("Current balance: $50"));

        System.setOut(originalOut);
        System.out.print(out.toString());
        System.out.println("\n\n================================");
        System.out.println("Test for withdraw fund completed");
        System.out.println("================================");
    }

    @Test
    public void testConsole_Withdraw_Insufficient() throws IOException {
        System.out.println("Starting Console.main\n");
        String[] args = null;

        String input = "1\r\n00002\r\n"
                +"2\r\n150.01\r\n"
                +"2\r\n0.01\r\n"
                +"3\r\n2\r\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Console.main(args);
        Assert.assertEquals(true, out.toString().contains("$150.01 had been withdrawn from your account,"));
        Assert.assertEquals(true, out.toString().contains("Current balance: $-0.01"));
        Assert.assertEquals(true, out.toString().contains("The account has zero or negative balance: -0.01"));

        System.setOut(originalOut);
        System.out.print(out.toString());
        System.out.println("\n\n================================");
        System.out.println("Test for withdraw fund completed");
        System.out.println("================================");
    }
}