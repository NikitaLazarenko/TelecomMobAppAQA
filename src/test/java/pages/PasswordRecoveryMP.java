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

public class PasswordRecoveryMP{
    public void CheckBody() {
        routeToTheAuth();
        AuthItself();
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
    public SelenideElement PayButtonAccessible = $(MobileBy.className("android.widget.TextView"));
    public SelenideElement ElseButtonMainMenu = $(MobileBy.xpath("//android.widget.FrameLayout[@content-desc=\"Еще\"]/android.widget.ImageView"));
    public SelenideElement LogOutFromAccount = $(MobileBy.id("kz.telecom.app:id/btn"));
    public SelenideElement LogOutAgree = $(MobileBy.id("kz.telecom.app:id/btn_main"));
    public SelenideElement RestorePasswordButton = $(MobileBy.id("kz.telecom.app:id/tv_restore_password"));
    public SelenideElement RestoryTextInfo = $(MobileBy.id("kz.telecom.app:id/text_resend_info"));

    @Step("Переход на страницу авторизации")
    public void routeToTheAuth() {
        closePopUpButton.click();
//        sleep(1000);
        LoginButtonMainPage.click();
//        sleep(1000);
    }

    @Step("Восстановление пароля")
    public void AuthItself() {
        PhoneField.click();
//        sleep(1000);
        PhoneField.sendKeys("7784673885");
        ContinueButtonAuth.click();
        sleep(3000);
        RestorePasswordButton.click();
        sleep(1000);
        RestoryTextInfo.shouldBe(Condition.visible);
    }
}