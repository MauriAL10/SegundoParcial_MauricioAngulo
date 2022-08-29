package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverManager {
    private static DriverManager instance;

    public WebDriver driver;

    private DriverManager(){
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        driver = new EdgeDriver(options);
    }
    public static DriverManager getDriver(){
        if(instance==null){
            instance = new DriverManager();
        }
        return instance;
    }
}
