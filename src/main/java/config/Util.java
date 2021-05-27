package config;
import entity.Account;
import entity.Card;
import entity.Client;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry standardServiceRegistry;
//    private static String hostName = "localhost";
//    private static String dbName = "";
//    private static String userName = "";
//    private static String password = "";
    private static String connectionURL = "jdbc:h2:~/default";


    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "org.h2.Driver");
                settings.put(Environment.URL,"jdbc:h2:./src/main/resources/bank;DB_CLOSE_ON_EXIT=FALSE;AUTO_SERVER=TRUE");
//                settings.put(Environment.USER, userName);
//                settings.put(Environment.PASS, password);
                settings.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(Card.class);
                configuration.addAnnotatedClass(Client.class);
                configuration.addAnnotatedClass(Account.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    /*-----------------------------------------------------*/
    public static Connection getMySQLConnection() {

        return getMyConnection();
    }

    private static Connection getMyConnection() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(connectionURL);
            if (!conn.isClosed()) {
                System.out.println("Соединение с БД установленно!");
            }
        } catch (SQLException e) {
            System.err.println("Не удалось загрузить класс драйвера");
        }
        return conn;
    }


}