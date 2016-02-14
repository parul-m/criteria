package myconfig;

import dto.Employee;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class connection {
    public static SessionFactory getSessionFactory() {
        Properties prop = new Properties();
        prop.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        prop.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        prop.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/User");
        prop.put("hibernate.connection.username", "root");
        prop.put("hibernate.connection.password", "root");
        prop.put("hibernate.show_sql", "true");
        prop.put("hibernate.hbm2ddl.auto", "update");
        Configuration cfg = new Configuration();
        cfg.addProperties(prop);
        cfg.addAnnotatedClass(Employee.class);
        SessionFactory sf = cfg.buildSessionFactory();
        return sf;
    }
}
