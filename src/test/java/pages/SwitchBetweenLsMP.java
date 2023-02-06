package pages;

import static com.codeborne.selenide.Selenide.*;
import static driver.EmulatorHelper.androidScrollToAnElementByText;
import static driver.EmulatorHelper.goBack;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import java.util.List;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;

public class SwitchBetweenLsMP extends SearchPage {
    public void CheckBody() {
        routeToTheAuth();
        AuthItself();
        PinSetting();
        ServiceQualityAppeals();

    }

    //Локаторы к каждому элементу:
    public SelenideElement closePopUpButton = $(MobileBy.id("kz.telecom.app:id/ic_close"));
    public SelenideElement LoginButtonMainPage = $(MobileBy.id("kz.telecom.app:id/tv_login"));
    public SelenideElement PhoneField = $(MobileBy.id("kz.telecom.app:id/et_phone_number"));
    public SelenideElement ContinueButtonAuth = $(MobileBy.className("android.widget.TextView"));
    public SelenideElement PasswordField = $(MobileBy.id("kz.telecom.app:id/et_password"));
    public SelenideElement FinalLogInButton = $(MobileBy.xpath("/hierarchy/android.w" +
            "idget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout[2]/android.view.ViewGroup/android.widget.LinearLayout"));
    public SelenideElement Button1ForPinCode = $(MobileBy.id("kz.telecom.app:id/pinDigit1"));
    public SelenideElement LSChange = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView"));
    public SelenideElement ExactLS = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]"));



    @Step("Переход на страницу авторизации")
    public void routeToTheAuth() {
        closePopUpButton.click();
        sleep(1000);
        LoginButtonMainPage.click();
        sleep(1000);
    }

    @Step("Авторизация")
    public void AuthItself() {
        PhoneField.click();
//        sleep(1000);
        PhoneField.sendKeys("7007144012");
        ContinueButtonAuth.click();
        PasswordField.click();
//        sleep(1000);
        PasswordField.sendKeys("Test4012");
//        sleep(500);
        FinalLogInButton.click();
//        sleep(3000);
    }

    @Step("Ввод пинкода и открытие авторизованной зоны")
    public void PinSetting() {
        Button1ForPinCode.click();
        sleep(500);
        Button1ForPinCode.click();
        sleep(500);
        Button1ForPinCode.click();
        sleep(500);
        Button1ForPinCode.click();
        sleep(1000);

        Button1ForPinCode.click();
        sleep(500);
        Button1ForPinCode.click();
        sleep(500);
        Button1ForPinCode.click();
        sleep(500);
        Button1ForPinCode.click();
        sleep(1000);
    }

    @Step("Переключение между лицевыми счетами")
    public void ServiceQualityAppeals() {
        LSChange.shouldHave(Condition.text("ЛС 10650237"));
        LSChange.click();
        ExactLS.click();
        LSChange.shouldHave(Condition.text("ЛС 10412510"));
    }

}