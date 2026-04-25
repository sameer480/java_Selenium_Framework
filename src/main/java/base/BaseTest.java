package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;

public class BaseTest {

        @BeforeMethod
        public void setUp() {
            new File("reports").mkdirs();
            new File("screenshots").mkdirs();
            new File("logs").mkdirs();

            DriverManager.initDriver();

            DriverManager.getDriver().get("https://example.com");
        }

        @AfterMethod
        public void tearDown() {
            DriverManager.quitDriver();
        }
    }


