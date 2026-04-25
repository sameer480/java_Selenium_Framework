package utils;

import base.DriverManager;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static String capture(String testName) {

        try {
            WebDriver driver = DriverManager.getDriver();
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                    .format(new Date());

            String fileName = testName + "_" + timeStamp + ".png";
            String path = "screenshots/" + fileName;

            File src = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            Files.copy(src.toPath(), Paths.get(path));

            return path;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}