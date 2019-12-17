import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertTrue;

public class OstrovokTests {

    private static final int WAIT_SECONDS_TO_LOAD = 150;

    private WebDriver driver;

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ostrovok.ru/");
        driver.manage().timeouts().pageLoadTimeout(100, SECONDS);
    }

    @After
    public void after() {
        driver.quit();
    }

    @Test
    public void FindHotels() throws InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Город, отель или аэропорт']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Город, отель или аэропорт']")).sendKeys("Минск, Беларусь");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Город, отель или аэропорт']")).sendKeys(Keys.ENTER);


        new WebDriverWait(driver, WAIT_SECONDS_TO_LOAD).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='SearchForm__Control-sc-13bzgsj-1 SearchForm__DatesWrapper-sc-13bzgsj-3 gXBxpl']//label[1]//div[2]//div[1]")));
        driver.findElement(By.xpath("//div[@class='SearchForm__Control-sc-13bzgsj-1 SearchForm__DatesWrapper-sc-13bzgsj-3 gXBxpl']//label[1]//div[2]//div[1]")).click();

        new WebDriverWait(driver, WAIT_SECONDS_TO_LOAD).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='Datepicker__PopupStyled-afrdxx-2 dnUpUf Popup__Wrapper-irmytn-0 bcTnRF']//div[@class='Grid__Wrapper-sc-1ar1yhn-0 dKhxti']//div[2]//div[2]//div[5]//div[1]")));
        driver.findElement(By.xpath("//div[@class='Datepicker__PopupStyled-afrdxx-2 dnUpUf Popup__Wrapper-irmytn-0 bcTnRF']//div[@class='Grid__Wrapper-sc-1ar1yhn-0 dKhxti']//div[2]//div[2]//div[5]//div[1]")).click();


        new WebDriverWait(driver, WAIT_SECONDS_TO_LOAD).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='Datepicker__PopupStyled-afrdxx-2 dnUpUf Popup__Wrapper-irmytn-0 bcTnRF']//div[@class='Grid__Wrapper-sc-1ar1yhn-0 dKhxti']//div[2]//div[2]//div[7]//div[1]")));
        driver.findElement(By.xpath("//div[@class='Datepicker__PopupStyled-afrdxx-2 dnUpUf Popup__Wrapper-irmytn-0 bcTnRF']//div[@class='Grid__Wrapper-sc-1ar1yhn-0 dKhxti']//div[2]//div[2]//div[7]//div[1]")).click();

        //Выбираем кол-во номеров и кол-во взрослых и детей
        new WebDriverWait(driver, WAIT_SECONDS_TO_LOAD).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='SearchForm__Control-sc-13bzgsj-1 SearchForm__GuestsWrapper-sc-13bzgsj-4 kfoogV']//div//label[@class='Input__Wrapper-sc-9pyubk-2 jEVzai']")));
        driver.findElement(By.xpath("//div[@class='SearchForm__Control-sc-13bzgsj-1 SearchForm__GuestsWrapper-sc-13bzgsj-4 kfoogV']//div//label[@class='Input__Wrapper-sc-9pyubk-2 jEVzai']")).click();

        new WebDriverWait(driver, WAIT_SECONDS_TO_LOAD).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='Room__RightColumn-joun6w-2 dkzzjw']//div[2]//div[2]//button[2]")));
        driver.findElement(By.xpath("//div[@class='Room__RightColumn-joun6w-2 dkzzjw']//div[2]//div[2]//button[2]")).click();

        new WebDriverWait(driver, WAIT_SECONDS_TO_LOAD).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='Button-sc-1tu32ka-0 Form__ButtonWithMargin-sc-1d6sdb8-3 hEztQC']")));
        driver.findElement(By.xpath("//button[@class='Button-sc-1tu32ka-0 Form__ButtonWithMargin-sc-1d6sdb8-3 hEztQC']")).click();
        Thread.sleep(2000);
        //Убираем галку
        driver.findElement(By.xpath("//div[@class='Default__FakeCheckbox-uvzlm0-2 dLiitf']")).click();

        //Submit
        driver.findElement(By.xpath("//button[@class='Button-sc-1tu32ka-0 fxaIma']")).click();//submit

        new WebDriverWait(driver, WAIT_SECONDS_TO_LOAD).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='zen-hotels-list-wrapper']//div[3]//div[1]//div[1]//div[5]//div[1]//a[1]")));
        Assert.assertTrue(driver.findElements(By.xpath("//div[@class='zen-hotels-list-wrapper']//div[3]//div[1]//div[1]//div[5]//div[1]//a[1]")).size() > 0);
    }

    @Test
    public void OneHotelRoomForTenGuests() throws InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Город, отель или аэропорт']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Город, отель или аэропорт']")).sendKeys("Москва, Россия");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='Город, отель или аэропорт']")).sendKeys(Keys.ENTER);


        new WebDriverWait(driver, WAIT_SECONDS_TO_LOAD).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='SearchForm__Control-sc-13bzgsj-1 SearchForm__DatesWrapper-sc-13bzgsj-3 gXBxpl']//label[1]//div[2]//div[1]")));
        driver.findElement(By.xpath("//div[@class='SearchForm__Control-sc-13bzgsj-1 SearchForm__DatesWrapper-sc-13bzgsj-3 gXBxpl']//label[1]//div[2]//div[1]")).click();

        new WebDriverWait(driver, WAIT_SECONDS_TO_LOAD).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='Datepicker__PopupStyled-afrdxx-2 dnUpUf Popup__Wrapper-irmytn-0 bcTnRF']//div[@class='Grid__Wrapper-sc-1ar1yhn-0 dKhxti']//div[2]//div[2]//div[5]//div[1]")));
        driver.findElement(By.xpath("//div[@class='Datepicker__PopupStyled-afrdxx-2 dnUpUf Popup__Wrapper-irmytn-0 bcTnRF']//div[@class='Grid__Wrapper-sc-1ar1yhn-0 dKhxti']//div[2]//div[2]//div[5]//div[1]")).click();


        new WebDriverWait(driver, WAIT_SECONDS_TO_LOAD).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='Datepicker__PopupStyled-afrdxx-2 dnUpUf Popup__Wrapper-irmytn-0 bcTnRF']//div[@class='Grid__Wrapper-sc-1ar1yhn-0 dKhxti']//div[2]//div[2]//div[7]//div[1]")));
        driver.findElement(By.xpath("//div[@class='Datepicker__PopupStyled-afrdxx-2 dnUpUf Popup__Wrapper-irmytn-0 bcTnRF']//div[@class='Grid__Wrapper-sc-1ar1yhn-0 dKhxti']//div[2]//div[2]//div[7]//div[1]")).click();

        //Выбираем кол-во номеров и кол-во взрослых и детей
        new WebDriverWait(driver, WAIT_SECONDS_TO_LOAD).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='SearchForm__Control-sc-13bzgsj-1 SearchForm__GuestsWrapper-sc-13bzgsj-4 kfoogV']//div//label[@class='Input__Wrapper-sc-9pyubk-2 jEVzai']")));
        driver.findElement(By.xpath("//div[@class='SearchForm__Control-sc-13bzgsj-1 SearchForm__GuestsWrapper-sc-13bzgsj-4 kfoogV']//div//label[@class='Input__Wrapper-sc-9pyubk-2 jEVzai']")).click();

        for (int i = 1; i < 5; i++) {
            new WebDriverWait(driver, WAIT_SECONDS_TO_LOAD).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='Room__Line-joun6w-5 fbEStp']//div[1]//div[2]//button[2]")));
            driver.findElement(By.xpath("//div[@class='Room__Line-joun6w-5 fbEStp']//div[1]//div[2]//button[2]")).click();
        }

        for (int j = 1; j <5; j++) {
            new WebDriverWait(driver, WAIT_SECONDS_TO_LOAD).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='Room__RightColumn-joun6w-2 dkzzjw']//div[2]//div[2]//button[2]")));
            driver.findElement(By.xpath("//div[@class='Room__RightColumn-joun6w-2 dkzzjw']//div[2]//div[2]//button[2]")).click();
        }

        new WebDriverWait(driver, WAIT_SECONDS_TO_LOAD).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='Button-sc-1tu32ka-0 Form__ButtonWithMargin-sc-1d6sdb8-3 hEztQC']")));
        driver.findElement(By.xpath("//button[@class='Button-sc-1tu32ka-0 Form__ButtonWithMargin-sc-1d6sdb8-3 hEztQC']")).click();

        //Убираем галку
        driver.findElement(By.xpath("//div[@class='Default__FakeCheckbox-uvzlm0-2 dLiitf']")).click();
        Thread.sleep(1000);
        //Отдых
        driver.findElement(By.xpath("//div[@class='B2CExtra__TripTypeWrapper-sc-6f9jqd-1 bWSRSj']//label[1]//div[1]")).click();
        Thread.sleep(1000);
        //Submit
        driver.findElement(By.xpath("//button[@class='Button-sc-1tu32ka-0 fxaIma']")).click();//submit

        new WebDriverWait(driver, WAIT_SECONDS_TO_LOAD).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='emptyserp-title']")));
        Assert.assertTrue(driver.findElements(By.xpath("//div[@class='emptyserp-title']")).size() > 0);
    }

}

