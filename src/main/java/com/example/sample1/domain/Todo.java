package com.example.sample1.domain;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Todo {
    private Integer id;
    private String todo;
    private LocalDateTime inserted;
    private Integer numOfFiles;

}
