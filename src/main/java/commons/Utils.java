package commons;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import static commons.BaseWeb.driver;

public class Utils {
     public static void uploadFile(String path){

        try {
            Robot robot = new Robot();  // Robot class throws AWT Exception

            StringSelection filePath = new StringSelection(path);

            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

            robot.keyPress(KeyEvent.VK_CONTROL);
            Thread.sleep(1000);

            robot.keyPress(KeyEvent.VK_V);
            Thread.sleep(1000);

            robot.keyRelease(KeyEvent.VK_V);


            robot.keyRelease(KeyEvent.VK_CONTROL);

            robot.keyPress(KeyEvent.VK_ENTER);

            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(5000);



        } catch (InterruptedException | AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public static void screensot(String fileName){
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("./target/screenshots/"+fileName+".jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
