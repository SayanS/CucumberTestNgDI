package utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.lang.reflect.Field;

import static org.openqa.selenium.OutputType.BYTES;

public class TestListener implements ITestListener {
   private WebDriver driver;

    @Override
    public void onTestStart(ITestResult iTestResult) {}

    @Override
    public void onTestSuccess(ITestResult iTestResult) {}

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Class clazz = iTestResult.getTestClass().getRealClass();
        System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr" + clazz.getName());
        Field field = null;
        try {
            System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr   - " + clazz.getDeclaredField("webDriver"));
            field = clazz.getDeclaredField("webDriver");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        field.setAccessible(true);

        try {
           driver = (WebDriver) field.get(iTestResult.getInstance());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        makeScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {}

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Class clazz = iTestResult.getTestClass().getRealClass();
        System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr" + clazz.getName());
        Field field = null;
        try {
            System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr   - " + clazz.getDeclaredField("webDriver"));
            field = clazz.getDeclaredField("webDriver");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        field.setAccessible(true);

        try {
            driver = (WebDriver) field.get(iTestResult.getInstance());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        makeScreenshot();
    }

    @Override
    public void onStart(ITestContext iTestContext) {}

    @Override
    public void onFinish(ITestContext iTestContext) {}

    @Attachment(value = "Page screenshot11111", type = "image/png")
    private byte[] makeScreenshot() {
        return (((TakesScreenshot) driver).getScreenshotAs(BYTES));
    }



}
