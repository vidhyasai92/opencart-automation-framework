package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {

    public static WebDriver driver;
    public Logger logger;
    public Properties p;

    @BeforeClass(groups={"Sanity","Regression","Master"})
    @Parameters({"os","browser"})
    public void setup(@Optional("mac") String os,
                      @Optional("chrome") String br) throws IOException {

        
        p = new Properties();
        try (FileReader file = new FileReader("./src/test/resources/config.properties")) {
            p.load(file);
        } catch (IOException e) {
            
            System.out.println("Config not loaded: " + e.getMessage());
        }

        logger = LogManager.getLogger(this.getClass());
        System.out.println("Browser=" + br + ", OS=" + os);
        
        if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
        {
        	DesiredCapabilities capabilities=new DesiredCapabilities();
        	
        	if(os.equalsIgnoreCase("mac"))
        	{
        		capabilities.setPlatform(Platform.MAC);
        	}
        	else if(os.equalsIgnoreCase("linux"))
        	{
        		capabilities.setPlatform(Platform.LINUX);
        	}
        	else if(os.equalsIgnoreCase("windows"))
        	{
        		capabilities.setPlatform(Platform.WIN11);
        	}
        	else
        	{
        		System.out.println("No matcing os");
        		return;
        	}
        	
        	switch(br.toLowerCase())
        	{
        	case "chrome":capabilities.setBrowserName("chrome");break;
        	case "edge":capabilities.setBrowserName("MicrosoftEdge");break;
        	case "firefox":capabilities.setBrowserName("firefox");break;
        	
        	default:System.out.println("No matching browser"); return;
        	}
        	
        	driver=new RemoteWebDriver(new URL(" http://192.168.1.36:4444/wd/hub"),capabilities);
        	
        	}
        
        if(p.getProperty("execution_env").equalsIgnoreCase("local"))
        {
        	 switch (br.toLowerCase().trim()) {
             case "chrome":  driver = new ChromeDriver();  break;
             case "firefox": driver = new FirefoxDriver(); break;
             case "safari":  driver = new SafariDriver();  break;
             default: throw new SkipException("Invalid browser: " + br);
         }
        }

     /*   try {
            switch (br.toLowerCase().trim()) {
                case "chrome":  driver = new ChromeDriver();  break;
                case "firefox": driver = new FirefoxDriver(); break;
                case "safari":  driver = new SafariDriver();  break;
                default: throw new SkipException("Invalid browser: " + br);
            }
        } catch (Exception e) {
            // makes TestNG show the real reason if a browser cannot start
            e.printStackTrace();
            throw new SkipException("Browser startup failed: " + e.getMessage(), e);
        } */

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://tutorialsninja.com/demo/");

        if (br.equalsIgnoreCase("safari")) {
            driver.manage().window().setSize(new org.openqa.selenium.Dimension(1400, 900));
        } else {
            driver.manage().window().maximize();
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    public String randomString() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String randomNumber() {
        return RandomStringUtils.randomNumeric(10);
    }

    public String randomAlphaNumeric() {
        return RandomStringUtils.randomAlphanumeric(10);
    }
    public String captureScreen(String tname) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        // Destination path inside the "screenshots" folder (outside src)
        String targetFilePath = System.getProperty("user.dir") + "/screenshots/" + tname + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);

        // Create directory if it doesn’t exist
        targetFile.getParentFile().mkdirs();

        // Copy screenshot to target file
        FileUtils.copyFile(sourceFile, targetFile);

        return targetFilePath;
    }
}



