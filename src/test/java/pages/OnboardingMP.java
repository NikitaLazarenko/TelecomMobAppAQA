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

public class OnboardingMP{
    public void CheckBody() {
        OpenApp();
        CustomerDataFilling();
        SMSRequest();
    }

    //Закрытие первого Pop-up
    public SelenideElement closePopUpButton = $(MobileBy.id("kz.telecom.app:id/ic_close"));
    //Все пакеты услуг
    public SelenideElement ChooseYourService = $(MobileBy.id("kz.telecom.app:id/see_all_container"));
    //Bereket
    public SelenideElement BereketAccessible = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout[2]/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup"));
    //Keremet Mobile
    public SelenideElement KeremetMobile = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout[2]/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView/android.view.ViewGroup"));
    //BereketConnectButton
    public SelenideElement BereketConnectButton = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout[2]/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.LinearLayout/android.widget.TextView"));
    //Поля для ввода номера телефона
    public SelenideElement MobPhoneField = $(MobileBy.id("kz.telecom.app:id/et_phone_number"));
    //Список городов
    public SelenideElement CitiesList = $(MobileBy.id("kz.telecom.app:id/spinner"));
    //Астаны (список городов)
    public SelenideElement AstanaChoose = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.view.ViewGroup[1]/android.widget.TextView"));
    //Выбор улицы
    public SelenideElement StreetChoose = $(MobileBy.id("kz.telecom.app:id/tv_address"));
    //Введите название улицы
    public SelenideElement TypeAnything = $(MobileBy.id("kz.telecom.app:id/et_search_query"));
    //Кабанбай батыра
    public SelenideElement Kabanbay = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[2]"));
    //Confirm
    public SelenideElement Confirm = $(MobileBy.id("kz.telecom.app:id/btn"));
    //Введите название дома
    public SelenideElement HouseChoose = $(MobileBy.id("kz.telecom.app:id/tv_house"));
    //48
    public SelenideElement HouseNumber = $(MobileBy.id("kz.telecom.app:id/tv_name"));
    //Дробь дома
    public SelenideElement BlockHouse = $(MobileBy.id("kz.telecom.app:id/tv_block"));
    //Кнопка продолжить
    public SelenideElement ContinueButton = $(MobileBy.id("kz.telecom.app:id/btn_continue"));
    //"Введите короткий номер"
    public SelenideElement SMSCodeOnboarding = $(MobileBy.id("kz.telecom.app:id/text_resend_info"));




    @Step("Переход на страницу авторизации")
    public void OpenApp() {
        closePopUpButton.click();
    }

    @Step("Заполнение данных по номеру телефона и адресу подключения")
    public void CustomerDataFilling() {
        androidScrollToAnElementByText("Все пакеты услуг");
//        ChooseYourService.click();
        BereketAccessible.shouldBe(Condition.visible);
        KeremetMobile.shouldBe(Condition.visible);
        androidScrollToAnElementByText("Подключить от 8999 ₸/мес.");
//        BereketConnectButton.click();
        MobPhoneField.sendKeys("7751494255");
        CitiesList.click();
        AstanaChoose.click();
        StreetChoose.click();
        TypeAnything.sendKeys("Кабанбай Батыра");
        sleep(2000);
        Kabanbay.click();
        Confirm.click();

        HouseChoose.click();
        TypeAnything.sendKeys("48");
        HouseNumber.click();
        Confirm.click();

        BlockHouse.click();
        TypeAnything.sendKeys("1");
        HouseNumber.click();
        Confirm.click();
    }

    @Step("Запрос СМС")
    public void SMSRequest(){
        ContinueButton.click();
        SMSCodeOnboarding.shouldBe(Condition.visible);
    }
}