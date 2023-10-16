package com.example.sample1.dao;

import com.example.sample1.domain.Todo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import javax.swing.table.TableRowSorter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TodoDao {

    @Autowired
    private DataSource dataSource;
    
    public List<Todo> list() throws SQLException {
        String sql = "SELECT * FROM todo ORDER BY id DESC";

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        List<Todo> list = new ArrayList<>();
        try (connection; statement; resultSet) {
            while (resultSet.next()) {
                Todo todo = new Todo();
                todo.setId(resultSet.getInt("id"));
                todo.setTodo(resultSet.getString(("")));
                todo.setInserted(resultSet.getString());
            }

        }

        return null;    
    }

    public void insert(Todo todo) throws SQLException {
        String sql = """
                INSERT INTO todo(todo)
        
            """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        try (connection; statement) {
            statement.setString(1, todo.getTodo());
            int rows = statement.executeUpdate();

            return rows == 1;

        }
        return false;
    }
}