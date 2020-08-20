package commons;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextUtils {

    public static String getCode(String[] args) {

        BufferedReader br = null;
        StringBuffer strBuffer = new StringBuffer();
        String sCurrentLine = "";

        try {

            br = new BufferedReader(new FileReader("D:\\Selenium Webdriver Softwares and Projects\\Softwares\\eclipse-java-2020-06-R-win32-x86_64\\workspace\\sopetgasone\\testcases\\testdata\\xuathang.txt"));

            while ((sCurrentLine = br.readLine()) != null) {
                strBuffer.append(sCurrentLine);
                System.out.println(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return strBuffer.toString();
    }
}