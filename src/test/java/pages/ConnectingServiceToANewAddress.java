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

public class ConnectingServiceToANewAddress{
    public void CheckBody() {
        routeToTheAuth();
        AuthItself();
        PinSetting();
        CustomerDataFilling();
        TechCheck();
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
    public SelenideElement AstanaChoose = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.view.ViewGroup[4]/android.widget.TextView"));
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
    //Кнопка продолжить (новый адрес)
    public SelenideElement ContinueNewAddress = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.Button"));
    //Имеется техническая возможность
    public SelenideElement TechnicalCheckSuccess = $(MobileBy.id("kz.telecom.app:id/tv_title"));
    //Техническая возможность. Продолжить
    public SelenideElement TechnicalContinue = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.cardview.widget.CardView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.Button"));
    //Sim1
    public SelenideElement SIM1 = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.FrameLayout/androidx.cardview.widget.CardView/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]"));

    //Container
    public SelenideElement ContainerVisible = $(MobileBy.id("kz.telecom.app:id/container_options"));
    //ContractTime
    public SelenideElement ContractTime = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView"));
    //NoCOntract
    public SelenideElement NoContract = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.FrameLayout/androidx.cardview.widget.CardView/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]"));
    //Подтверждение личности
    public SelenideElement ConfirmYourPersonality = $(MobileBy.id("kz.telecom.app:id/tv_title"));

    //Локаторы к каждому элементу для авторизации:
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
        PhoneField.sendKeys("7083926627");
        ContinueButtonAuth.click();
        PasswordField.click();
//        sleep(1000);
        PasswordField.sendKeys("Test9828010");
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

    @Step("Выбор услуги и заполнение пользовательских данных")
    public void CustomerDataFilling() {
        androidScrollToAnElementByText("Все пакеты услуг");
//        ChooseYourService.click();
        BereketAccessible.shouldBe(Condition.visible);
        KeremetMobile.shouldBe(Condition.visible);
        androidScrollToAnElementByText("Подключить от 8999 ₸/мес.");
        ContinueNewAddress.click();
//        BereketConnectButton.click();
//        ContinueButton.click();
//        MobPhoneField.sendKeys("7751494255");
        CitiesList.click();
        AstanaChoose.click();
        StreetChoose.click();
        TypeAnything.sendKeys("Навои Алишера");
        sleep(2000);
        HouseNumber.click();
        Confirm.click();

        HouseChoose.click();
        TypeAnything.sendKeys("324");
        HouseNumber.click();
        Confirm.click();
        ContinueButton.click();
    }

    @Step("Проверка технической возможности и возможности сканирования документов")
    public void TechCheck(){
        TechnicalCheckSuccess.shouldBe(Condition.visible);
        TechnicalContinue.click();
        SIM1.click();
        ContainerVisible.shouldBe(Condition.visible);
        ContinueButton.click();
        ContractTime.shouldBe(Condition.visible);
        NoContract.click();
        ContinueButton.click();

        ConfirmYourPersonality.shouldBe(Condition.visible);


//        BlockHouse.click();
//        TypeAnything.sendKeys("1");
//        HouseNumber.click();
//        Confirm.click();
    }

//    @Step("Запрос СМС")
//    public void SMSRequest(){
//        ContinueButton.click();
//        SMSCodeOnboarding.shouldBe(Condition.visible);
//    }
}