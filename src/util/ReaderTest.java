package util;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

public class ReaderTest {
    @Test
    public void testReader() throws FileNotFoundException {
        Reader reader = new Reader("./src/test/AccountList.txt");
    }

    @Test
    public void testReadAccountLine() throws IOException {
        Reader reader = new Reader("./src/test/AccountList.txt");
        String temp = reader.readAccountLine();
        Assert.assertEquals("Current,00001,100,Alice", temp);
        temp = reader.readAccountLine();
        Assert.assertEquals("Current,00002,150,Bob", temp);
        temp = reader.readAccountLine();
        Assert.assertEquals("Current,00003,125,Charles", temp);
    }
}