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
import org.openqa.selenium.support.ui.Sleeper;

public class AuthorizedZoneCheck extends SearchPage{
    public void CheckBody(){
        routeToTheAuth();
        AuthItself();
        PinSetting();
        MainPageAuthorizedZoneCheck();
        DetailingCheck();
        HelpTabCheck();
        ElseTab();
    }

    public SelenideElement closePopUpButton = $(MobileBy.id("kz.telecom.app:id/ic_close"));

    //Проверка на наличие сторисов
    public SelenideElement StoriesCheck = $(MobileBy.id("kz.telecom.app:id/rv_stories"));
    //Проверка на наличие блока TV+
    public SelenideElement TvPlusBlockCheck = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup"));
    //Проверка на наличие блока "Мой Казахтелеком"
    public SelenideElement MyKazakhtelecomCheck = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[2]/android.view.ViewGroup"));
    //Проверка на наличие блока "Пакеты услуг"
    public SelenideElement ServicesAvailableCheck = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[2]/android.view.ViewGroup"));
    //Проверка на наличие блока "Доп. услуги"
    public SelenideElement AdditionalServicesBlockCheck = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[2]/android.view.ViewGroup"));
    //Переход на страницу детализации
    public SelenideElement DetailingButton = $(MobileBy.xpath("//android.widget.FrameLayout[@content-desc=\"Детализация\"]/android.widget.ImageView"));
    //Закрытие раздела детализации
    public SelenideElement AuthPhoneFieldClose = $(MobileBy.id("kz.telecom.app:id/btn_close"));
    //Переход на страницу Помощь
    public SelenideElement HelpTransitionTab = $(MobileBy.id("kz.telecom.app:id/faq_navigation"));
    //Переход на страницу FAQ
    public SelenideElement FAQ = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]"));
    //Проверка загаловка FAQ из раздела "Помощь"
    public SelenideElement FAQCheckFromHelpTab = $(MobileBy.id("kz.telecom.app:id/title"));
    //Нажатие на кнопку "Назад" с UI
    public SelenideElement BackButton = $(MobileBy.id("kz.telecom.app:id/ic_back"));
    //Проверка кнопки "Создать обращение"
    public SelenideElement CreateAppealButtonFromHelpTab = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]"));
    //Проверка кнопки "Связаться с нами"
    public SelenideElement ContactUsButton = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]"));
    //Проверка кнопки "Адреса отделений"
    public SelenideElement BranchAddresses = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]"));
    //Нажатие кнопки "No thanks"
    public SelenideElement NoThanksButton = $(MobileBy.id("android:id/button2"));
    //Переход на раздел "Еще"
    public SelenideElement ElseButton = $(MobileBy.id("kz.telecom.app:id/profile_navigation"));
    //Модуль "Настройки приложения"
    public SelenideElement AppSettingsModule = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]"));
    //Модуль "Ваши услуги и заказы"
    public SelenideElement YourServicesAndOrders = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]"));
    //Модуль "Управление счетами и платежи"
    public SelenideElement ControllingBillsAndPayments = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]"));
    //Модуль "Ваш Казахтелеком"
    public SelenideElement YourKazakhtelecom = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]"));
    //Проверка отсутствия кнопки выхода из аккаунта
    public SelenideElement LogOutFromAccount = $(MobileBy.id("kz.telecom.app:id/btn"));
    public SelenideElement LogOutAgree = $(MobileBy.id("kz.telecom.app:id/btn_main"));

    //Локаторы для авторизации:
    public SelenideElement LoginButtonMainPage = $(MobileBy.id("kz.telecom.app:id/tv_login"));
    public SelenideElement PhoneField = $(MobileBy.id("kz.telecom.app:id/et_phone_number"));
    public SelenideElement ContinueButtonAuth = $(MobileBy.className("android.widget.TextView"));
    public SelenideElement PasswordField = $(MobileBy.id("kz.telecom.app:id/et_password"));
    public SelenideElement FinalLogInButton = $(MobileBy.xpath("/hierarchy/android.w" +
            "idget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout[2]/android.view.ViewGroup/android.widget.LinearLayout"));
    public SelenideElement Button1ForPinCode = $(MobileBy.id("kz.telecom.app:id/pinDigit1"));
    public SelenideElement PayButtonAccessible = $(MobileBy.className("android.widget.TextView"));
    public SelenideElement ElseButtonMainMenu = $(MobileBy.xpath("//android.widget.FrameLayout[@content-desc=\"Еще\"]/android.widget.ImageView"));
    public SelenideElement BillsAndPaymentsButton = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup"));

    //Проверка наличия лицевого счета
    public SelenideElement LSCheck = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView"));
    public SelenideElement PayButton = $(MobileBy.id("kz.telecom.app:id/linearLayout"));
    //Проверка текста "Мои обращения"
    public SelenideElement MyAppeals = $(MobileBy.id("kz.telecom.app:id/tvTitle"));
    //Нажатие на кнопку "Назад" из раздела "Мои обращения"
    public SelenideElement BackButtonAppeals = $(MobileBy.id("kz.telecom.app:id/ic_avatar"));

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

    @Step("Проверка главной страницы")
    public void MainPageAuthorizedZoneCheck() {
//        StoriesCheck.shouldBe(Condition.visible);
//        TvPlusBlockCheck.shouldBe(Condition.visible);
        MyKazakhtelecomCheck.shouldBe(Condition.visible);
//        androidScrollToAnElementByText("Мой Казахтелеком");
        ServicesAvailableCheck.shouldBe(Condition.visible);
        AdditionalServicesBlockCheck.shouldBe(Condition.visible);
        LSCheck.shouldBe(Condition.visible);
        PayButton.shouldBe(Condition.visible);
    }

    @Step("Проверка раздела 'Детализация'")
    public void DetailingCheck(){
        DetailingButton.click();
        AuthPhoneFieldClose.click();
//        AuthPhoneFieldClose.click();
        DetailingButton.click();
//        BillsAndPaymentsButton.shouldBe(Condition.visible);
    }

    @Step("Проверка раздела 'Помощь'")
    public void HelpTabCheck(){
        //Проверка FAQ
        HelpTransitionTab.click();
        FAQ.click();
        FAQCheckFromHelpTab.shouldBe(Condition.visible);
        BackButton.click();

        //Проверка кнопки "Создать обращение"
        CreateAppealButtonFromHelpTab.click();
//        AuthPhoneFieldClose.click();
        MyAppeals.shouldBe(Condition.visible);
        BackButtonAppeals.click();

        //Проверка кнопки "Связаться с нами"
        ContactUsButton.click();
        BackButton.click();


        //Проверка кнопки "Адреса отделений"
        BranchAddresses.click();
        NoThanksButton.click();
        BackButton.click();
        sleep(2000);
    }

    @Step("Проверка раздела 'Еще'")
    public void ElseTab(){
        ElseButton.click();
        AppSettingsModule.shouldBe(Condition.visible);
        YourServicesAndOrders.shouldBe(Condition.visible);
        ControllingBillsAndPayments.shouldBe(Condition.visible);
        YourKazakhtelecom.shouldBe(Condition.visible);
        androidScrollToAnElementByText("Выйти из аккаунта");
        LogOutAgree.shouldBe(Condition.visible);
//        LogOutFromAccount.shouldBe(Condition.visible);
    }


}