package bulbash77.milkintake.collectionsMI;

import bulbash77.milkintake.CollectionsCrUD;
import bulbash77.milkintake.db.MySqlConnection;
import bulbash77.milkintake.objects.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUsers implements CollectionsCrUD<User> {
    private ObservableList<User> usersList = FXCollections.observableArrayList();

    @Override
    public boolean insert(User obj) {
        return false;
    }

    @Override
    public boolean update(User obj) {
        return true;
    }

    @Override
    public boolean delete(User obj) {
        return true;
    }

    @Override
    public ObservableList fillAll() throws SQLException, ClassNotFoundException {
        try (Connection con = MySqlConnection.getDbConnection();
             Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery("select * from users");) {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getInt("role"));
                usersList.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usersList;
    }

    @Override
    public ObservableList find(String text) {
        return null;
    }

    public static User getUserFromDB(String login, String password) {
        User user = new User();
        String select = "SELECT id, login, password, role FROM users WHERE login = ? AND password =? LIMIT 1";
        try (Connection con = MySqlConnection.getDbConnection()) {
            PreparedStatement prSt = con.prepareStatement(select);
            prSt.setString(1, login);
            prSt.setString(2, password);
            ResultSet rs = prSt.executeQuery();

            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getInt("role"));
            }

        } catch (SQLException e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
        }

        return user;
    }

}
