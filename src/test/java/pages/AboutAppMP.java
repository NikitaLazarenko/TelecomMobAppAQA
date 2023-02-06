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

import com.codeborne.selenide.conditions.Visible;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;

public class AboutAppMP extends SearchPage {
    public void CheckBody() {
        routeToTheAuth();
        AboutApp();
        AuthItself();
        PinSetting();
        AboutApp();
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
    public SelenideElement MyServicesButton = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]"));
    public SelenideElement ContractTerms = $(MobileBy.id("kz.telecom.app:id/tv_contract_terms"));
    public SelenideElement AdditionalServices = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[2]/android.view.ViewGroup"));
    public SelenideElement Leasing = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[2]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.widget.LinearLayout"));
    //Переход на раздел "Еще"
    public SelenideElement ElseButton = $(MobileBy.id("kz.telecom.app:id/profile_navigation"));
    public SelenideElement AboutAppB = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]"));
    public SelenideElement AppVersion = $(MobileBy.id("kz.telecom.app:id/main_ll"));
    public SelenideElement VersionItself = $(MobileBy.id("kz.telecom.app:id/name_tv"));
    public SelenideElement Date = $(MobileBy.id("kz.telecom.app:id/create_date_tv"));
    public SelenideElement Description = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.TextView"));

    @Step("Переход на главную страницу")
    public void routeToTheAuth() {
        closePopUpButton.click();
        sleep(1000);
    }

    @Step("Переход в раздел 'О приложении'")
    public void AboutApp() {
        ElseButton.click();
        AboutAppB.click();
        AppVersion.click();
        VersionItself.shouldBe(Condition.visible);
        Date.shouldBe(Condition.visible);
        Description.shouldBe(Condition.visible);
        goBack();
        goBack();
    }


    @Step("Авторизация")
    public void AuthItself() {
        LoginButtonMainPage.click();
        sleep(1000);
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

}