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

public class UnauthorizedZoneCheck{
    public void CheckBody(){
        routeToTheAuth();
        MainPageUnauthorizedZoneCheck();
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

    @Step("Переход на страницу авторизации")
    public void routeToTheAuth() {
        closePopUpButton.click();
        sleep(1000);
    }

    @Step("Проверка главной страницы")
    public void MainPageUnauthorizedZoneCheck() {
        StoriesCheck.shouldBe(Condition.visible);
        TvPlusBlockCheck.shouldBe(Condition.visible);
        MyKazakhtelecomCheck.shouldBe(Condition.visible);
//        androidScrollToAnElementByText("Мой Казахтелеком");
        ServicesAvailableCheck.shouldBe(Condition.visible);
        AdditionalServicesBlockCheck.shouldBe(Condition.visible);
    }

    @Step("Проверка раздела 'Детализация'")
    public void DetailingCheck(){
        DetailingButton.click();
        AuthPhoneFieldClose.click();
        AuthPhoneFieldClose.click();
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
        AuthPhoneFieldClose.click();

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
        LogOutAgree.shouldNotBe(Condition.visible);
        LogOutFromAccount.shouldNotBe(Condition.visible);
    }


}