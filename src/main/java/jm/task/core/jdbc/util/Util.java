package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:postgresql://localhost:5434/postgres";
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "postgres";
    private static Connection connection;
    private static SessionFactory sessionFactory;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            connection = DriverManager.getConnection(URL,LOGIN,PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static SessionFactory getSessionFactory(){
        Configuration configuration = new Configuration().addAnnotatedClass(User.class);
        sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }

    public static Connection getConnection(){
        return connection;
    }
}