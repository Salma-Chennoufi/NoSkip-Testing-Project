package testBase;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

// Common class required for every test case
public class BaseClass {

    public static WebDriver driver; // Make it a common variable across multiple objects
    public Logger logger;
    public Properties prop;

    @BeforeClass //(groups = {"Sanity", "Master", "Regression", "DataDriven"})
    @Parameters({"os", "browser"})
    public void setUp(String os, String browser) throws IOException {

        // Loading config.properties file
        FileReader file = new FileReader("./src/test/resources/config.properties");
        prop = new Properties();
        prop.load(file);

        logger = LogManager.getLogger(this.getClass());

        if (prop.getProperty("execution_env").equalsIgnoreCase("remote")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            // os
            if (os.equalsIgnoreCase("Windows")) {
                capabilities.setPlatform(Platform.WIN11);
            } else if (os.equalsIgnoreCase("Linux")) {
                capabilities.setPlatform(Platform.LINUX);
            } else {
                System.out.println("No matching os");
                return;
            }
            // browser
            switch (browser) {
                case "chrome": capabilities.setBrowserName("chrome");  break;
                case "firefox": capabilities.setBrowserName("firefox"); break;
                default: System.out.println("No matching browser"); return;
            }
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        }

        if (prop.getProperty("execution_env").equalsIgnoreCase("local")) {

            switch (browser) {
                case "chrome": driver = new ChromeDriver(); break;
                case "firefox": driver = new FirefoxDriver(); break;
                case "edge": driver = new EdgeDriver(); break;
                default: System.out.println("Invalid browser name.");; return;

            }
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(prop.getProperty("appURL")); // reading URL from properties file
        driver.manage().window().maximize();

    }

    @AfterClass //(groups = {"Sanity", "Master", "Regression", "DataDriven"})
    public void tearDown(){
        driver.quit();
    }


    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath = ".\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);

        FileUtils.copyFile(sourceFile, targetFile);

        return targetFilePath;
    }

}
