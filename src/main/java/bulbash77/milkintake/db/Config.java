package bulbash77.milkintake.db;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    //ToDO: организовать чтение из файла config.txt
    protected static final String dbHost = "host";
    protected static final String dbPort = "port";
    protected static final String dbUser = "login";
    protected static final String dbPassw = "password";
    protected static final String dbName = "DataBase";
    private static Properties properties= new Properties(); //частный случай ассоциативного массива(имя:значение)
    // метод возращает значение свойства по имени
    public static String getProperty(String name){
        //при первом обращении к properties загрузим значения из файла
        if (properties.isEmpty()){
            //открываем поток чтения из файла dao.properties
            try(InputStream is= Config.class.getClassLoader().
                    getResourceAsStream("dao.properties")){
                properties.load(is);

            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return properties.getProperty(name);
    }
}
