package com.marcus.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcus.todo.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
