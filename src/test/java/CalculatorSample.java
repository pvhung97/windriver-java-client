import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import io.kanthis.WinDriver;
import io.kanthis.WinDriverOptions;
import io.kanthis.pattern.BasePattern;
import io.kanthis.pattern.WindowPattern;

public class CalculatorSample {
    public static void main(String[] args) throws Exception {
        WinDriverOptions cap = new WinDriverOptions().setAumid("Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
        RemoteWebDriver driver = new WinDriver(new URL("http://localhost:5000"), cap);

        try {
            RemoteWebElement topWindow = (RemoteWebElement) driver.findElement(By.xpath("/Window"));
            BasePattern bp = new BasePattern(topWindow, driver);
            System.out.println(bp.getControllerFor().size());
            System.out.println(bp.getDescribedBy().size());
            System.out.println(bp.getFlowsTo().size());
            WindowPattern pattern = new WindowPattern(topWindow, driver);
            System.out.println(pattern.getPosition());
            System.out.println(pattern.getSize());
            pattern.bringToTop();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
