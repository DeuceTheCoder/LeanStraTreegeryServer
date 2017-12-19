package com.thoughtworks.leanvaluetree.main.db;

import com.thoughtworks.leanvaluetree.main.Node;
import com.thoughtworks.leanvaluetree.main.ValueTree;

import java.sql.*;

public class PostgresRepo implements Repository {

    private Connection connection;

    public PostgresRepo(String connectionString) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ValueTree getTree() {
        ValueTree tree = new ValueTree();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM node;");

            while (resultSet.next()) {
                Node node = new Node();
                node.setId(resultSet.getLong("id"));
                node.setTitle(resultSet.getString("title"));
                node.setDescription(resultSet.getString("description"));
                node.setParentId(resultSet.getLong("parentId"));

                tree.addNode(node);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tree;
    }
}
