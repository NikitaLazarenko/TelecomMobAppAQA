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

public class Detailing extends SearchPage{
    public void CheckBodyDet(){
        routeToTheAuth();
        AuthItself();
        PinSetting();
        DetailingTransition();
        DetailingCheck();
    }

    //Локаторы к каждому элементу:
    //Авторизация:
    public SelenideElement closePopUpButtonDet = $(MobileBy.id("kz.telecom.app:id/ic_close"));
    public SelenideElement LoginButtonMainPageDet = $(MobileBy.id("kz.telecom.app:id/tv_login"));
    public SelenideElement PhoneFieldDet = $(MobileBy.id("kz.telecom.app:id/et_phone_number"));
    public SelenideElement ContinueButtonAuthDet = $(MobileBy.className("android.widget.TextView"));
    public SelenideElement PasswordFieldDet = $(MobileBy.id("kz.telecom.app:id/et_password"));
    public SelenideElement FinalLogInButtonDet = $(MobileBy.xpath("/hierarchy/android.w" +
            "idget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout[2]/android.view.ViewGroup/android.widget.LinearLayout"));
    public SelenideElement Button1ForPinCodeDet = $(MobileBy.id("kz.telecom.app:id/pinDigit1"));
    public SelenideElement DetailingButton = $(MobileBy.xpath("//android.widget.FrameLayout[@content-desc=\"Детализация\"]/android.widget.ImageView"));
    public SelenideElement AuthPhoneFieldClose = $(MobileBy.id("kz.telecom.app:id/btn_close"));
    public SelenideElement BillsAndPaymentsButton = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup"));
    public SelenideElement BillsButton = $(MobileBy.xpath("//android.widget.LinearLayout[@content-desc=\"Выставленные счета\"]/android.widget.TextView"));
    public SelenideElement BillsHistoryButton = $(MobileBy.xpath("//android.widget.LinearLayout[@content-desc=\"Выставленные счета\"]/android.widget.TextView"));
    public SelenideElement BillForTheService = $(MobileBy.className("android.widget.TextView"));
    public SelenideElement BillDetails = $(MobileBy.id("kz.telecom.app:id/tv_title"));
    public SelenideElement SelectMonth = $(MobileBy.id("kz.telecom.app:id/tvTitle"));
    public SelenideElement December2022 = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.TextView"));
    public SelenideElement DownloadDetailsButton = $(MobileBy.id("kz.telecom.app:id/ic_more_options"));
    public SelenideElement DownloadPDF = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.TextView"));
    public SelenideElement DownloadXLS = $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.TextView"));
    public SelenideElement PDFopened = $(MobileBy.id("kz.telecom.app:id/pdf_viewer"));
    public SelenideElement BackFromPDF = $(MobileBy.id("kz.telecom.app:id/ic_back"));
    public SelenideElement PaymentsHistory = $(MobileBy.xpath("//android.widget.LinearLayout[@content-desc=\"История платежей\"]"));

    @Step("Переход на страницу авторизации")
    public void routeToTheAuth() {
        closePopUpButtonDet.click();
        sleep(1000);
        LoginButtonMainPageDet.click();
        sleep(1000);
    }

    @Step("Авторизация")
    public void AuthItself() {
        PhoneFieldDet.click();
//        sleep(1000);
        PhoneFieldDet.sendKeys("7476993790");
        ContinueButtonAuthDet.click();
        PasswordFieldDet.click();
//        sleep(1000);
        PasswordFieldDet.sendKeys("Test176063");
//        sleep(500);
        FinalLogInButtonDet.click();
//        sleep(3000);
    }

    @Step("Ввод пинкода и открытие неавторизованной зоны")
    public void PinSetting() {
        Button1ForPinCodeDet.click();
        sleep(500);
        Button1ForPinCodeDet.click();
        sleep(500);
        Button1ForPinCodeDet.click();
        sleep(500);
        Button1ForPinCodeDet.click();
        sleep(1000);

        Button1ForPinCodeDet.click();
        sleep(500);
        Button1ForPinCodeDet.click();
        sleep(500);
        Button1ForPinCodeDet.click();
        sleep(500);
        Button1ForPinCodeDet.click();
        sleep(1000);

    }
    @Step("Переход в раздел детализации")
    public void DetailingTransition() {
//    sleep(3000);
    DetailingButton.click();
    }

    @Step("Проверка всех модулей/кнопок раздела детализации")
    public void DetailingCheck() {
        AuthPhoneFieldClose.click();
        DetailingButton.click();
        BillsAndPaymentsButton.click();
        BillsButton.shouldBe(Condition.visible);
        BillsHistoryButton.shouldBe(Condition.visible);
        BillForTheService.shouldBe(Condition.visible);
        BillDetails.shouldBe(Condition.visible);
        SelectMonth.click();
        December2022.click();
        SelectMonth.shouldHave(Condition.text("Декабрь 2022"));
        DownloadDetailsButton.click();
        DownloadPDF.click();
        PDFopened.shouldBe(Condition.visible);
        BackFromPDF.click();
        sleep(4000);
//        DownloadDetailsButton.click();
//        DownloadXLS.click();
//        PDFopened.shouldBe(Condition.visible);
//        BackFromPDF.click();
        PaymentsHistory.click();
        DownloadDetailsButton.click();
        DownloadPDF.click();
        PDFopened.shouldBe(Condition.visible);
        BackFromPDF.click();



    }

}
