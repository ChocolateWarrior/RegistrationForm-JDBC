package training;

import training.controller.Controller;
import training.model.dao.DaoFactory;
import training.model.dao.UserDao;
import training.model.dao.imp.JDBCDaoFactory;
import training.model.dao.imp.JDBCUserDao;
import training.model.entity.AccountancyBook;
import training.reader.ConsoleReader;
import training.view.View;

public class Main {

    public static void main(String[] args) {

//        DaoFactory factory = DaoFactory.getInstance();
//        UserDao dao = factory.createUserDao();
//        System.out.println(dao.findAll());

        View view = new View();
        AccountancyBook accountancyBook= new AccountancyBook();
        ConsoleReader consoleReader = new ConsoleReader();
        JDBCDaoFactory jdbcDaoFactory = new JDBCDaoFactory();
        UserDao jdbcUserDao = jdbcDaoFactory.createUserDao();

        Controller controller = new Controller(view, accountancyBook, consoleReader,jdbcUserDao);
        controller.registerUser();
    }
}
