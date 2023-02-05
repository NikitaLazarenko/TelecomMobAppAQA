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


}
