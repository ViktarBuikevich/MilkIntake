package bulbash77.milkintake.db;

import bulbash77.milkintake.objects.User;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Config {
    //ToDO: организовать чтение из файла
    protected static final String dbHost = "host";
    protected static final String dbPort = "port";
    protected static final String dbUser = "login";
    protected static final String dbPassw = "password";
    protected static final String dbName = "dataBase";
    public static User currentUser;
    private static Properties properties = new Properties(); //частный случай ассоциативного массива(имя:значение)

    // метод возращает значение свойства по имени
    public synchronized static String getProperty(String name) {
        //при первом обращении к properties загрузим значения из файла
        if (properties.isEmpty()) {
            //открываем поток чтения из файла dao.properties
            //String dirParent = Paths.get("").toAbsolutePath().toString()+File.separator;
            String filePath = Paths.get("").toAbsolutePath().toString() + File.separator + "dao.properties";

            Path path = Paths.get(filePath);
            path = Path.of(filePath); // System.out.println("File toAbsolutePath: "+path.toAbsolutePath());
            if (!Files.isRegularFile(path)) {
                System.out.println("File doesn't exist or program doesn't have access " +
                        "to the file");
                try (FileWriter fr = new FileWriter(filePath)) {
                    String data = "host = localhost\n" +
                            "port = 3306\n" +
                            "login = admin\n" +
                            "password = QazWsxEdc772534\n" +
                            "dataBase = milk_intake";
                    fr.write(data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("File exists!!");
            }

//            try (InputStream is = Config.class.getClassLoader().getResourceAsStream(filePath)) {
//
//                    properties.load(is);
//
//            } catch (IOException e) {
//                System.out.println("!!!!! ERROR !!!!! "+e.toString());
//                e.printStackTrace();
//                throw new RuntimeException(e);
//            } catch (InvocationTargetException e0) {
//                System.out.println("!!!!! ERROR !!!!! "+e0.toString());
//                e0.printStackTrace();
//            }
            try (FileInputStream fis = new FileInputStream(filePath)) {
                //fis = new FileInputStream("src/main/resources/config.properties");
                properties.load(fis);

                String host = properties.getProperty("host");
                String port = properties.getProperty("port");
                String login = properties.getProperty("login");
                String password = properties.getProperty("password");
                String dataBase = properties.getProperty("dataBase");

                System.out.println("HOST: " + host
                        + ", PORT: " + port
                        + ", LOGIN: " + login
                        + ", PASSWORD: " + password
                        + ", DATABASE: " + dataBase);

            } catch (IOException e) {
                System.err.println("ОШИБКА: Файл свойств отсуствует!");
            }
        }
        return properties.getProperty(name);
    }
}
