package training.exceptions;

public class LoginMismatchException extends Exception{

    private final String LOGIN_EXISTS_MSG = "Login already exists! Try another login.";
    public String getMessage(){
        return this.LOGIN_EXISTS_MSG;
    }

}
