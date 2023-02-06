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

public class PaymentMP extends SearchPage {
    public void CheckBody() {
        routeToTheAuth();
        AuthItself();
        PinSetting();
        TransitionToKTPAY();
//        PaymentItself();
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
    public SelenideElement PayButton = $(MobileBy.id("kz.telecom.app:id/linearLayout"));
    public SelenideElement ContinuePayment = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout"));
    public SelenideElement PaymentField = $(MobileBy.id("kz.telecom.app:id/text_money"));
    public SelenideElement PayYourOrderTitle = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]"));
    public SelenideElement CardNum = $(MobileBy.id("card_no_bin"));
    public SelenideElement ExpMouth = $(MobileBy.id("exp_month"));
    public SelenideElement ExpYear = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.widget.EditText[3]"));
    public SelenideElement CVC = $(MobileBy.id("sec_cvv2"));
    public SelenideElement CardName = $(MobileBy.id("card_name"));
    public SelenideElement ErrorPayment = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]"));
    public SelenideElement WebViewVisible = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]"));
    public SelenideElement TitleVisible = $(MobileBy.xpath("kz.telecom.app:id/title"));








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
        PhoneField.sendKeys("7470370275");
        ContinueButtonAuth.click();
        PasswordField.click();
//        sleep(1000);
        PasswordField.sendKeys("Test176063");
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

        PayButtonAccessible.shouldBe(Condition.visible);
    }

    @Step("Открытие окна KTPay")
    public void TransitionToKTPAY() {
        PayButton.click();
        PaymentField.sendKeys("100");
        ContinuePayment.click();
        WebViewVisible.shouldBe(Condition.visible);
//        TitleVisible.shouldBe(Condition.visible);
    }

//    @Step("Оплата")
//    public void PaymentItself(){
//        PayYourOrderTitle.shouldBe(Condition.visible);
//        CardNum.sendKeys("1111111111111111");
//        ExpMouth.sendKeys("11");
//        ExpYear.sendKeys("11");
//        CVC.sendKeys("123");
//        CardName.sendKeys("Testing Test");
//        androidScrollToAnElementByText("Оплатить");
//        ErrorPayment.shouldBe(Condition.visible);
//    }
}