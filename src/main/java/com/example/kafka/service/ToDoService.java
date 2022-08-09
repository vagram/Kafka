package com.example.kafka.service;

import com.example.kafka.entity.ToDo;

import java.util.List;

public interface ToDoService {
    List<ToDo> getAll();
    void send();
}
