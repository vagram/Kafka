package com.example.kafka.dao;

import com.example.kafka.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Integer> {
}
