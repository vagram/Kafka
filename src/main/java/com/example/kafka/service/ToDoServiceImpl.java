package com.example.kafka.service;

import com.example.kafka.dao.ToDoRepository;
import com.example.kafka.entity.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ToDoServiceImpl implements ToDoService{
    @Autowired
    private ToDoRepository toDoRepository;

    @Autowired
    private KafkaTemplate<String, ToDo> kafkaTemplate;

    @Override
    public List<ToDo> getAll() {
        return toDoRepository.findAll();
    }

    @Override
    public void send() {
        //making pause 10000 millseconds for imitation as server has a hard loading
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        List<ToDo> toDos = toDoRepository.findAll();
        toDos.forEach(toDo -> kafkaTemplate.send("test", toDo));

    }
}
