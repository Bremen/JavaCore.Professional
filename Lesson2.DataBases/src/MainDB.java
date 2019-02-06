/*
1. Сформировать таблицу товаров (id, prodid, title, cost) запросом из Java-приложения:
id – порядковый номер записи, первичный ключ;
prodid – уникальный номер товара;
title – название товара;
cost – стоимость.

2. При запуске приложения очистить таблицу и заполнить 10000 товаров вида:
id_товара 1 товар1 10
id_товара 2 товар2 20
id_товара 3 товар3 30
id_товара 10000 товар10000 100000
 */


import java.sql.*;

public class MainDB {

    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pstmt;

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        stmt = connection.createStatement();
    }

    public static void disconnect() throws ClassNotFoundException, SQLException {
        connection.close();
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        try {
            connect();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        stmt.execute("CREATE TABLE IF NOT EXISTS products(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE, " +
                "prodid INTEGER NOT NULL UNIQUE, " +
                "title TEXT NOT NULL, " +
                "cost REAL NOT NULL)");

        stmt.execute("DELETE from products");
        stmt.execute("UPDATE SQLITE_SEQUENCE SET SEQ=0 WHERE NAME='products'");

         long t = System.currentTimeMillis();

        connection.setAutoCommit(false);


        pstmt = connection.prepareStatement("INSERT INTO products (prodid, title, cost)\n" +
                "VALUES (?, ?, ?)");

        for (int i = 1; i <= 10000; i++) {
            pstmt.setInt(1, i);
            pstmt.setString(2, "товар" + i);
            pstmt.setInt(3, i * 10);
            pstmt.addBatch();
        }

        pstmt.executeBatch();

        connection.setAutoCommit(true);

        System.out.println(System.currentTimeMillis() - t);

        disconnect();
    }
}
