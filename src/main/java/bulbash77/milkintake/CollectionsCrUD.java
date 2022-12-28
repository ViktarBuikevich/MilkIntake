package bulbash77.milkintake;

import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface CollectionsCrUD<T>{
        // добавить запись
        boolean insert(T obj);

        // внести измененные значения (подтвердить измененные данные)
        boolean update(T obj);

        // удалить запись
        boolean delete(T obj);

        ObservableList<T> fillAll() throws SQLException, ClassNotFoundException;

        ObservableList<T> find(String text);
}
