package training.view;

import training.controller.ResourceController;
import java.util.Locale;

/**
 * Class contains:
 * constants for bundles
 * Resource Controller field, to manage bundles
 */
public class View {

    public final String WELCOME = "interface.welcome";
    public final String YOUR_NICK_NAME = "record.nickname";
    public final String YOUR_ADRESS_STRING = "record.addressstring";
    public final String TRY_AGAIN = "invalid.tryagain";
    public final String DO_YOU_WANT_TO_CONTINUE = "record.continue";
    public final String MENU = "record.menu";
    public final String INPUT_EXCEPTION="record.input.exception";

    public final String FIRST_NAME_REQUEST = "record.firstname";
    public final String LAST_NAME_REQUEST = "record.lastname";
    public final String PATRONIM_REQUEST = "record.patronim";
    public final String NICKNAME_REQUEST = "record.nickname";
    public final String PHONE_NUMBER_REQUEST = "record.phonenumber";
    public final String ADDTIONAL_NUMBER_REQUEST = "record.additionalnumber";
    public final String HOME_NUMBER_REQUEST = "record.homenumber";
    public final String EMAIL_REQUEST = "record.email";
    public final String SKYPE_REQUEST = "record.skype";
    public final String GROUP_NUMBER_REQUEST = "record.groupnumber";
    public final String COMMENT_REQUEST = "record.comment";

    public final String INDEX_REQUEST = "record.address.index";
    public final String CITY_REQUEST = "record.address.city";
    public final String STREET_REQUEST = "record.address.street";
    public final String HOUSE_NUMBER_REQUEST = "record.address.housenumber";
    public final String APARTMENT_REQUEST = "record.address.apartmentnumber";

    public final String FIRST_NAME_INVALID = "invalid.firstname";
    public final String LAST_NAME_INVALID = "invalid.lastname";
    public final String PATRONIM_INVALID = "invalid.patronim";
    public final String PHONE_NUMBER_INVALID = "invalid.phonenumber";
    public final String ADDTIONAL_NUMBER_INVALID = "invalid.phonenumber";
    public final String HOME_NUMBER_INVALID = "invalid.homenumber";
    public final String EMAIL_INVALID = "invalid.email";
    public final String SKYPE_INVALID = "invalid.skype";
    public final String GROUP_NUMBER_INVALID = "invalid.groupnumber";

    public final String INDEX_INVALID = "invalid.address.index";
    public final String CITY_INVALID = "invalid.address.city";
    public final String STREET_INVALID = "invalid.address.street";
    public final String HOUSE_NUMBER_INVALID = "invalid.address.housenumber";
    public final String APARTMENT_INVALID = "invalid.address.apartmentnumber";

    public final String FIRST_NAME_REGEXP = "firstname.en.regexp";
    public final String LAST_NAME_REGEXP = "lastname.en.regexp";
    public final String PATRONIM_REGEXP = "patronim.en.regexp";
    public final String PHONE_NUMBER_REGEXP = "mobilephone.regexp";
    public final String ADDTIONAL_NUMBER_REGEXP = "mobilephone.regexp";
    public final String HOME_NUMBER_REGEXP = "stationaryphone.regexp";
    public final String EMAIL_REGEXP = "email.regexp";
    public final String SKYPE_REGEXP = "skype.regexp";

    public final String INDEX_REGEXP = "index.regexp";
    public final String CITY_REGEXP = "city.regexp";
    public final String STREET_REGEXP = "street.regexp";
    public final String HOUSE_NUMBER_REGEXP = "housenumber.regexp";
    public final String APARTMENT_REGEXP = "apartmentnumber.regexp";

    private ResourceController resourceController;
    public View(){
        this.resourceController = ResourceController.USER_INTERFACE;
    }
    public void viewMessage(String message){
        System.out.println(message);
    }
    public void viewErrorMessage(String message){System.err.println(message);}
    public void changeResource(Locale locale) {
        resourceController.changeResource(locale);
    }
    public String getString(String string){
        return resourceController.getString(string);
    }

}

