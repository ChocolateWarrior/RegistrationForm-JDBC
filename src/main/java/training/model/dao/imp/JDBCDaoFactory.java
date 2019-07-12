package training.model.dao.imp;

import training.model.dao.DaoFactory;
import training.model.dao.UserDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {
    @Override
    public UserDao createUserDao() {
        return new JDBCUserDao(getConnection());
    }

    private Connection getConnection(){
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/reg_form_jdbc",
                    "helvetica" ,
                    "password" );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
