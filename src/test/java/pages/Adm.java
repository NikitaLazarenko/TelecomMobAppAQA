package pages;

public class Adm extends BasePage{

public AuthorizationMP authorizationMP(){
    AuthorizationMP authorizationMP = new AuthorizationMP();
    return authorizationMP;
}

public Detailing detailing() {
    Detailing detailing = new Detailing();
    return detailing;
}

public UnauthorizedZoneCheck unauthorizedZoneCheck() {
    UnauthorizedZoneCheck unauthorizedZoneCheck = new UnauthorizedZoneCheck();
    return unauthorizedZoneCheck;
}

public AuthorizedZoneCheck authorizedZoneCheck() {
    AuthorizedZoneCheck authorizedZoneCheck = new AuthorizedZoneCheck();
    return authorizedZoneCheck;
}

public OnboardingMP onboardingMP(){
    OnboardingMP onboardingMP = new OnboardingMP();
    return onboardingMP;
}

public ConnectingServiceToANewAddress connectingServiceToANewAddress(){
    ConnectingServiceToANewAddress connectingServiceToANewAddress = new ConnectingServiceToANewAddress();
    return connectingServiceToANewAddress;
}

public PaymentMP paymentMP(){
    PaymentMP paymentMP = new PaymentMP();
    return paymentMP;
}

public MyServicesMP myServicesMP(){
    MyServicesMP myServicesMP = new MyServicesMP();
    return myServicesMP;
}

public AboutAppMP aboutAppMP(){
    AboutAppMP aboutAppMP = new AboutAppMP();
    return aboutAppMP;
}


}
