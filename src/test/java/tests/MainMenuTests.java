package tests;


import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import io.qameta.allure.Description;
import pages.AuthorizationMP;
import pages.MainPage;
import pages.SearchPage;
import pages.Adm;

public class MainMenuTests extends BaseTest {

    private static MainPage mainPage;

    @BeforeAll
    public static void init() {
        mainPage = new MainPage();
    }

//    @Description("Категории на главном экране имеют текст")
//    @Test
//    public void testCategories10items(){
//        List<String> categoriesNameExpected = Arrays.asList(
//                "Каталог", "Электроника", "Одежда и обувь",
//                "Доставка от 30 минут", "Автомобили", "Рассрочка от Ozon",
//                "Акции", "Отели и билеты", "Красота и здоровье", "Premium");
//        mainPage.closePopUp()
//                .checkCategoriesHasTexts(categoriesNameExpected);
//    }
//
//    @Description("Переход в другое меню делает кнопку не активной")
//    @Test
//    public void testGoToAnotherMenuIconNotSelected(){
//        mainPage.closePopUp();
//        mainPage.checkMainMenuButtonIsSelected();
//        mainPage.openCatalog().isMainMenuIconSelected();
//        mainPage.checkMainMenuButtonIsNotSelected();
//    }
//
//    @Test
//    @Description("Добавляем товар в корзину")
//    public void testAddItemToCart(){
//        String searchItem = "projector";
//        SearchPage searchPage = mainPage.closePopUp().search(searchItem);
//        String fullName = searchPage.getFirstFoundedFullItemName();
//
//        searchPage.openFirstFoundItemByTextContains()
//                .addToCart()
//                .openCart()
//                .closePop()
//                .assertItemsCount(1)
//                .assertItemNameInCart(fullName);
//    }

    @Test
    @DisplayName ("Авторизация")
    public void AuthorizationMP(){
        Adm adm = new Adm();
        adm.authorizationMP().CheckBody();
//        adm.authorizationMP().AuthItself();
//        adm.authorizationMP().PinSetting();
    }

    @Test
    @DisplayName("Детализация по выставленным счетам и истории платежей")
    public void Detailing(){
        Adm adm = new Adm();
        adm.detailing().CheckBodyDet();
    }

    @Test
    @DisplayName("Корректная загрузка / отображения неавторизованной зоны")
    public void UnauthorizedZoneCheck(){
        Adm adm = new Adm();
        adm.unauthorizedZoneCheck().CheckBody();
    }

    @Test
    @DisplayName("Корректная загрузка / отображения авторизованной зоны")
    public void AuthorizedZoneCheck(){
        Adm adm = new Adm();
        adm.authorizedZoneCheck().CheckBody();
    }

    @Test
    @DisplayName("Онбординг")
    public void OnboardingMP(){
        Adm adm = new Adm();
        adm.onboardingMP().CheckBody();
    }

    @Test
    @DisplayName("Подключение услуги на новый адрес (кейс: одна услуга)")
    public void ConnectingServiceToANewAddress(){
        Adm adm = new Adm();
        adm.connectingServiceToANewAddress().CheckBody();
    }

    @Test
    @DisplayName("Оплата KtPay")
    public void PaymentMP(){
        Adm adm = new Adm();
        adm.paymentMP().CheckBody();
    }

    @Test
    @DisplayName("Проверка раздела 'Мои услуги'")
    public void MyServicesMP(){
        Adm adm = new Adm();
        adm.myServicesMP().CheckBody();
    }

    @Test
    @DisplayName("Проверка раздела 'О приложении'")
    public void AboutAppMP(){
        Adm adm = new Adm();
        adm.aboutAppMP().CheckBody();
    }

    @Test
    @DisplayName("Проверка создания обращений")
    public void CreatingAppealsMP(){
        Adm adm = new Adm();
        adm.creatingAppealsMP().CheckBody();
    }

    @Test
    @DisplayName("Переключение между лицевыми счетами")
    public void SwitchBetweenLsMP(){
        Adm adm = new Adm();
        adm.switchBetweenLsMP().CheckBody();
    }


}
