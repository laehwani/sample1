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
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Mapper
public interface TodoDao {

    @Select("SELECT t.id, t.todo, t.inserted, COUNT(f.todoId) numOfFiles\n"
       + "FROM todo t\n"
       + "         LEFT JOIN todoFile f ON t.id = f.todoId\n"
       + "GROUP BY t.id\n"
       + "ORDER BY t.id DESC; ")
    public List<Todo> list();

    @Insert("""
       INSERT INTO todo(todo)
       VALUE (#{todo})
       """)

    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int insert(Todo todo);

    @Insert("""
INSERT INTO todoFile(todoId, name) 
VALUES (#{todo.id}, #{fileName})
""")

    int insertFlie(Todo todo, String fileName);

    @Select("""
        SELECT name
        FROM todoFile
        WHERE todoId = #{todoId}
        """)
    List<String> selectFilesByTodoId(Integer todoId);
}
