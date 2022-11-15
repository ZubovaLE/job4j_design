package ru.job4j.jdbc;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {
    private Connection connection;

    private boolean connect() throws IOException, ClassNotFoundException, SQLException {
        try (InputStream input = TableEditor.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties props = new Properties();
            props.load(input);
            Class.forName(props.getProperty("driver_class"));
            this.connection = DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));

        }
        return this.connection != null;
    }

    private void resolveQuery(String query) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            
        }
    }

    public TableEditor() throws SQLException, IOException, ClassNotFoundException {
        initConnection();
    }

    public void initConnection() throws SQLException, IOException, ClassNotFoundException {
        if (!connect()) {
            throw new IllegalArgumentException();
        }
    }

    public void createTable(String tableName) throws SQLException {
        String sql = String.format(
                "CREATE TABLE IF NOT EXISTS %s(%s, %s);",
                tableName,
                "id SERIAL PRIMARY KEY",
                "name VARCHAR(255)"
        );
        resolveQuery(sql);
    }

    public void dropTable(String tableName) throws SQLException {
        String sql = String.format(
                "DROP TABLE %s;",
                tableName
        );
        resolveQuery(sql);
    }

    public void addColumn(String tableName, String columnName, String type) {
    }

    public void dropColumn(String tableName, String columnName) {
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        TableEditor table = new TableEditor();
        table.createTable("test_table");
    }
}
