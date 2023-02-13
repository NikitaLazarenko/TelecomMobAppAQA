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

public class CreatingAppealsMP{
    public void CheckBody() {
        routeToTheAuth();
        AuthItself();
        PinSetting();
        ServiceQualityAppeals();
//        ChargesQuestions();
        CommunicationServiceQuality();
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
    public SelenideElement LSChange = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView"));
    public SelenideElement ExactLS = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]"));
    public SelenideElement MyServicesButton = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]"));
    public SelenideElement AppealsModule = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]"));
    public SelenideElement CreateAppeal = $(MobileBy.id("kz.telecom.app:id/btn_create_appeal"));
    public SelenideElement ServiceQuality = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]"));
    public SelenideElement FieldOfAppeal = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.EditText"));
    public SelenideElement SendItOut = $(MobileBy.id("kz.telecom.app:id/btn"));
    public SelenideElement NextUpAppeal = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.Button"));
    public SelenideElement ChargesQuestionsButton = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]"));
    public SelenideElement CommunicationServiceButton = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]"));
    public SelenideElement ChooseConnectedService = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.EditText"));
    public SelenideElement ChooseTheFirstOne = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.TextView"));
    public SelenideElement ChooseTheReason = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.EditText"));
    public SelenideElement ChooseTheFirstReason = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]"));
    public SelenideElement CommunicationTextField = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.EditText"));



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

    @Step("Создание обращения на качество обслуживания")
    public void ServiceQualityAppeals(){
        LSChange.click();
        ExactLS.click();
        sleep(3000);
        AppealsModule.click();
        CreateAppeal.click();
        ServiceQuality.click();
        FieldOfAppeal.sendKeys("Тест, прошу отменить обращение");
        SendItOut.click();
        NextUpAppeal.click();
    }

//    @Step("Создание обращения по вопросам по начислениям")
//    public void ChargesQuestions(){
//        CreateAppeal.click();
//        ChargesQuestionsButton.click();
//        FieldOfAppeal.sendKeys("Тест, прошу отменить обращение");
//        SendItOut.click();
//        NextUpAppeal.click();
//    }

    @Step("Создание обращения на качество услуг связи")
    public void CommunicationServiceQuality(){
        CreateAppeal.click();
        CommunicationServiceButton.click();
        ChooseConnectedService.click();
        ChooseTheFirstOne.click();
        ChooseTheReason.click();
        ChooseTheFirstReason.click();
        CommunicationTextField.sendKeys("Тест, прошу отменить обращение");
        SendItOut.click();
        NextUpAppeal.click();
    }



}