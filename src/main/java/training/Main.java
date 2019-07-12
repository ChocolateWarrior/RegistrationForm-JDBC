package training;

import training.controller.Controller;
import training.model.dao.UserDao;
import training.model.dao.imp.JDBCDaoFactory;
import training.reader.ConsoleReader;
import training.view.View;

public class Main {

    public static void main(String[] args) {

        View view = new View();
        ConsoleReader consoleReader = new ConsoleReader();
        JDBCDaoFactory jdbcDaoFactory = new JDBCDaoFactory();
        UserDao jdbcUserDao = jdbcDaoFactory.createUserDao();

        Controller controller = new Controller(view, consoleReader,jdbcUserDao);
        controller.registerUser();
    }
}
