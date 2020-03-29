package mapper;

import domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserMapper {

    private Map<Integer, User> identityMap = new HashMap<>();

    private final Connection connection;

    public UserMapper(Connection connection) {
        this.connection = connection;
    }

    public void insert(User user) throws SQLException {
        String insertSql = "INSERT into users values(?);";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insertSql);
            statement.setString(1, user.getName());
            statement.executeUpdate();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }

    }

    public void update(User user) throws SQLException {
        PreparedStatement statement = null;
        String insertSql = "Update users SET name = ? WHERE id = ?;";
        try {
            statement = connection.prepareStatement(insertSql);
            statement.setString(1, user.getName());
            statement.setInt(2, user.getId());
            statement.executeUpdate();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }

        identityMap.put(user.getId(), user);
    }

    public User findById(int id) throws SQLException {
        if (identityMap.containsKey(id)) {
            return identityMap.get(id);
        }
        PreparedStatement statement = null;
        User user = null;
        String selectSql = "SELECT * from users WHERE id = ?;";
        try {
            statement = connection.prepareStatement(selectSql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                user = new User(resultSet.getInt(1), resultSet.getString(2));  // portfolio и orderlist достанем когда понадобится
            }
        } finally {
            if (statement != null) {
                statement.close();
            }
        }

        return user;
    }

    public void delete(User user) throws SQLException {
        identityMap.remove(user.getId());

        PreparedStatement statement = null;
        String insertSql = "DELETE from users WHERE id = ?;";
        try {
            statement = connection.prepareStatement(insertSql);
            statement.setInt(1, user.getId());
            statement.executeUpdate();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }
}
