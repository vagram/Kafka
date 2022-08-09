package com.example.kafka.controller;

import com.example.kafka.dao.ToDoRepository;
import com.example.kafka.entity.ToDo;
import com.example.kafka.service.ToDoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @GetMapping("")
    public List<ToDo> findAll(){
        toDoService.send();
        return toDoService.getAll();
    }
}
