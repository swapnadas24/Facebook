package com.facebook.web.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import com.facebook.web.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookWebbase {

    protected static WebDriver driver;
    static SafariOptions option;
    protected static Properties props;
    static FileInputStream objfile;

    public FacebookWebbase() {

        try {
            // Load the properties File
            props = new Properties();
            FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")
                    + "/src/main/java/com/facebook/web/config/facebookconfig.properties");
            props.load(objfile);

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    public static void initialization() {

        String browserName = props.getProperty("browser");

        if (browserName.equals("safari"))

            WebDriverManager.safaridriver().setup();
        option = new SafariOptions();
        driver = new SafariDriver(option);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.durationSecond));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(TestUtil.durationMilliSeconds));

        driver.get(props.getProperty("facebookURL"));

    }
}
