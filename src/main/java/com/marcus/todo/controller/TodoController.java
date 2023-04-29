package com.marcus.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.marcus.todo.model.Todo;
import com.marcus.todo.repository.TodoRepository;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

  @Autowired
  private TodoRepository repository;

  @PostMapping
  public Todo save(@RequestBody Todo todo) {
    return repository.save(todo);
  }

  @GetMapping("{id}")
  public Todo getById(@PathVariable Long id) {
    return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }

}
