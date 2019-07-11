package training.model.dao.imp;

import training.model.dao.UserDao;
import training.model.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUserDao implements UserDao {

    private Connection connection;

    public JDBCUserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    private static User extractFromResultSet(ResultSet rs)
            throws SQLException {
        User result = new User();

        result.setId(rs.getInt("id"));
        result.setFirstName(rs.getString("first_name"));
        result.setLastName(rs.getString("last_name"));
        result.setLogin(rs.getString("login"));
        result.setMobilePhone(rs.getString("phone"));

        return result;
    }

    @Override
    public List<User> findAll() {
        List<User> resultList = new ArrayList<>();
        Map<Integer,User> users = new HashMap<>();
        try (Statement ps = connection.createStatement()){
            ResultSet rs = ps.executeQuery(
                    "SELECT * FROM users;");
            while ( rs.next() ){
                User user = extractFromResultSet(rs);
                user = makeUniqueUser( users, user);
                resultList.add(user);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    private User makeUniqueUser(Map<Integer, User> users,  User user) {
        users.putIfAbsent(user.getId(), user);
        return users.get(user.getId());
    }

    @Override
    public void create(User entity) {
        try(PreparedStatement ps = connection.prepareStatement
                ("INSERT INTO users (first_name, last_name, login, phone )" +
                    " VALUES (? ,?, ?, ? )")){
            ps.setString(1 , entity.getFirstName());
            ps.setString(2 , entity.getLastName());
            ps.setString(3 , entity.getLogin());
            ps.setString(4 , entity.getMobilePhone());
            ps.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }


    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() throws Exception {

    }
}
