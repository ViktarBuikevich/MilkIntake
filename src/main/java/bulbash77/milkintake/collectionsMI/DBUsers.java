package bulbash77.milkintake.collectionsMI;

import bulbash77.milkintake.CollectionsCrUD;
import bulbash77.milkintake.db.MySqlConnection;
import bulbash77.milkintake.objects.Car;
import bulbash77.milkintake.objects.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        try(Connection con = MySqlConnection.getDbConnection();
            Statement statement = con.createStatement();
            ResultSet rs=statement.executeQuery("select * from users");) {
            while(rs.next()){
                User user=new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.getPassw(rs.getString("password"));
                user.setRole(rs.getInt("role"));
                usersList.add(user);
            }
        }
        catch (SQLException ex){
            Logger.getLogger(DBUsers.class.getName()).log(Level.SEVERE,null,ex);
        }
        //return null;
    }

    @Override
    public ObservableList find(String text) {
        return null;
    }
}
