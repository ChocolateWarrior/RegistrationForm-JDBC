package training.controller;

import training.exceptions.LoginMismatchException;
import training.model.dao.UserDao;
import training.model.dao.imp.JDBCUserDao;
import training.model.entity.AccountancyBook;
import training.model.entity.User;
import training.reader.ConsoleReader;
import training.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {

    private final String FIRST_NAME_REGEXP = "firstname.en.regexp";
    private final String LAST_NAME_REGEXP = "lastname.en.regexp";
    private final String PATRONIM_REGEXP = "patronim.en.regexp";
    private final String NICKNAME_REGEXP = "nickname.regexp";
    private final String PHONE_NUMBER_REGEXP = "mobilephone.regexp";
    public final String ADDTIONAL_NUMBER_REGEXP = "mobilephone.regexp";
    public final String HOME_NUMBER_REGEXP = "stationaryphone.regexp";
    private final String EMAIL_REGEXP = "email.regexp";
    private final String SKYPE_REGEXP = "skype.regexp";

    public final String INDEX_REGEXP = "index.regexp";
    public final String CITY_REGEXP = "city.regexp";
    public final String STREET_REGEXP = "street.regexp";
    public final String HOUSE_NUMBER_REGEXP = "housenumber.regexp";
    public final String APARTMENT_REGEXP = "apartmentnumber.regexp";

    private final String RESOURCE_NAME = "property.regex";
    private UserDao jdbcUserDao;
    private AccountancyBook accountancyBook;
    private ResourceBundle resourceBundle;
    private ConsoleReader consoleReader;
    private Locale locale;
    private View view;

    public Controller(View view, AccountancyBook accountancyBook, ConsoleReader consoleReader, UserDao jdbcUserDao){
        this.accountancyBook = accountancyBook;
        this.view = view;
        this.consoleReader = consoleReader;
        this.locale = new Locale("en");
        this.jdbcUserDao=jdbcUserDao;
        resourceBundle = ResourceBundle.getBundle(RESOURCE_NAME, Locale.getDefault());
    }

    private String getString(String string){
        return resourceBundle.getString(string);
    }

    private boolean checkByPattern(String toCheck, String regexp){
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(toCheck);
        return matcher.find();
    }

    private String processForm(String stringToCheck, String regexpString){ //DEFECT

        stringToCheck = consoleReader.getLine();
        while(!checkByPattern(stringToCheck, regexpString)){
            view.viewMessage(view.getString(view.TRY_AGAIN));
            stringToCheck = consoleReader.getLine();

        }
        view.viewMessage("Your input: " + stringToCheck + ". Confirmed!");
        return stringToCheck;
    }

    private void checkForLoginDuplication (String loginToCheck) throws LoginMismatchException {
        boolean res = false;
        List<User> users  = jdbcUserDao.findAll();
        for(User rec : users){
            System.out.println("Rec nickname: " + rec.getLogin() + "\n" +
                    "Input nickname: " + loginToCheck);
            if(rec.getLogin().equals(loginToCheck)) res = true;
        }

        if(res)throw new LoginMismatchException();

//        return res;
    }

    private void changeLanguage(){

        if(locale.getLanguage().equals("en")){
            locale = new Locale("uk");
        } else {
            locale = new Locale("en");
        }

        view.changeResource(locale);

    }

    private void showMenu(){
        view.viewMessage(view.getString(view.MENU));
    }

    private int getUserNumber() throws java.lang.NumberFormatException{
        int result;
        result = Integer.parseInt(consoleReader.getLine());
        return result;
    }

    private String getAll(){
        return jdbcUserDao.findAll().toString();
    }

    public void registerUser(){

        int choice = 0;

        view.viewMessage(view.getString(view.WELCOME));
        label: while (true){
            showMenu();

            try {
                choice = getUserNumber();
            }catch (java.lang.NumberFormatException e){
                view.viewErrorMessage(view.getString(view.INPUT_EXCEPTION));
                view.viewErrorMessage(view.getString(view.TRY_AGAIN));
                continue;
            }

            switch (choice){

                case 1:
//                    view.viewMessage(view.getString(view.OPTION1));
                    User userToAdd;
                    String firstName = "";
                    String lastName = "";
                    String login = "";
                    String phoneNumber = "";
                    try {

                        firstName = processForm(firstName, getString(FIRST_NAME_REGEXP));
                        view.viewMessage(view.getString(view.LAST_NAME_REQUEST));
                        lastName = processForm(lastName, getString(LAST_NAME_REGEXP));
                        view.viewMessage(view.getString(view.PATRONIM_REQUEST));
                        login = processForm(login, getString(NICKNAME_REGEXP));
                        checkForLoginDuplication(login);
                        phoneNumber = processForm(phoneNumber, getString(PHONE_NUMBER_REGEXP));

                        userToAdd = new User(firstName,lastName,login,phoneNumber);
                        jdbcUserDao.create(userToAdd);

                    }catch (java.lang.NumberFormatException e){
                        view.viewErrorMessage(view.getString(view.INPUT_EXCEPTION));
                        view.viewErrorMessage(view.getString(view.TRY_AGAIN));
                        break;
                    }
                    catch (LoginMismatchException e){
                        view.viewErrorMessage(view.getString(view.INPUT_EXCEPTION));
                        view.viewErrorMessage(view.getString(view.TRY_AGAIN));
                        break;
                    }

                    view.viewMessage("Created User!");

                    break;

                case 2:
//                    view.viewMessage(view.getString(view.OPTION2));
                    view.viewMessage("All users:");
                    view.viewMessage(getAll());
                    break;

                case 3:
                    changeLanguage();
                    view.viewMessage("Language changed!");

//                    view.viewMessage(view.getString(view.OPTION5));
                    break;

                case 4:
                    view.viewMessage("GBYE!");

//                    view.viewMessage(view.getString(view.BYE));
                    break label;

                default:
                    view.viewMessage(view.getString(view.INPUT_EXCEPTION));
                    view.viewErrorMessage(view.getString(view.TRY_AGAIN));
                    break;

            }
        }

//
//        Record recordToPush;
//        String firstName = "";
//        String lastName = "";
//        String patronim = "";
//        String email = "";
//        String skype = "";
//        String mobilePhone = "";
//
//        view.viewMessage(view.getString(view.WELCOME));
//        view.viewMessage(view.getString(view.FIRST_NAME_REQUEST));
//
//        firstName = processForm(firstName, getString(FIRST_NAME_REGEXP));
//        view.viewMessage(view.getString(view.LAST_NAME_REQUEST));
//        lastName = processForm(lastName, getString(LAST_NAME_REGEXP));
//        view.viewMessage(view.getString(view.PATRONIM_REQUEST));
//        patronim = processForm(patronim, getString(PATRONIM_REGEXP));
//        view.viewMessage(view.getString(view.EMAIL_REQUEST));
//        email = processForm(email, getString(EMAIL_REGEXP));
//        view.viewMessage(view.getString(view.SKYPE_REQUEST));
//        skype = processForm(skype, getString(SKYPE_REGEXP));
//        view.viewMessage(view.getString(view.PHONE_NUMBER_REQUEST));
//        mobilePhone = processForm(mobilePhone, getString(PHONE_NUMBER_REGEXP));
//
//        recordToPush = new Record(firstName,lastName,patronim,mobilePhone,email,skype);
//        AccountancyBook.pushRecord(recordToPush);

    }

}
