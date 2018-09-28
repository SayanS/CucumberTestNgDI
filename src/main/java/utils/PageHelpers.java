package utils;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PageHelpers {
    static WebDriver webDriver;

    public PageHelpers(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public static WebElement findBy(String xpath_css) {
        if (xpath_css.contains("//")) {
            return webDriver
                    .findElement(By.xpath(xpath_css));
        } else {
            return webDriver.findElement(By.cssSelector(xpath_css));
        }
    }

    public static WebElement find(By byXpath) {
        return webDriver.findElement(byXpath);
    }

    public static List<WebElement> findAllBy(String xpath) {
        return webDriver.findElements(By.xpath(xpath));
    }

    public static List<String> getTextValuesFrom(List<WebElement> webElements) {
        List<String> textValues = new ArrayList<>();
        webElements.forEach(webElement -> textValues.add(webElement.getText()));
        return textValues;
    }

    public static List<String> getTextValuesOf(String xpath) {
        List<String> textValues = new ArrayList<>();
        findAllBy(xpath).forEach(webElement -> textValues.add(webElement.getText()));
        return textValues;
    }

    public static String getTextOf(String xpath) {
        return findBy(xpath).getText();
    }

    public static String getTextOf(String xpath, String keyWord) {
        return getTextOf(xpath.replace("$KeyWord", keyWord));
    }

    public static void clickOnByXpathJS(String xpath) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", findBy(xpath));
    }

    public static void scrollIntoView(String xpath, int offset_y) {
        int y = webDriver.findElement(By.xpath(xpath)).getLocation().getY() + offset_y;
        ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, " + y + ")");
    }

    public static void scrollIntoView(String xpath) {
        int y = webDriver.findElement(By.xpath(xpath)).getLocation().getY();
        int x = webDriver.findElement(By.xpath(xpath)).getLocation().getX();
        ((JavascriptExecutor) webDriver)
                .executeScript("window.scrollTo(" + x + "," + y + ")");
    }

    public static WebElement moveTo(String xpath) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(findBy(xpath)).perform();
        return findBy(xpath);
    }

    public static void clickOnByXpath(String xpath) {
        waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)), TimeUnit.SECONDS, 5);
        scrollIntoView(xpath, -100);
        moveTo(xpath);
        waitFor(ExpectedConditions.elementToBeClickable(By.xpath(xpath)), TimeUnit.SECONDS, 3);
        findBy(xpath).click();
    }

    public static  void clickOnByXpath(String xpath, String keyWord) {
        clickOnByXpath(xpath.replace("$KeyWord", keyWord));
    }

    public static <V> V waitFor(Function<? super WebDriver, V> condition, TimeUnit timeUnit, int timeout) {
        try {
            Wait<WebDriver> wait = new FluentWait<>(webDriver).withTimeout(timeout, timeUnit)
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class).
                            pollingEvery(500, TimeUnit.MILLISECONDS);
            return wait.until(condition);
        } catch (TimeoutException e) {
            System.out.println("Element hasn't been found:TIMEOUT EXCEPTION");
            return null;
        }
    }

    public static Boolean waitForTextToBePresentIn(String xpath, String text, Integer seconds) {
        return waitFor(ExpectedConditions.textToBePresentInElementLocated(By.xpath(xpath), text), TimeUnit.SECONDS, seconds);
    }

    public static Boolean waitForVisibilityOfElementLocatedByXpath(String xpath, Integer seconds) {
        waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)), TimeUnit.SECONDS, seconds);
        if (waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)), TimeUnit.SECONDS, seconds) != null) {
            return true;
        }
        return false;
    }

    public static void enterValueIntoField(String xpath, String value) throws InterruptedException {
        waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)), TimeUnit.SECONDS, 5);
        scrollIntoView(xpath);
        waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)), TimeUnit.SECONDS, 5);
        waitFor(ExpectedConditions.elementToBeClickable(By.xpath(xpath)), TimeUnit.SECONDS, 3);
        findBy(xpath).sendKeys(value);
//        Thread.sleep(1000);
    }
}
