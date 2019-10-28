package util;

import java.io.*;

public class Reader {

    private String filename;
    BufferedReader bufferedReader;

    public Reader(String filename) throws FileNotFoundException {
        File file = new File(filename);
        bufferedReader = new BufferedReader(new FileReader(file));
    }

    public String readAccountLine() throws IOException {
        String str;
        str = bufferedReader.readLine();
        if (str!=null){
            return str;
        } else {
            return "";
        }
    }
}
