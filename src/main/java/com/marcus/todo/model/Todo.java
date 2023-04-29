package com.marcus.todo.model;

import java.time.LocalDateTime;

import org.springframework.cglib.core.Local;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String description;

  @Column
  private Boolean done;

  @Column
  private LocalDateTime doneDate;

  @Column
  @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
  private LocalDateTime createDate;

  @PrePersist
  public void beforSave() {
    setCreateDate(LocalDateTime.now());
  }

}
